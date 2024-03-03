import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class routine {
    private JFrame frame;
    private JPanel panel;
    private JButton btn1;

    private String[] subjects = {"LC", "Java", "SEF", "MPAL", "PQT", "DBMS", "Math-II", "Drawing"};
    private String[] dates = {"4th March", "6th March", "9th March", "13th March", "21th March", "26th March", "6th April", "14th April"};

    public routine() {
        initializeGUI();
    }

    private void initializeGUI() {
        Color frameBG = new Color(211, 211, 211);
        panel = new JPanel(null);
        panel.setBackground(frameBG);
        
        JLabel title = new JLabel("Exam Routine");
        title.setBounds(620, 0, 100, 100);

        btn1 = new JButton("View Routine");
        btn1.setBounds(590, 70, 135, 50);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayRoutine();
            }
        });

        frame = new JFrame("Exam routine");
        frame.setSize(1400, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.add(title);
        panel.add(btn1);

        frame.setVisible(true);
    }

    private void displayRoutine() {
        // Clear the panel first
        panel.removeAll();
        
        // Add the title label
        JLabel titleLabel = new JLabel("Exam Routine");
        titleLabel.setBounds(590, 20, 100, 30);
        panel.add(titleLabel);
        
        int y = 70; // Initial Y-coordinate for labels
        for (int i = 0; i < subjects.length; i++) {
            JLabel subjectLabel = new JLabel(subjects[i] + " - " + dates[i]);
            subjectLabel.setBounds(590, y, 200, 30);
            panel.add(subjectLabel);
            y += 40; // Increment Y-coordinate for next label
        }
        
        // Revalidate and repaint the panel to reflect the changes
        panel.revalidate();
        panel.repaint();
    }

    public static void main(String[] args) {
        routine r = new routine();
    }
}
