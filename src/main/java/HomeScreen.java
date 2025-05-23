import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner = new Scanner(System.in);

    public void homeScreen(){

        System.out.println("\n*** Home Screen ***");

        System.out.println("""
                1. New Order
                2. Exit""");
        try {
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice) {
                case 1 :
                    break;
            }
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    public void addOrder (){
        System.out.println("");
    }
}

