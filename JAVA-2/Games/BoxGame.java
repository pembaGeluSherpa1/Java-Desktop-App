package Games;

import java.util.Random;

import javax.swing.*;
import java.awt.event.*;

public class BoxGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Box Game");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        JButton button = new JButton("yo me");
        button.setSize(100,40);

        int maxX = frame.getWidth() - button.getWidth()-20;
        int maxY = frame.getHeight() - button.getHeight()-20;

        JLabel score = new JLabel("Score: 0");
        score.setBounds(10,10,80,40);

        Timer hidTimer = new Timer(700, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Random x = new Random();
                int X = x.nextInt(1,maxX);
                int Y = x.nextInt(1,maxY);
                button.setLocation(X,Y);
            }
        });
        hidTimer.start();


        button.addActionListener(new ActionListener() {

            int counter;

            @Override
            public void actionPerformed(ActionEvent e){
                counter =counter+1;
                score.setText("Score: "+counter);
            }
        });

        frame.add(score);
        frame.add(button);

    }
}
