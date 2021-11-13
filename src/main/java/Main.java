import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Employee> employee = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean success = false;
        int remainingAttempts = 2;
        int payment = -1;
        String firstName = null;
        String lastName = null;

        while (remainingAttempts > 0) {
            addNewEmployee(remainingAttempts, reader);

            payment = -1;
            success = false;
            remainingAttempts--;
        }

        // Open menu
        Menu.displayMenu();
        int chosenMenu = -1;

        do {
            chosenMenu = Integer.parseInt(reader.readLine());
            switch (chosenMenu) {
                case 1:
                    System.out.println("Sum of all employees salary is: " + getSum());
                    Menu.displayMenu();
                    break;
                case 2:
                    System.out.println("All employees data:");
                    getAllData();
                    Menu.displayMenu();
                    break;
                case 3:
                    System.out.println("Add new employee");
                    addNewEmployee(1, reader);
                    Menu.displayMenu();
                    break;
                case 4:
                    System.out.println("Close the program");
                    break;
                default:
                    System.out.println("Please again chose one option from: 1-4");
                    Menu.displayMenu();
            }
        }
        while (chosenMenu < 4);
    }

    public static double getSum() {
        double sum = 0;

        for (Employee e : employee) {
            sum += e.getPayment();
        }
        return sum;
    }

    public static void getAllData() {
        for (Employee e : employee) {
            e.getAllData();
        }
    }

    public static void addNewEmployee(int i, BufferedReader reader) throws IOException {
        boolean success = false;

        System.out.println("Please add first name of a new employee. " + i + " left employees to add." );
        String firstName = reader.readLine();

        System.out.println("Please add last name of a new employee. " + i + " left employees to add.");
        String lastName = reader.readLine();

        int payment = -1;

        while (!success) {
            try {
                System.out.println("Please add amount of payment of new employee. " + i + " left employees to add.");
                payment = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("You entered string, please enter integer value");
            }
            success = payment == -1 ? false : true;
        }
        employee.add(new Employee(firstName, lastName, payment));
    }
}


