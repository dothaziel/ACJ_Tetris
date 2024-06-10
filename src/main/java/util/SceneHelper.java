package util;

import java.util.*;

import org.lwjgl.opengl.GL11;

public class SceneHelper {

    public static List<Vector2D> getCorners(Dimension dim, Vector2D pos) {
        List<Vector2D> corners = new ArrayList<>();

        corners.add(new Vector2D(pos.getX() - (dim.getWidth()), pos.getY() + (dim.getHeight())));
        corners.add(new Vector2D(pos.getX() + (dim.getWidth()), pos.getY() + (dim.getHeight())));
        corners.add(new Vector2D(pos.getX() + (dim.getWidth()), pos.getY() - (dim.getHeight())));
        corners.add(new Vector2D(pos.getX() - (dim.getWidth()), pos.getY() - (dim.getHeight())));

        // corners.add(new Vector2D(pos.getX() - (dim.getWidth() / 2), pos.getY() + (dim.getHeight() / 2)));
        // corners.add(new Vector2D(pos.getX() + (dim.getWidth() / 2), pos.getY() + (dim.getHeight() / 2)));
        // corners.add(new Vector2D(pos.getX() + (dim.getWidth() / 2), pos.getY() - (dim.getHeight() / 2)));
        // corners.add(new Vector2D(pos.getX() - (dim.getWidth() / 2), pos.getY() - (dim.getHeight() / 2)));

        return corners;
    }

    public static void drawOutline(List<Vector2D> corners) {
        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3f(0.0f, 0.0f, 0.5f);
        GL11.glVertex2f(corners.get(0).getX(), corners.get(0).getY());
        GL11.glVertex2f(corners.get(1).getX(), corners.get(0).getY());
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3f(0.0f, 0.0f, 0.5f);
        GL11.glVertex2f(corners.get(1).getX(), corners.get(1).getY());
        GL11.glVertex2f(corners.get(1).getX(), corners.get(2).getY());
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3f(0.0f, 0.0f, 0.5f);
        GL11.glVertex2f(corners.get(2).getX(), corners.get(2).getY());
        GL11.glVertex2f(corners.get(3).getX(), corners.get(2).getY());
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3f(0.0f, 0.0f, 0.5f);
        GL11.glVertex2f(corners.get(3).getX(), corners.get(3).getY());
        GL11.glVertex2f(corners.get(3).getX(), corners.get(0).getY());
        GL11.glEnd();
    }
}
