import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fall_2019_QN4 {
    Fall_2019_QN4() {
        JFrame frame = new JFrame("Odd or Even?");
        JPanel panel = new JPanel();
        JButton btn1 = new JButton("Even or Odd?");
        JLabel lbl = new JLabel("Enter a number: ");
        JTextArea txt1 = new JTextArea();

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkOddOrEven(txt1.getText());
            }
        });

        panel.add(lbl);
        panel.add(txt1);
        panel.add(btn1);
        frame.add(panel);

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void checkOddOrEven(String input) {
        try {
            int number = Integer.parseInt(input);
            String result = (number % 2 == 0) ? "Even" : "Odd";
            displayResult("The entered number is " + result + ".");
        } catch (NumberFormatException e) {
            displayResult("Invalid input. Please enter a valid number.");
        }
    }

    private void displayResult(String message) {
        JFrame resultFrame = new JFrame("Result");
        JPanel resultPanel = new JPanel();
        JLabel resultLabel = new JLabel(message);
        resultPanel.add(resultLabel);
        resultFrame.add(resultPanel);
        resultFrame.setSize(300, 100);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Fall_2019_QN4();
    }
}
