package JavaSwingEg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NiceCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("initial.Text");
        label.setBounds(0,40,50 ,20);
        int x = 30;
        int y = 60;
        int width = 40;
        int height = 50;
        int count = 0;

        ArrayList<CalculatorToken> tokens = new ArrayList<>();
        tokens.add(new CalculatorToken("1", TokenType.DIGIT));
        tokens.add(new CalculatorToken("2", TokenType.DIGIT));
        tokens.add(new CalculatorToken("3", TokenType.DIGIT));
        tokens.add(new CalculatorToken("4", TokenType.DIGIT));
        tokens.add(new CalculatorToken("5", TokenType.DIGIT));
        tokens.add(new CalculatorToken("6", TokenType.DIGIT));
        tokens.add(new CalculatorToken("7", TokenType.DIGIT));
        tokens.add(new CalculatorToken("8", TokenType.DIGIT));
        tokens.add(new CalculatorToken("9", TokenType.DIGIT));
        tokens.add(new CalculatorToken("+", TokenType.OPERATORS));
        tokens.add(new CalculatorToken("-", TokenType.OPERATORS));
        tokens.add(new CalculatorToken("*", TokenType.OPERATORS));
        tokens.add(new CalculatorToken("/", TokenType.OPERATORS));
        for (CalculatorToken i : tokens){
            JButton button = new JButton("" + (i.token));
            button.setBackground(Color.BLUE);

            if (count % 3==0){
                y = y + height;
                x = 30;
                count = 0;
            }else{
                x = x + width;
            }
            count = count + 1;

            button.setBounds(x,y,width,height);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("" + i.token);
                }
            });
            frame.add(button);
        }
        frame.add(label);
        //Make the frame visible
        frame.setVisible(true);
    }
}