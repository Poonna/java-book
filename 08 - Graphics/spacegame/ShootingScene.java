/**
 * Created by poonna on 2/27/18 AD.
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class ShootingScene extends GameScene {
     private SpaceShip player;
     private ArrayList<GameObject> enemies = new ArrayList<GameObject>();
     private ArrayList<GameObject> bullets = new ArrayList<GameObject>();

     private Random random;
     private int score;
     private int respawnCount = 3;

     public ShootingScene() {
         player = new SpaceShip(this, 400, 500);
         addGameObject(player);
         random = new Random();
     }

     @Override
     public void update(double deltaTime) {
         for (GameObject bullet : bullets) {
             for (GameObject enemy : enemies) {
                 if (bullet.collides(enemy)) {
                     bullet.destroy();
                     enemy.destroy();

                     addScore(10);
                     respawnCount++;
                 }
             }
         }

         while (respawnCount > 0) {
             Alien alien = new Alien(this, 100 + random.nextInt(700), 100 + random.nextInt(200));
             enemies.add(alien);
             addGameObject(alien);
             respawnCount--;
         }
     }

     @Override
     public void render(Graphics g) {
         g.setColor(Color.WHITE);
         g.drawString("Score: " + score, 10, 20);
     }

     public void fire(Bullet bullet) {
         bullets.add(bullet);
         addGameObject(bullet);
     }

     public void addScore(int points) {
         score += points;
     }
}
