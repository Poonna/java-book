import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DrawingBoardTest {
    public DrawingBoardTest() {
        DrawingBoard panel = new DrawingBoard();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(panel);
        application.setSize(500, 500);
        application.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawingBoardTest();
            }
        });
    }
}
