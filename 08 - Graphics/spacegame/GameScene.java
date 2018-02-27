/**
 * Created by poonna on 2/27/18 AD.
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class GameScene extends JPanel {
    public static final int KEY_UP = 0;
    public static final int KEY_DOWN = 1;
    public static final int KEY_LEFT = 2;
    public static final int KEY_RIGHT = 3;
    public static final int KEY_FIRE = 4;

    public enum KeyState { UP, DOWN }

    private KeyState[] keyStates = new KeyState[5];

    private static final int DEFAULT_FRAME_RATE = 50;
    private long previousTime;

    private ArrayList<GameObject> gameObjects = new ArrayList<>();
    private ArrayList<GameObject> waitList = new ArrayList<>();

    public GameScene() {
        this(DEFAULT_FRAME_RATE);
    }

    public GameScene(int frameRate) {
        setBackground(Color.BLACK);
        setFocusable(true);
        setDoubleBuffered(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        keyStates[KEY_UP] = KeyState.DOWN;
                        break;
                    case KeyEvent.VK_DOWN:
                        keyStates[KEY_DOWN] = KeyState.DOWN;
                        break;
                    case KeyEvent.VK_LEFT:
                        keyStates[KEY_LEFT] = KeyState.DOWN;
                        break;
                    case KeyEvent.VK_RIGHT:
                        keyStates[KEY_RIGHT] = KeyState.DOWN;
                        break;
                    case KeyEvent.VK_SPACE:
                        keyStates[KEY_FIRE] = KeyState.DOWN;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        keyStates[KEY_UP] = KeyState.UP;
                        break;
                    case KeyEvent.VK_DOWN:
                        keyStates[KEY_DOWN] = KeyState.UP;
                        break;
                    case KeyEvent.VK_LEFT:
                        keyStates[KEY_LEFT] = KeyState.UP;
                        break;
                    case KeyEvent.VK_RIGHT:
                        keyStates[KEY_RIGHT] = KeyState.UP;
                        break;
                    case KeyEvent.VK_SPACE:
                        keyStates[KEY_FIRE] = KeyState.UP;
                        break;
                }
            }
        });

        previousTime = System.currentTimeMillis();

        Timer timer = new Timer(1000/frameRate, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAll();
            }
        });

        timer.start();
    }

    public void addGameObject(GameObject object) {
        waitList.add(object);
    }

    public KeyState getKeyState(int key) {
        return keyStates[key];
    }

    private void updateAll() {
        long currentTime = System.currentTimeMillis();
        double deltaTime = (currentTime - previousTime) / 1000.0f;
        previousTime = currentTime;

        // Call update() on game scene and all game objects
        update(deltaTime);
        for (GameObject gameObject : gameObjects) {
            gameObject.update(deltaTime);
        }

        // Prune dead game objects
        Iterator<GameObject> it = gameObjects.iterator();
        while (it.hasNext()) {
            GameObject gameObject = it.next();
            if (gameObject.isDestroyed()) {
                it.remove();
            }
        }

        // Add newly queued game objects
        for (GameObject object : waitList) {
            gameObjects.add(object);
        }
        waitList.clear();

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
        for (GameObject gameObject : gameObjects) {
            gameObject.draw(g);
        }
    }

    public abstract void update(double deltaTime);
    public abstract void render(Graphics g);
}
