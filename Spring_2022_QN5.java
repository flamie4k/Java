import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spring_2022_QN5 extends JFrame {

    private int ballX = 250; // Initial x-coordinate of the ball
    private int ballY = 250; // Initial y-coordinate of the ball

    private static final int BALL_SIZE = 50; // Size of the ball

    public Spring_2022_QN5() {
        setTitle("Ball Movement Example");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel and set a custom layout manager
        JPanel panel = new JPanel(null);

        // Create a circular button (ball)
        JButton ball = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(0, 0, BALL_SIZE, BALL_SIZE);
            }
        };

        ball.setBounds(ballX, ballY, BALL_SIZE, BALL_SIZE);

        // Create buttons for movement
        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");
        JButton rightButton = new JButton("Right");
        JButton leftButton = new JButton("Left");

        // Set the positions of the movement buttons
        upButton.setBounds(250, 500, 80, 30);
        downButton.setBounds(250, 540, 80, 30);
        rightButton.setBounds(330, 520, 80, 30);
        leftButton.setBounds(170, 520, 80, 30);

        // Add ActionListener to the movement buttons
        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveBall(0, -10);
            }
        });

        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveBall(0, 10);
            }
        });

        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveBall(10, 0);
            }
        });

        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveBall(-10, 0);
            }
        });

        // Add components to the panel
        panel.add(ball);
        panel.add(upButton);
        panel.add(downButton);
        panel.add(rightButton);
        panel.add(leftButton);

        // Add the panel to the frame
        add(panel);
    }

    private void moveBall(int deltaX, int deltaY) {
        // Update the position of the ball based on the movement
        ballX += deltaX;
        ballY += deltaY;

        // Set the new bounds for the ball
        JButton ball = (JButton) ((JPanel) getContentPane().getComponent(0)).getComponent(0);
        ball.setBounds(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Spring_2022_QN5().setVisible(true);
            }
        });
    }
}
