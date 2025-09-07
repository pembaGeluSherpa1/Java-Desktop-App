import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaddleBallGame extends JPanel implements ActionListener, KeyListener {

    private int ballX, ballY, ballDX, ballDY;
    private int paddleX;
    private final int PADDLE_WIDTH = 70;
    private final int PADDLE_HEIGHT = 10;
    private final int BALL_SIZE = 20;
    private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 300;
    private final int PADDLE_Y = 240;

    private int score = 0;
    private boolean gameRunning = true;
    private Timer timer;
    private JButton retryButton;

    public PaddleBallGame() {
    setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    setBackground(Color.BLACK);
    setFocusable(true);

getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
getActionMap().put("moveLeft", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (paddleX > 0) {
            paddleX -= 15; 
            repaint();
        }
    }
});

getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
getActionMap().put("moveRight", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (paddleX < PANEL_WIDTH - PADDLE_WIDTH) {
            paddleX += 15;
            repaint();
        }
    }
});

    addKeyListener(this);

    // Timer setup
    timer = new Timer(10, this);

    // Retry button setup
    retryButton = new JButton("Retry");
    retryButton.setFocusable(false);
    retryButton.setVisible(false);
    retryButton.addActionListener(e -> resetGame());
    setLayout(null);
    retryButton.setBounds(PANEL_WIDTH / 2 - 50, PANEL_HEIGHT / 2 + 30, 100, 30);
    add(retryButton);

    // ✅ Now safe to initialize the game
    initializeGame();
}

    private void initializeGame() {
        ballX = 160;
        ballY = 100;
        ballDX = 1;
        ballDY = 2;
        paddleX = 140;
        score = 0;
        gameRunning = true;
        retryButton.setVisible(false);
        timer.start();
    }

    private void resetGame() {
        initializeGame();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameRunning) {
            g.setColor(Color.YELLOW);
            g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

            g.setColor(Color.CYAN);
            g.fillRect(paddleX, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString("Score: " + score, 10, 20);
        } else {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", 110, 130);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString("Final Score: " + score, 150, 160);

            retryButton.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameRunning) return;

        ballX += ballDX;
        ballY += ballDY;

        if (ballX <= 0 || ballX >= PANEL_WIDTH - BALL_SIZE)
            ballDX = -ballDX;
        if (ballY <= 0)
            ballDY = -ballDY;

        if (ballY + BALL_SIZE >= PADDLE_Y &&
            ballY + BALL_SIZE <= PADDLE_Y + PADDLE_HEIGHT &&
            ballX + BALL_SIZE >= paddleX &&
            ballX <= paddleX + PADDLE_WIDTH) {
            ballDY = -ballDY;
            ballY = PADDLE_Y - BALL_SIZE;
            score++;
        }

        if (ballY > PANEL_HEIGHT) {
            gameRunning = false;
            timer.stop();
        }

        repaint();
    }

    @Override public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && paddleX > 0)
            paddleX -= 20;
        else if (key == KeyEvent.VK_RIGHT && paddleX < PANEL_WIDTH - PADDLE_WIDTH)
            paddleX += 20;
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Paddle Ball Game");
            PaddleBallGame gamePanel = new PaddleBallGame();
            frame.add(gamePanel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}