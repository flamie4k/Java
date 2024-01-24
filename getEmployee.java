import java.sql.Connection;
import java.sql.DriverManager; // Fixed import statement
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getEmployee { // Class names should start with an uppercase letter
    Connection con;
    Statement stm;
    ResultSet rst;
    
    getEmployee() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", ""); // Fixed DriverManager spelling
            stm = con.createStatement();
            String query = "SELECT * FROM employee_tbl WHERE salary > 25000";
            rst = stm.executeQuery(query);

            while (rst.next()) {
                int emp_id = rst.getInt("id");
                String emp_name = rst.getString("name");
                int emp_salary = rst.getInt("salary");
                String emp_post = rst.getString("post");

                // Do something with the retrieved data (print it, process it, etc.)
                System.out.println("Employee ID: " + emp_id);
                System.out.println("Employee Name: " + emp_name);
                System.out.println("Employee Salary: " + emp_salary);
                System.out.println("Employee Post: " + emp_post);
                System.out.println("------------------------");
            }
        } catch (ClassNotFoundException | SQLException se) {
            se.printStackTrace(); // Print the exception stack trace for debugging
        } finally {
            // Close resources in the finally block
            try {
                if (rst != null) rst.close();
                if (stm != null) stm.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new getEmployee();
    }
}
