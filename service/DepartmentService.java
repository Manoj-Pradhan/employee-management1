package service;
import java.sql.Connection;
import java.util.List;

import config.DbConfig;
import model.Department;

public class DepartmentService {
    private static final String DEPARTMENT_TABLE = "department";
    private final Connection connection; 
    
    public DepartmentService() {
        connection = new DbConfig().getConnection();
    }

    public void addDepartment(Department department) {
        var departmentId = department.getDepartmentId();
        var departmentName = department.getDepartmentName();

        var query = "INSERT INTO %s VALUES(?,?)".formatted(DEPARTMENT_TABLE);
        try {
            var prepareStatement = connection.prepareStatement(query);
            prepareStatement.setInt(1, departmentId);
            prepareStatement.setString(2, departmentName);

            prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Department> findAll() {
        return null;
    }
}
