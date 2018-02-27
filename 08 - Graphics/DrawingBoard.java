import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import java.util.ArrayList;

public class DrawingBoard extends JPanel {
    private ArrayList<Integer> xPoints = new ArrayList<>();
    private ArrayList<Integer> yPoints = new ArrayList<>();
    private ArrayList<Float> inkLevels = new ArrayList<>();

    private float inkLevel;

    private static final float INK_DEPLETION_RATE = 0.005f;
    private static final float INK_STOP_CONCENTRATION = 1.5f;
    private static final int INK_WIDTH = 12;

    public DrawingBoard() {
        super();

        setBackground(Color.WHITE);
        inkLevel = 0.0f;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Do nothing
            }

            @Override
            public void mousePressed(MouseEvent e) {
                xPoints.add(e.getX());
                yPoints.add(e.getY());
                inkLevel = 0.0f;
                inkLevels.add(inkLevel);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                xPoints.add(e.getX());
                yPoints.add(e.getY());
                inkLevel /= INK_STOP_CONCENTRATION;
                inkLevels.add(inkLevel);
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Do nothing
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // Do nothing
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                xPoints.add(e.getX());
                yPoints.add(e.getY());
                inkLevel += INK_DEPLETION_RATE;
                if (inkLevel > 1.0f)
                    inkLevel = 1.0f;
                inkLevels.add(inkLevel);
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < xPoints.size(); i++) {
            float inkLevel = inkLevels.get(i);
            int width = (int)(INK_WIDTH * (0.2f + (1.0f - inkLevel) * 0.8f));
            g.setColor(new Color(inkLevel, inkLevel, inkLevel));
            g.fillOval(xPoints.get(i), yPoints.get(i), width, width);
        }
    }
}
