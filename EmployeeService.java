import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addEmp() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Employee emp = new Employee(id, name, dept, salary);
        employeeList.add(emp);
        System.out.println("Employee added successfully.");
    }

    public void viewEmp() {
        System.out.print("Enter Employee ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Employee found = findById(id);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Employee found = findById(id);
        if (found != null) {
            System.out.print("Enter new Name (leave blank to keep unchanged): ");
            String name = scanner.nextLine();
            if (!name.trim().isEmpty()) {
                found.setName(name);
            }
            System.out.print("Enter new Department (leave blank to keep unchanged): ");
            String dept = scanner.nextLine();
            if (!dept.trim().isEmpty()) {
                found.setDepartment(dept);
            }
            System.out.print("Enter new Salary (or negative to keep unchanged): ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            if (salary >= 0) {
                found.setSalary(salary);
            }
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void deleteEmp() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Employee found = findById(id);
        if (found != null) {
            employeeList.remove(found);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void viewAllEmps() {
        if (employeeList.isEmpty()) {
            System.out.println("No employee records available.");
        } else {
            System.out.println("All Employees:");
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
        }
    }

    private Employee findById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
}
