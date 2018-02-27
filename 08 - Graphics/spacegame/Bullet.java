/**
 * Created by poonna on 2/27/18 AD.
 */

import java.awt.*;

public class Bullet extends GameObject {
    private GameScene scene;
    private int x, y;
    private int speed = 20;

    public Bullet(GameScene scene, int x, int y) {
        this.scene = scene;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(double deltaTime) {
        y -= speed;
        if (y < 0) {
            destroy();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 5, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 5, 10);
    }
}
