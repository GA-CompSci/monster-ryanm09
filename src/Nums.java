import java.util.ArrayList;
import java.util.Scanner;

public class Nums {
    public static void main(String[] args){
        // ArrayLists are upgraded arrays with extra tools, like adding stuff to it
        ArrayList<String> names = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter name: ");
        String input = s.nextLine();
        //INPUT LOOP
        while(!input.equals("")){
            names.add(input);
            System.out.println("Enter name (empty to roll names): ");
            input = s.nextLine();
        }
        //OUTPUT LOOP
        while(!input.equalsIgnoreCase("quit") || names.size() == 0){
            int r = (int)(Math.random() * names.size());
            System.out.println("And the chosen name is.......... " + names.get(r) + "!");
            names.remove(r);
            System.out.println("Enter for another name, type QUIT to exit");
            input = s.nextLine();
        }
    }
}
