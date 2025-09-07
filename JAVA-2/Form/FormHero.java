package Form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormHero {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300,400);

        JPanel container1 = new JPanel(new GridLayout(4,1,10,10));

        JLabel Name = new JLabel("Name");
        JTextField nameText = new JTextField();

        JLabel surName = new JLabel("Sur-name");
        JTextField surNameText = new JTextField();

        container1.add(Name);
        container1.add(nameText);
        container1.add(surName);
        container1.add(surNameText);

        JPanel container2 = new JPanel(new GridLayout(3,2));
        JCheckBox international = new JCheckBox("Is International");

        JLabel gender = new JLabel("Gender");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton male = new JRadioButton("male");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        container2.add(gender);
        container2.add(new JLabel());
        container2.add(female);
        container2.add(male);   
        container2.add(international);   

        
        JPanel container3 = new JPanel(new GridLayout(3,1));


        JLabel country = new JLabel("Destination Country");

        JComboBox<String> countryOption = new JComboBox<>();
        JButton register = new JButton("Register");

        register.addActionListener(new ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent e){
                String name = nameText.getText();
                String surName = surNameText.getText();
                String gender = female.isSelected() ? "female" : male.isSelected() ? "male": "Not Selected";
                String International = international.isSelected() ? "International" : "is Not international";
                String country = (String) countryOption.getSelectedItem();

                FormData formData = new FormData(name, surName, gender, International, country);
                formData.getter();

                // StoreData.addData(formData);
            }
        });

        countryOption.addItem("nepal");
        countryOption.addItem("india");
        countryOption.addItem("japan");
        countryOption.addItem("newzealand");

        // container3.add(international);
        container3.add(country);
        container3.add(countryOption);
        container3.add(register);

        JPanel mainContainer = new JPanel(new GridLayout(3,1,10,10));

        mainContainer.add(container1);
        mainContainer.add(container2);
        mainContainer.add(container3);

        
        frame.add(mainContainer);
        frame.setVisible(true);
    }
}
