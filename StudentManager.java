package myPackage;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager {
    private DatabaseManager dbManager;

    public StudentManager() {
        dbManager = new DatabaseManager();
    }

    public void addStudent(Student student) {
        dbManager.insertStudent(student);
    }

    public void updateStudent(Student student) {
        dbManager.updateStudent(student);
    }

    public void deleteStudent(int id) {
        dbManager.deleteStudent(id);
    }

    public void listStudents() {
        ResultSet rs = dbManager.getAllStudents();
        try {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("-----------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

