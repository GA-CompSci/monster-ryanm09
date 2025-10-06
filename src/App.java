import java.util.Scanner;

public class App {
    //CLASS VARIABLE
    private static Monster[] monsters;
    // PLAYER STATS - start max by default
    private static int health = 100;
    private static int speed = 10;
    private static int shield = 50;
    private static int damage = 50;
    private static int heal = 50;
    //PLAYER STATE
    private static boolean isDefending = false;
    
    public static void main(String[] args) throws Exception {
        System.out.println("----- MONSTER BATTLE! -----");
        Scanner input = new Scanner(System.in);
        System.out.print("How many monsters will you fight? ");
        int num = input.nextInt(); //TODO: handle errors if it's not a number
        monsters = new Monster[num];
        // build all the monsters
        for(int i = 0; i < monsters.length; i++){
            monsters[i] = new Monster(); //TODO: add some specials
        }

        // PICK YOUR BUILD
        // give options
            System.out.println("---- PICK YOUR BUILD ----");
            System.out.println("1) Fighter");
            System.out.println("2) Tank");
            System.out.println("3) Healer");
            System.out.println("4) Ninja");
            System.out.println("Choice: ");
            int choice = input.nextInt(); // TODO: Error handle on bad input
            // CUSTOMIZE THE BUILD
            if(choice == 1){
                //fighters have little healing and weak shield
                shield -= (int)(Math.random() * 45 + 1) + 5;
                heal -= (int)(Math.random() * 46) + 5;
            } else if(choice == 2){
                speed -= (int)(Math.random() * 9) + 1;
                damage -= (int)(Math.random() * 100) + 100;
            } else if(choice == 3){
                damage -= (int)(Math.random() * 26) + 5; 
                shield -= (int)(Math.random() * 46) + 5;
            } else {
                heal -= (int)(Math.random() * 46) + 5;
                health -= (int)(Math.random() * 21) + 5;
            }

        //DISPLAY MONSTER STATUS
        reportMonsters();

        // PICK A MONSTER
        Monster currentMonster = getNextMonster();
        
        //----GAME LOOP----
        while(monsterCount(0) > 0){
            // who goes first?
            isDefending = false;
            // give options
            System.out.println("---- OPTIONS ----");
            System.out.println("1) Attack");
            System.out.println("2) Defend");
            System.out.println("3) Heal");
            System.out.println("4) Pass");
            System.out.println("Choice");
            int move = input.nextInt(); // TODO: Error handle on bad input

            //ATTACK
            if(move == 1){
                int dmg = (int)(Math.random() * damage + 1);
                if(dmg == damage){
                    dmg = currentMonster.health(); //INSTAkill
                    System.out.println("Critical Hit! INSTAkill!");
                } 
                else if(dmg == 0) {
                    System.out.println(" --- Critical Miss, You Suck! Minus 10 HP! ---");
                    health -= 10;
                }
                else currentMonster.takeDamage(dmg);

            //DEFEND
            } else if(move == 2){
                isDefending = true;
                System.out.println("- SHIELD UP -");

            //HEAL
            } else if(move == 3){
                int h = (int)(Math.random() + heal + 1);
                health += h;
                System.out.println("You healed for " + h + " HP. Current HP: " + health);

            //PASS
            } else {
                speed ++;
                System.out.println("You have rested, speed increased. Current speed: " + speed);
            }

            // DO I NEED A NEW MONSTER?
            if(currentMonster.health() <= 0){
                System.out.println("\nYOU HAVE SLAIN A MONSTER!\n");
                currentMonster = getNextMonster();
                reportMonsters();
                continue; //take it from the top of the loop
            }

            //MONSTER'S TURN
            int speedCheck = (int)(Math.random() * 100);
            if(speedCheck >= speed){ //BONUS TURN
                System.out.println(" --- Bonus turn ---!");
                continue;
            } else {
                int incomingDamage = (int)(Math.random() * currentMonster.damage() + 1);
                if(isDefending) {
                    incomingDamage -= shield;
                    if(incomingDamage < 0) incomingDamage = 0; //don't go negative
                    System.out.println("CLANG! Your shield TANKED " + shield + " damage!");
                }
                health -= incomingDamage;
            }

            //is player defeated?
            if (health <= 0){
                System.out.println("\n\n --- YOU LOSE ---\n\n");
                break;
            }
        }
        
    }

        public static void reportMonsters(){
            System.out.println("\n----------- PLAYER REPORT -----------");
            System.out.println("HEALTH: " + health);
            System.out.println("ATTACK POWER: " + damage);
            System.out.println("SPEED: " + speed);
            System.out.println("SHIELD: " + shield);
            System.out.println("HEAL: " + heal);
            System.out.println("\n----------- MONSTER REPORT -----------");
            //a full traversal
            for(int i = 0; i < monsters.length; i++){
                System.out.print("[" + i + "]");
                System.out.println(" - Health: " + monsters[i].health());
                System.out.println(" - Damage: " + monsters[i].damage());
                System.out.println(" - Speed: " + monsters[i].speed());
                if(!monsters[i].special().equals("")) System.out.print(" - Special: " + monsters[i].special());

                //new line at the end of the loop
                System.out.println();

            }
        }

    /**
     * How many monsters have over the given healh
     * @param health number to check
     * @return number of monsters above that health
     */
    public static int monsterCount(int health){
        int count = 0;
        //traverse the monsters array and find out how many have < 50 health
        for(Monster m : monsters){
            if(m.health() > 50) count++;
        }
        return count;
    }

    public static Monster getNextMonster(){

        for(int i = 0; i < monsters.length; i++){
            if(monsters[i].health() > 0) return monsters[i];
        }
        return null;
    }

    
    
}
