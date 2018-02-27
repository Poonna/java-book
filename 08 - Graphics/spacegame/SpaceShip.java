/**
 * Created by poonna on 27/2/18 AD.
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpaceShip extends GameObject {
    private ShootingScene scene;
    private Image image;
    private int x, y;
    private int speed = 10;

    private static final double FIRING_INTERVAL = 0.5;
    private double lastFiringElapsed = 0.0;

    public SpaceShip(ShootingScene scene, int x, int y) {
        this.scene = scene;

        // Load player image
        try {
            image = ImageIO.read(new File("images/star.png"));
            if (image == null) {
                System.err.println("Unrecognized image type.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Error while loading image.");
            System.exit(1);
        }

        this.x = x - image.getWidth(null) / 2;
        this.y = y - image.getHeight(null) / 2;
    }

    @Override
    public void update(double deltaTime) {
        if (scene.getKeyState(GameScene.KEY_UP) == GameScene.KeyState.DOWN) {
            y -= speed;
        }
        if (scene.getKeyState(GameScene.KEY_DOWN) == GameScene.KeyState.DOWN) {
            y += speed;
        }
        if (scene.getKeyState(GameScene.KEY_LEFT) == GameScene.KeyState.DOWN) {
            x -= speed;
        }
        if (scene.getKeyState(GameScene.KEY_RIGHT) == GameScene.KeyState.DOWN) {
            x += speed;
        }
        if (scene.getKeyState(GameScene.KEY_FIRE) == GameScene.KeyState.DOWN) {
            if (lastFiringElapsed >= FIRING_INTERVAL) {
                scene.fire(new Bullet(scene, x, y));
                lastFiringElapsed = 0.0;
            }
        }

        lastFiringElapsed += deltaTime;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, scene);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
