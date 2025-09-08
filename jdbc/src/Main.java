//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.*;

public class Main {
    public static void main(String[] args) {
                // Always use try-with-resources for safe connection closing
                try {
                    // 1. Load Driver (optional in newer versions)
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // 2. Create Connection
                    String url = "jdbc:mysql://localhost:3306/java_learning";
                    String username = "root";
                    String password = "12345678";

                    try (Connection con = DriverManager.getConnection(url, username, password)) {

                        // ========== C - CREATE (Insert) ==========
                        String insertQuery = "INSERT INTO student (id, marks, name) VALUES (?, ?, ?)";
                        try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
                            pst.setInt(1, 5); //column_number - data
                            pst.setInt(2, 50); //same
                            pst.setString(3, "Mr Bean"); //same
                            int rowsInserted = pst.executeUpdate();
                            System.out.println("Rows Inserted: " + rowsInserted);
                        }

                        // ========== R - READ (Select) ==========
                        String selectQuery = "SELECT * FROM student WHERE id = ?";
                        try (PreparedStatement pst = con.prepareStatement(selectQuery)) {
                            pst.setInt(1, 1);
                            try (ResultSet rs = pst.executeQuery()) {
                                while (rs.next()) {
                                    int id = rs.getInt("id");
                                    String marks = rs.getString("marks");
                                    String name = rs.getString("name");
                                    System.out.println("ID: " + id + ", marks: " + marks + ", Age: " + name);
                                }
                            }
                        }

                        // ========== U - UPDATE ==========
                        String updateQuery = "UPDATE student SET marks = ? WHERE id = ?";
                        try (PreparedStatement pst = con.prepareStatement(updateQuery)) {
                            pst.setInt(1, 100);
                            pst.setInt(2, 5);
                            int rowsUpdated = pst.executeUpdate();
                            System.out.println("Rows Updated: " + rowsUpdated);
                        }

                        // ========== D - DELETE ==========
                        String deleteQuery = "DELETE FROM student WHERE id = ?";
                        try (PreparedStatement pst = con.prepareStatement(deleteQuery)) {
                            pst.setInt(1, 5);
                            int rowsDeleted = pst.executeUpdate();
                            System.out.println("Rows Deleted: " + rowsDeleted);
                        }
                    }

                } catch (Exception e) {
                    System.out.print(e);
                }
    }
}

