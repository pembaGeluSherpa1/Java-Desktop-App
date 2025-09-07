package JavaSwingEg;

import javax.swing.*;
import java.awt.event.*;

public class Calculate {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello I am Batman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 400);
        frame.setLayout(null);

        JTextField display = new JTextField();
        display.setBounds(30, 30, 180, 30);
        display.setEditable(false);
        frame.add(display);

        StringBuilder currentNumber = new StringBuilder();
        int[] firstOperand = new int[1];
        String[] operator = {""};         

        JButton butt1 = new JButton("1"); butt1.setBounds(50, 70, 40, 40);
        JButton butt2 = new JButton("2"); butt2.setBounds(100, 70, 40, 40);
        JButton butt3 = new JButton("3"); butt3.setBounds(150, 70, 40, 40);
        JButton butt4 = new JButton("4"); butt4.setBounds(50, 110, 40, 40);
        JButton butt5 = new JButton("5"); butt5.setBounds(100, 110, 40, 40);
        JButton butt6 = new JButton("6"); butt6.setBounds(150, 110, 40, 40);
        JButton butt7 = new JButton("7"); butt7.setBounds(50, 150, 40, 40);
        JButton butt8 = new JButton("8"); butt8.setBounds(100, 150, 40, 40);
        JButton butt9 = new JButton("9"); butt9.setBounds(150, 150, 40, 40);
        JButton buttZero = new JButton("0"); buttZero.setBounds(100, 230, 40, 40);

        ActionListener digitListener = e -> {
            JButton b = (JButton) e.getSource();
            currentNumber.append(b.getText());
            display.setText(currentNumber.toString());
        };

        butt1.addActionListener(digitListener);
        butt2.addActionListener(digitListener);
        butt3.addActionListener(digitListener);
        butt4.addActionListener(digitListener);
        butt5.addActionListener(digitListener);
        butt6.addActionListener(digitListener);
        butt7.addActionListener(digitListener);
        butt8.addActionListener(digitListener);
        butt9.addActionListener(digitListener);
        buttZero.addActionListener(digitListener);

        JButton buttPlus = new JButton("+"); buttPlus.setBounds(100, 190, 40, 40);
        JButton buttSub = new JButton("-"); buttSub.setBounds(50, 230, 40, 40);
        JButton buttMul = new JButton("*"); buttMul.setBounds(50, 190, 40, 40);
        JButton buttDiv = new JButton("/"); buttDiv.setBounds(150, 190, 40, 40);

        ActionListener operatorListener = e -> {
            JButton b = (JButton) e.getSource();
            try {
                firstOperand[0] = Integer.parseInt(currentNumber.toString());
                operator[0] = b.getText();
                currentNumber.setLength(0);
                display.setText("");
            } catch (NumberFormatException ex) {
                display.setText("Error");
                currentNumber.setLength(0);
            }
        };

        buttPlus.addActionListener(operatorListener);
        buttSub.addActionListener(operatorListener);
        buttMul.addActionListener(operatorListener);
        buttDiv.addActionListener(operatorListener);

        JButton buttEqual = new JButton("=");
        buttEqual.setBounds(150, 230, 40, 40);
        buttEqual.addActionListener(e -> {
            try {
                int secondOperand = Integer.parseInt(currentNumber.toString());
                int result = 0;

                switch (operator[0]) {
                    case "+":
                        result = firstOperand[0] + secondOperand;
                        break;
                    case "-":
                        result = firstOperand[0] - secondOperand;
                        break;
                    case "*":
                        result = firstOperand[0] * secondOperand;
                        break;
                    case "/":
                        if (secondOperand == 0) {
                            display.setText("Error");
                            currentNumber.setLength(0);
                            return;
                        }
                        result = firstOperand[0] / secondOperand;
                        break;
                    default:
                        display.setText("Error");
                        return;
                }

                display.setText(String.valueOf(result));
                currentNumber.setLength(0);
                currentNumber.append(result);
            } catch (NumberFormatException ex) {
                display.setText("Error");
                currentNumber.setLength(0);
            }
        });

        frame.add(butt1); frame.add(butt2); frame.add(butt3);
        frame.add(butt4); frame.add(butt5); frame.add(butt6);
        frame.add(butt7); frame.add(butt8); frame.add(butt9);
        frame.add(buttZero); frame.add(buttPlus); frame.add(buttSub);
        frame.add(buttMul); frame.add(buttDiv); frame.add(buttEqual);

        frame.setVisible(true);
    }
}