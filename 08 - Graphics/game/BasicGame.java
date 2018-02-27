import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class BasicGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame game = new JFrame();
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game.setSize(400, 300);
                game.add(new GameScene());
                game.setVisible(true);
            }
        });
    }
}
