package game.prefabs;

import game.abstractions.GameObject;
import util.Dimension;
import util.SceneHelper;
import util.Vector2D;

import java.util.*;

import org.lwjgl.opengl.GL11;

public class LevelBox extends GameObject {
    private Dimension dim = new Dimension(0.35f, 0.075f);
    private Vector2D pos = new Vector2D(0.0f, 0.85f);
    private List<Vector2D> corners = new ArrayList<>();

    public LevelBox() {
        corners = SceneHelper.getCorners(dim, pos);
    }
    
    @Override
    public void run() {
        GL11.glPushMatrix();
        GL11.glTranslatef(pos.getX(), pos.getY(), 0);

        GL11.glColor3f(0.8f, 0.8f, 0.8f);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(-dim.getWidth(), -dim.getHeight());
        GL11.glVertex2f(dim.getWidth(), -dim.getHeight());
        GL11.glVertex2f(dim.getWidth(), dim.getHeight());
        GL11.glVertex2f(-dim.getWidth(), dim.getHeight());
        GL11.glEnd();

        GL11.glPopMatrix();

        SceneHelper.drawOutline(corners);
    }
    public void Physics(float deltaTime) {
        
    }
}
