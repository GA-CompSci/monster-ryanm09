import java.util.Scanner;

public class App {
    //CLASS VARIABLE
    private static Monster[] monsters;
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
        //HOW MANY MONSTERS HAVE MORE THAN 50 HEALTH?
        System.out.println(monsterCount(50) + " monsters have more than 50 health");
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
