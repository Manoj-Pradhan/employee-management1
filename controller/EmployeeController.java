package controller;
import java.util.Scanner;

import model.Employee;
import service.EmployeeService;

public class EmployeeController {
    private final EmployeeService employeeService;
    private final Scanner scanner;

    public EmployeeController() {
        employeeService = new EmployeeService();
        scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        var employee = getEmployee();
        employeeService.addEmployee(employee);
        System.out.println("Employee added");

    }

    private Employee getEmployee() {
        System.out.println("Enter employee id");
        int employeeId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter employee name");
        String employeeName = scanner.nextLine();

        System.out.println("Enter employee salary");
        double employeeSalary = Double.parseDouble(scanner.nextLine());
        return new Employee(employeeId, employeeName, employeeSalary);
    }

}
