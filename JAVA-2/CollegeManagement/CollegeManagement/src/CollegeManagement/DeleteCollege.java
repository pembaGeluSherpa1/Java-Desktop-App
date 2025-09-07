package CollegeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DeleteCollege {

    public DeleteCollege(int collegeId) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM collegeManagement WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, collegeId);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "College deleted successfully!");
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to delete college: " + e.getMessage());
        }
    }
}