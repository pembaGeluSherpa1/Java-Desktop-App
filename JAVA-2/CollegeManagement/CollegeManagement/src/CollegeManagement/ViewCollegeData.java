package CollegeManagement;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCollegeData extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewCollegeData() {
        setTitle("College Management - View Data");
        setLayout(new BorderLayout());

        // Title
        JLabel heading = new JLabel("College Management - View Data", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading, BorderLayout.NORTH);

        // Table model with column names
        String[] columns = {
                "ID", "Name", "Number of Student", "Number of Teacher", "Affiliated University",
                "Course", "Fee", "Location", "Website", "Actions"
        };

        model = new DefaultTableModel(null, columns) {
            public boolean isCellEditable(int row, int column) {
                return column == 9; 
            }
        };

        table = new JTable(model);
        table.setRowHeight(60);

        loadData();

        table.getColumn("Actions").setCellRenderer(new ActionCellRenderer());
        table.getColumn("Actions").setCellEditor(new ActionCellEditor());

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton addBtn = new JButton("Add college");
        addBtn.addActionListener(e -> {
            dispose();
            new AddCollege();
        });
        add(addBtn, BorderLayout.SOUTH);

        setSize(1100, 800);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadData() {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM collegeManagement");
            model.setRowCount(0); 

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("number_of_student"),
                        rs.getInt("number_of_teacher"),
                        rs.getString("affiliated_university"),
                        rs.getString("course_available"),
                        rs.getString("fee_structure"),
                        rs.getString("location"),
                        rs.getString("website"),
                        "Edit/Delete" 
                });
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    class ActionCellRenderer extends DefaultTableCellRenderer {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        JButton edit = new JButton("Edit");
        JButton delete = new JButton("Delete");

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                    boolean isSelected, boolean hasFocus,
                                                    int row, int column) {
            panel.removeAll();
            panel.add(edit);
            panel.add(delete);
            return panel;
        }
    }

    class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        JButton edit = new JButton("Edit");
        JButton delete = new JButton("Delete");

        public ActionCellEditor() {
            edit.addActionListener(e -> {
                int row = table.getSelectedRow();
                int id = (int) model.getValueAt(row, 0);
                new EditCollege(id);
                fireEditingStopped();
                dispose();
            });

            delete.addActionListener(e -> {
                int row = table.getSelectedRow();
                int id = (int) model.getValueAt(row, 0);

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this record?", "Confirm",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        Connection conn = DBConnection.getConnection();
                        PreparedStatement pst = conn.prepareStatement("DELETE FROM collegeManagement WHERE id=?");
                        pst.setInt(1, id);
                        pst.executeUpdate();
                        pst.close();
                        conn.close();

                        model.removeRow(row);
                        JOptionPane.showMessageDialog(null, "Deleted successfully!");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Deletion failed: " + ex.getMessage());
                    }
                }

                fireEditingStopped();
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                    boolean isSelected, int row, int column) {
            panel.removeAll();
            panel.add(edit);
            panel.add(delete);
            return panel;
        }

        public Object getCellEditorValue() {
            return "";
        }
    }

    public static void main(String[] args) {
        new ViewCollegeData();
    }
}