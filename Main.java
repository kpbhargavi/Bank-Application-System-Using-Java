import java.util.Scanner;

public class Main {
    static boolean ordering = true;

    public static void menu() {
        System.out.println("**************** Welcome To Employee Management System ***********");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. View All Employee");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (ordering) {
            menu();
            System.out.print("Enter your Choice: ");
            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1-6.");
                sc.nextLine();  // clear the bad input
                continue;
            }

            switch (choice) {
                case 1:
                    service.addEmp();
                    break;
                case 2:
                    service.viewEmp();
                    break;
                case 3:
                    service.updateEmployee();
                    break;
                case 4:
                    service.deleteEmp();
                    break;
                case 5:
                    service.viewAllEmps();
                    break;
                case 6:
                    System.out.println("Thank you for using application!!");
                    ordering = false;
                    break;
                default:
                    System.out.println("Please enter valid choice (1-6).");
            }
            System.out.println();  // blank line
        }

        sc.close();
    }
}
