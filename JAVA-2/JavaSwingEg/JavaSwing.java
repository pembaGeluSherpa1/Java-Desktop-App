package JavaSwingEg;

import javax.swing.*;
import java.awt.event.*;

public class JavaSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pemba Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLayout(null);

        JLabel label = new JLabel("Hello its Pemba Swing");
        label.setBounds(50,35,100,10);

        JLabel newLAble = new JLabel("Button clicked 0 times");
        newLAble.setBounds(50,75,150,10);

        JButton button = new JButton("Button");
        button.setBounds(50,50,60,20);
        button.addActionListener(new ActionListener(){
            int counter;

            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("I Love Apple 🍎");
                this.counter++;
                newLAble.setText("Button clicked "+counter+" times");
            }

        });

        // JButton button2 = new JButton("Button");
        // button.setBounds(,70,60,20);
        
        frame.add(label);
        frame.add(newLAble);
        frame.add(button);
        // frame.add(button2);

        frame.setVisible(true);
    }
}
