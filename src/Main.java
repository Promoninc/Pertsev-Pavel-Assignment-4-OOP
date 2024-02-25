import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonManager pm = new PersonManager();
        while(true) {
            Menu mainMenu = new Menu("Choose an option: ",
                    Arrays.asList("Add person", "Edit person", "Delete person", "List persons"));
            mainMenu.printMenu();
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    pm.addPerson();
                break;
                case 3:
                    pm.deletePerson();
                break;
                case 2:
                    pm.editPerson();
                break;
                case 4:
                    pm.listPersons();
                break;
                default:
                    System.out.println("Invalid input!");
                break;
            }
        }
    }
}