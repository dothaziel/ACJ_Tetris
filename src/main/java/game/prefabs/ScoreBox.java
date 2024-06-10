package game.prefabs;

import game.abstractions.GameObject;
import util.Dimension;
import util.SceneHelper;
import util.Vector2D;

import java.util.*;

import org.lwjgl.opengl.GL11;

public class ScoreBox extends GameObject {
    private Dimension dim = new Dimension(0.25f, 0.15f);
    private Vector2D pos = new Vector2D(0.65f, -0.6f);
    private List<Vector2D> corners = new ArrayList<>();


    public ScoreBox() {
        corners = SceneHelper.getCorners(dim, pos);
    }
    
    @Override
    public void Draw() {
        GL11.glPushMatrix();
        GL11.glTranslatef(pos.getX(), pos.getY(), 0);
        GL11.glRotatef(0, 0, 0, 1);

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
