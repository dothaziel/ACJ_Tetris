package game.prefabs;

import game.abstractions.GameObject;
import util.Dimension;
import util.Vector2D;

import java.util.*;

import org.lwjgl.opengl.GL11;

public class Playfield extends GameObject {
    private Dimension dim = new Dimension(0.6f, 0.85f);
    private Vector2D pos = new Vector2D(-0.3f, -0.1f);
    private List<Vector2D> corners = new ArrayList<>();


    public Playfield() {
        corners.add(new Vector2D(pos.getX() - (dim.getWidth() / 2), pos.getY() + (dim.getHeight() / 2)));
        corners.add(new Vector2D(pos.getX() + (dim.getWidth() / 2), pos.getY() + (dim.getHeight() / 2)));
        corners.add(new Vector2D(pos.getX() + (dim.getWidth() / 2), pos.getY() - (dim.getHeight() / 2)));
        corners.add(new Vector2D(pos.getX() - (dim.getWidth() / 2), pos.getY() - (dim.getHeight() / 2)));
    }
    
    @Override
    public void Draw() {
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
    }
    public void Physics(float deltaTime) {
        
    }
}
