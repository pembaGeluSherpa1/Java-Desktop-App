package Games;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Car {
    public void Racer() {
        JFrame frame = new JFrame("Start the race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);

        JLabel racer1 = new JLabel("🏇");
        JLabel racer2 = new JLabel("🏇");
        JLabel racer3 = new JLabel("🏇");

        int y = 590;

        racer1.setBounds(130, y, 20, 20);
        racer2.setBounds(190, y, 20, 20);
        racer3.setBounds(250, y, 20, 20);

        frame.add(racer1);
        frame.add(racer2);
        frame.add(racer3);

        frame.setVisible(true);

        new Thread(() -> startRace(racer1)).start();
        new Thread(() -> startRace(racer2)).start();
        new Thread(() -> startRace(racer3)).start();
    }

    public void startRace(JLabel racer) {
        int y = 540;
        while (y >= 30) {
            racer.setBounds(racer.getX(), y, 50, 50);
            y -= 5;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Car().Racer();
    }
}