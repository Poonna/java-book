/**
 * Created by poonna on 2/27/18 AD.
 */

import java.awt.*;

public class Alien extends GameObject {
    private GameScene scene;
    private int x, y;
    private int speedX = 10;
    private int speedY = 10;

    public Alien(GameScene scene, int x, int y) {
        this.scene = scene;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(double deltaTime) {
        if (x < 100) {
            speedX = 10;
        } else if (x > 700) {
            speedX = -10;
        }
        if (y < 100) {
            speedY = 10;
        } else if (y > 300) {
            speedY = -10;
        }
        x += speedX;
        y += speedY;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }
}
