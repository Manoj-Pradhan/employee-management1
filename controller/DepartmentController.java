package controller;
import java.util.Scanner;

import model.Department;
import service.DepartmentService;

public class DepartmentController {
    private final DepartmentService departmentService;
    private final Scanner scanner;

    public DepartmentController() {
        departmentService = new DepartmentService();
        scanner = new Scanner(System.in);
    }

    public void addDepartment() {
        var department = getDepartment();
        departmentService.addDepartment(department);
        System.out.println("Department added");

    }

    private Department getDepartment() {
        System.out.println("Enter department id");
        int departmentId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter department name");
        String departmentName = scanner.nextLine();

        return new Department(departmentId, departmentName);
    }

}
