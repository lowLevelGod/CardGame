package cardgame;

import javax.swing.*;

import cardgame.CardTypes.Troops.Troop;

import java.awt.*;

public class GamePane extends JPanel {

    private final int GRID_WIDTH = 3;
    private final int GRID_HEIGHT = 7;
    private final int MID = GRID_HEIGHT / 2;

    public GamePane() {
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int sizew = getWidth() / 3;
        int sizeh = getHeight() / 7;
        // int width = getWidth() - (size * 2);
        // int height = getHeight() - (size * 2);

        // int y = (getHeight() - (size * GRID_HEIGHT)) / 2;
        int y = 0;
        for (int horz = 0; horz < GRID_HEIGHT; horz++) {
            // int x = (getWidth() - (size * GRID_WIDTH)) / 2;
            int x = 0;
            if (horz == MID)
            {
                g.setColor(Color.RED);
                g.fillRect(x, y, sizew, sizeh);
                g2d.drawString("NO MAN'S LAND", x + 3 * sizew / 5, y + 3 * sizeh / 5);
            }
            else
            {
            g.setColor(Color.WHITE);
            }
            for (int vert = 0; vert < GRID_WIDTH; vert++) {
                if (horz != MID)
                {
                    g.drawRect(x, y, sizew, sizeh);
                    Troop troop = GameManager.getCardAtPos(new Coord(horz, vert));
                    if (troop != null)
                    {
                        g2d.drawString(troop.getName(), x + sizew / 4, y + sizeh / 4);
                        g2d.drawString("BP: " + troop.getBasePower(), x + sizew / 4, y + sizeh / 4 + g2d.getFont().getSize() * 2);
                    }
                    else
                    g2d.drawString("NO TROOP", x + sizew / 4, y + sizeh / 4);
                }else
                {
                    g.setColor(Color.RED);
                    g.fillRect(x, y, sizew, sizeh);
                }
                x += sizew;
            }
            y += sizeh;
        }
        g2d.dispose();
    }

}