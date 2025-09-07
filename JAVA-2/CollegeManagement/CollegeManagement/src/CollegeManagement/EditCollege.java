package CollegeManagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class EditCollege extends JFrame {

    EditCollege(int collegeId) {
        setTitle("Edit College Data");
        setLayout(null);

        JLabel heading = new JLabel("Edit College Data");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(200, 10, 300, 30);
        add(heading);

        // Labels
        String[] labels = {
            "Name", "Number of Student", "Number of Teacher", "Affiliated University",
            "Course Available", "Fee Structure", "Location", "Website"
        };
        int y = 60;
        for (String label : labels) {
            JLabel lbl = new JLabel(label + ":");
            lbl.setBounds(100, y, 200, 30);
            add(lbl);
            y += 40;
        }

        // Fields
        JTextField nameIn = new JTextField();
        JComboBox<String> numberStdIn = new JComboBox<>(new String[]{
                "0-100", "100-200", "200-300", "300-400", "400-500",
                "500-600", "600-700", "700-800", "800-900", "900-1000"
        });
        JTextField numberTeaIn = new JTextField();
        JComboBox<String> affiliationIn = new JComboBox<>(new String[]{
                "Null", "Tribhuwan University", "Pokhara University", "Kathmandu University"
        });
        JComboBox<String> courseIn = new JComboBox<>(new String[]{
                "BBA", "BCA", "BBS", "BSW", "BSC"
        });
        JTextField feeIn = new JTextField();
        JTextField locationIn = new JTextField();
        JTextField websiteIn = new JTextField();

        JComponent[] fields = {
                nameIn, numberStdIn, numberTeaIn, affiliationIn,
                courseIn, feeIn, locationIn, websiteIn
        };

        y = 60;
        for (JComponent field : fields) {
            field.setBounds(300, y, 200, 30);
            add(field);
            y += 40;
        }

        // Load data into form
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM collegeManagement WHERE id = ?");
            pst.setInt(1, collegeId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nameIn.setText(rs.getString("name"));
                numberStdIn.setSelectedItem(rs.getString("number_of_student"));
                numberTeaIn.setText(rs.getString("number_of_teacher"));
                affiliationIn.setSelectedItem(rs.getString("affiliated_university"));
                courseIn.setSelectedItem(rs.getString("course_available"));
                feeIn.setText(rs.getString("fee_structure"));
                locationIn.setText(rs.getString("location"));
                websiteIn.setText(rs.getString("website"));
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
            e.printStackTrace();
        }

        // Update button
        JButton update = new JButton("Update");
        update.setBounds(200, 400, 200, 40);
        add(update);

        update.addActionListener(e -> {
            String name = nameIn.getText();
            String numberOfStudent = (String) numberStdIn.getSelectedItem();
            String numberOfTeacher = numberTeaIn.getText();
            String affiliatedUniversity = (String) affiliationIn.getSelectedItem();
            String courseAvailable = (String) courseIn.getSelectedItem();
            String feeStructure = feeIn.getText();
            String location = locationIn.getText();
            String website = websiteIn.getText();

            if (name.isEmpty() || numberOfTeacher.isEmpty() || feeStructure.isEmpty() || location.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all required fields.");
                return;
            }

            try {
                Connection conn = DBConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(
                        "UPDATE collegeManagement SET name=?, number_of_student=?, number_of_teacher=?, affiliated_university=?, course_available=?, fee_structure=?, location=?, website=? WHERE id=?"
                );

                pst.setString(1, name);
                pst.setString(2, numberOfStudent);
                pst.setInt(3, Integer.parseInt(numberOfTeacher));
                pst.setString(4, affiliatedUniversity);
                pst.setString(5, courseAvailable);
                pst.setString(6, feeStructure);
                pst.setString(7, location);
                pst.setString(8, website);
                pst.setInt(9, collegeId);

                int rows = pst.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "College data updated successfully!");
                    dispose();
                    new ViewCollegeData();
                } else {
                    JOptionPane.showMessageDialog(null, "Update failed.");
                }

                pst.close();
                conn.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error updating: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        setSize(600, 520);
        setLocation(450, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}