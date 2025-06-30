package myPackage;
import java.sql.*;

public class DatabaseManager {
    private final String url = "jdbc:mysql://localhost:3306/StudentManagementSystem";
    private final String user = "root";
    private final String password = "Deep@2004"; // Change this to your MySQL password
    
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Create Student
    public void insertStudent(Student student) {
        String query = "INSERT INTO students (name, email, phone, address, course) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getPhone());
            pstmt.setString(4, student.getAddress());
            pstmt.setString(5, student.getCourse());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read all students
    public ResultSet getAllStudents() {
        String query = "SELECT * FROM students";
        ResultSet rs = null;
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Update student
    public void updateStudent(Student student) {
        String query = "UPDATE students SET name = ?, email = ?, phone = ?, address = ?, course = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getPhone());
            pstmt.setString(4, student.getAddress());
            pstmt.setString(5, student.getCourse());
            pstmt.setInt(6, student.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

