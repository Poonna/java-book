import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameScene extends JPanel {
    private BufferedImage star;
    private int positionX = 180;
    private int positionY = 120;

    public GameScene() {
        setBackground(Color.BLACK);
        setFocusable(true);

        // Loading star image
        try {
            star = ImageIO.read(new File("star.png"));
            if (star == null) {
                System.err.println("Unrecognized image type.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Error while loading image.");
            System.exit(1);
        }

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Do nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        positionX -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        positionX += 10;
                        repaint();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Do nothing
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(star, positionX, positionY, null);
    }
}
