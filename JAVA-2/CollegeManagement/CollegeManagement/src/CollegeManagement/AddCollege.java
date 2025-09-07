package CollegeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddCollege extends JFrame{

    AddCollege(){

        setLayout(null);

        setTitle("College Management System");
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("Image/College.png"));
        Image ic2 = ic1.getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel icon = new JLabel(ic3);
        icon.setBounds(120,10,70,50);

        JLabel title = new JLabel("College Management System");
        title.setFont(new Font("Osward",Font.BOLD,20));
        title.setBounds(190, 10, 400, 50);

        add(title);
        add(icon);

        // label start

        JLabel name = new JLabel("Name: ");
        name.setBounds(100,100,200,70);
        add(name);

        JLabel numberStd = new JLabel("Number of Student: ");
        numberStd.setBounds(100,150,200,70);
        add(numberStd);

        JLabel numberTea = new JLabel("Number of Teacher: ");
        numberTea.setBounds(100,200,200,70);
        add(numberTea);

        JLabel affiliation = new JLabel("Affiliated University: ");
        affiliation.setBounds(100,250,200,70);
        add(affiliation);

        JLabel course = new JLabel("Course Available: ");
        course.setBounds(100,300,200,70);
        add(course);

        JLabel fee = new JLabel("Fee Structure: ");
        fee.setBounds(100,350,200,70);
        add(fee);

        JLabel location = new JLabel("Location: ");
        location.setBounds(100,400,200,70);
        add(location);

        JLabel website = new JLabel("Website: ");
        website.setBounds(100,450,200,70);
        add(website);
// labels over

// input feild and section feild 

        JTextField nameIn = new JTextField();
        nameIn.setBounds(300,120,200,30);
        add(nameIn);

        String[] std = {"0-100","100-200","200-300","300-400","400-500","500-600","600-700","700-800","800-900","900-1000"};
        JComboBox<String> numberStdIn = new JComboBox<>(std);
        numberStdIn.setBounds(300,170,200,30);
        add(numberStdIn);

        JTextField numberTeaIn = new JTextField();
        numberTeaIn.setBounds(300,220,200,30);
        add(numberTeaIn);

        String[] uni = {"Null","Tribhuwan University","Pokhara University","Kathmandu University"};
        JComboBox <String> affiliationIn = new JComboBox<>(uni);
        affiliationIn.setBounds(300,270,200,30);
        add(affiliationIn);

        String[] cour = {"BBA","BCA","BBS","BSW","BSC"};
        JComboBox <String> courseIn = new JComboBox<>(cour);
        courseIn.setBounds(300,320,200,30);
        add(courseIn);

        JTextField feeIn = new JTextField();
        feeIn.setBounds(300,370,200,30);
        add(feeIn);

        JTextField locationIn = new JTextField();
        locationIn.setBounds(300,420,200,30);
        add(locationIn);

        JTextField websiteIn = new JTextField();
        websiteIn.setBounds(300,470,200,30);
        add(websiteIn);

// input and selection felid close 

        JButton submit = new JButton("Submit");
        submit.setBounds(220,530,200,50);
        submit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameIn.getText();
        String numberOfStudent = (String) numberStdIn.getSelectedItem();
        String numberOfTeacher = numberTeaIn.getText();
        String affiliatedUniversity = (String) affiliationIn.getSelectedItem();
        String courseAvailable = (String) courseIn.getSelectedItem();
        String feeStructure = feeIn.getText();
        String location = locationIn.getText();
        String website = websiteIn.getText();

        // Validation (basic)
        if (name.isEmpty() || numberOfTeacher.isEmpty() || feeStructure.isEmpty() ||
                location.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all required fields.");
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO collegeManagement " +
                    "(name, number_of_student, number_of_teacher, affiliated_university, course_available, fee_structure, location, website) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            java.sql.PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, numberOfStudent);
            pst.setInt(3, Integer.parseInt(numberOfTeacher));
            pst.setString(4, affiliatedUniversity);
            pst.setString(5, courseAvailable);
            pst.setString(6, feeStructure);
            pst.setString(7, location);
            pst.setString(8, website);

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "College data added successfully!");
                dispose();
                new ViewCollegeData();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add data.");
            }

            pst.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        }
    }
});
        
        add(submit);

        setSize(600,650);
        setLocation(450,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }

    public static void main(String[] args) {
        new AddCollege();
    }
}
