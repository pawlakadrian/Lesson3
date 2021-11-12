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
        int remainingAttempts = 5;
        int payment = -1;

        while (remainingAttempts > 0) {
            System.out.println("Please add " + remainingAttempts + " employee. First name: ");
            String firstName = reader.readLine();

            System.out.println("Please add " + remainingAttempts + " employee. Last name: ");
            String lastName = reader.readLine();

            while (!success) {
                try {
                    System.out.println("Please add " + remainingAttempts + " employee. Payment: ");
                    payment = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException | IOException e) {
                    System.out.println("You entered string, please enter integer value");
                }
                success = payment == -1 ? false : true;
            }

            employee.add(new Employee(firstName, lastName, payment));
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
                    addNewEmployee();
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

    public static void addNewEmployee() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean success = false;

        System.out.println("Please add new employee. First name: ");
        String firstName = reader.readLine();

        System.out.println("Please add new employee. Last name: ");
        String lastName = reader.readLine();

        int payment = -1;

        while (!success) {
            try {
                System.out.println("Please new add employee. Payment: ");
                payment = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("You entered string, please enter integer value");
            }
            success = payment == -1 ? false : true;
        }
        employee.add(new Employee(firstName, lastName, payment));
    }
}


