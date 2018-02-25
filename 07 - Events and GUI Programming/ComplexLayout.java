import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class ComplexLayout extends JFrame {
    public ComplexLayout() {
        super("Complex Layout");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel keypad = new JPanel();
        keypad.setLayout(new GridLayout(3, 3));
        keypad.add(new JButton("7"));
        keypad.add(new JButton("8"));
        keypad.add(new JButton("9"));
        keypad.add(new JButton("4"));
        keypad.add(new JButton("5"));
        keypad.add(new JButton("6"));
        keypad.add(new JButton("1"));
        keypad.add(new JButton("2"));
        keypad.add(new JButton("3"));

        JPanel allKeys = new JPanel();
        allKeys.add(keypad);

        ImageIcon ideaIcon = new ImageIcon("idea-1.png");
        allKeys.add(new JButton("OK", ideaIcon));

        mainPanel.add(new JTextField(), BorderLayout.NORTH);
        mainPanel.add(allKeys, BorderLayout.CENTER);
        mainPanel.add(new JLabel("Version 1.0.0"), BorderLayout.SOUTH);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        ComplexLayout app = new ComplexLayout();
        app.setVisible(true);
    }
}
