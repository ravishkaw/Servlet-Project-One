package employee;

import DB.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {

    Database db;

    public EmployeeDao() {
        db = new Database();
    }

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employeedatabasetable " +
            "(firstname, lastname, email, username, password, accountstatus) VALUES" +
            "(?,?,?,?,?,?)";

    private static final String UPDATE_EMPLOYEE_SQL = "";
    private static final String DELETE_EMPLOYEE_SQL = "";
    private static final String VIEW_EMPLOYEE_SQL = "";

    public boolean insertEmployee(Employee emp) {

        try {
            Connection connection = db.getDatabaseConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE_SQL);

            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getUsername());
            ps.setString(5, emp.getPassword());
            ps.setString(6, emp.getAccountStatus());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
