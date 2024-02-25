import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PersonManager {
    ArrayList<Person> persons = new ArrayList<>();
    PersonCreator pc = new PersonCreator();
    Scanner sc = new Scanner(System.in);

    public void addPerson() {
        Menu menu = new Menu("Choose an type of person: ",
                Arrays.asList("Person", "Student", "Employee"));
        menu.printMenu();
        int choice = sc.nextInt();
        String name, surname;
        System.out.println("Write name: ");
        name = sc.next();
        System.out.println("Write surname: ");
        surname = sc.next();
        switch (choice) {
            case 1:
                persons.add(pc.createPerson("Person", name, surname));
                break;
            case 2:
                System.out.println("Write gpa: ");
                double gpa = sc.nextDouble();
                persons.add(pc.createPerson("Student", name, surname, gpa));
                break;
            case 3:
                System.out.println("Write position: ");
                String position = sc.next();
                System.out.println("Write salary: ");
                double salary = sc.nextDouble();
                persons.add(pc.createPerson("Employee", name, surname, position, salary));
                break;
            default:
                System.out.println("Incorrect!");
                break;
        }
    }

    public void listPersons() {
        for (Person person : persons) {
            System.out.println(person.toStr());
        }
    }
    public void deletePerson(){
        ArrayList<String> personsData = new ArrayList<>();
        for (Person person : persons) {
            personsData.add(person.toStr());
        }
        Menu menu = new Menu("Choose the user to delete: ", personsData);
        menu.printMenu();
        int choice = sc.nextInt() - 1;
        if(choice < 0 || choice > persons.size()){
            System.out.println("Invalid choice!");
        }
        else{
            persons.remove(choice);
        }
    }

    public void editPerson() {
        ArrayList<String> personsData = new ArrayList<>();
        for (Person person : persons) {
            personsData.add(person.toStr());
        }
        Menu menu = new Menu("Choose the person: ", personsData);
        menu.printMenu();
        int personChoice = sc.nextInt() - 1;
        if (personChoice > personsData.size() || personChoice < 0) {
            System.out.println("Invalid input!");
        }
        else {
            int choice = 0;
            switch (persons.get(personChoice).getType()) {
                case "Person":
                    menu = new Menu("Choose the option to edit: ", Arrays.asList("Name", "Surname"));
                    menu.printMenu();
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new name: ");
                            persons.get(personChoice).setName(sc.next());
                            break;
                        case 2:
                            System.out.println("Enter new surname: ");
                            persons.get(personChoice).setSurname(sc.next());
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                    break;
                case "Student":
                    menu = new Menu("Choose the option to edit: ", Arrays.asList("Name", "Surname", "GPA"));
                    menu.printMenu();
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new name: ");
                            persons.get(personChoice).setName(sc.next());
                            break;
                        case 2:
                            System.out.println("Enter new surname: ");
                            persons.get(personChoice).setSurname(sc.next());
                            break;
                        case 3:
                            System.out.println("Enter new gpa: ");
                            persons.get(personChoice).setGpa(sc.nextDouble());
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                    break;
                case "Employee":
                    menu = new Menu("Choose the option to edit: ", Arrays.asList("Name", "Surname", "position", "salary"));
                    menu.printMenu();
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new name: ");
                            persons.get(personChoice).setName(sc.next());
                            break;
                        case 2:
                            System.out.println("Enter new surname: ");
                            persons.get(personChoice).setSurname(sc.next());
                            break;
                        case 3:
                            System.out.println("Enter new position: ");
                            persons.get(personChoice).setPosition(sc.next());
                            break;
                        case 4:
                            System.out.println("Enter new salary: ");
                            persons.get(personChoice).setSalary(sc.nextDouble());
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                    break;
            }
        }
    }
}