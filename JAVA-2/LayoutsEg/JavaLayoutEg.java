package LayoutsEg;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
// import java.awt.FlowLayout;
import java.awt.*;

public class JavaLayoutEg {
    public static void main(String[] args) {
        JFrame frame = new JFrame("This is about layout!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        // frame.setLayout(new FlowLayout()); // it align conntent in center in x axis and auto wrap if the data is large
        // frame.setLayout(new GridLayout(4,3,10,25));  //button expands from the top to the buttom in a single row
        // frame.setLayout(new GridBagLayout()); // it center the element at the center point of a frame
        // frame.setLayout(new BoxLayout(, 0));

        // ------------------------------ borderLayout -----------------------------------
        // frame.setLayout(new BorderLayout(10,10)); 
        // frame.add(new JButton("north"), BorderLayout.NORTH );
        // frame.add(new JButton("south"), BorderLayout.SOUTH );
        // frame.add(new JButton("east"), BorderLayout.EAST );
        // frame.add(new JButton("west"), BorderLayout.WEST );
        // frame.add(new JButton("center"), BorderLayout.CENTER );
        // ---------------------------------------------------------------------------------


        // frame.add(new JButton("Hello2"));
        // frame.add(new JButton("Hello3"));
        // frame.add(new JButton("Hello4"));
        // frame.add(new JButton("Hello5"));
        // frame.add(new JButton("Hello6"));
        // frame.add(new JButton("Hello7"));
        // frame.add(new JButton("Hello8"));
        // frame.add(new JButton("Hello9"));
        // frame.add(new JButton("Hello10"));
        // frame.add(new JButton("Hello11"));
        // frame.add(new JButton("Hello12"));

        frame.setVisible(true);
    }
}
