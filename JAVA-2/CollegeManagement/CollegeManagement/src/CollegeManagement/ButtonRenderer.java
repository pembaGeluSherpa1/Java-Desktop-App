package CollegeManagement;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import java.awt.*;

public class ButtonRenderer extends JPanel implements TableCellRenderer {
    public ButtonRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        add(editButton);
        add(deleteButton);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
        return this;
    }
}