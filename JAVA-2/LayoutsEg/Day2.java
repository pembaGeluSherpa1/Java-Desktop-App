package LayoutsEg;
import javax.swing.*;
import java.awt.*;

public class Day2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.add(new JButton("Box 1"));
        topPanel.add(new JButton("Box 2"));

        JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER));
        center.add(topPanel);

        frame.add(center, BorderLayout.NORTH);
        frame.add(new JButton("Button3"), BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
