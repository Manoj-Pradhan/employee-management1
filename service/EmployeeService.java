package service;
import java.sql.Connection;
import java.util.List;

import config.DbConfig;
import model.Employee;

public class EmployeeService {
    private static final String EMPLOYEE_TABLE = "employee";
    private final Connection connection; 
    
    public EmployeeService() {
        connection = new DbConfig().getConnection();
    }

    public void addEmployee(Employee employee) {
        var employeeId = employee.getEmployeeId();
        var employeeName = employee.getEmployeeName();
        var employeeSalary = employee.getEmployeeSalary();

        var query = "INSERT INTO %s VALUES(?,?,?)".formatted(EMPLOYEE_TABLE);
        try {
            var prepareStatement = connection.prepareStatement(query);
            prepareStatement.setInt(1, employeeId);
            prepareStatement.setString(2, employeeName);
            prepareStatement.setDouble(3, employeeSalary);

            prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> findAll() {
        return null;
    }
}
