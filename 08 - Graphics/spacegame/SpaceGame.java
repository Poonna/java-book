/**
 * Created by poonna on 2/27/18 AD.
 */

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class SpaceGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame game = new JFrame();
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game.setSize(800, 600);
                game.add(new ShootingScene());
                game.setVisible(true);
            }
        });
    }
}
