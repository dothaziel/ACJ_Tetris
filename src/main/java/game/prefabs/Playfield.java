package game.prefabs;

import game.abstractions.GameObject;
import util.Dimension;
import util.SceneMath;
import util.Vector2D;

import java.util.*;

import org.lwjgl.opengl.GL11;

public class Playfield extends GameObject {
    private Dimension dim = new Dimension((0.85f * 0.5f), 0.85f);
    private Vector2D pos = new Vector2D(-0.3f, -0.1f);
    private List<Vector2D> corners = new ArrayList<>();


    public Playfield() {
        corners = SceneMath.getCorners(dim, pos);


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

        for (int i = 1; i < 10; i++) {
            GL11.glBegin(GL11.GL_LINES);
            GL11.glColor3f(0.0f, 0.0f, 0.5f);
            GL11.glVertex2f(corners.get(0).getX() + (i * (dim.getWidth()*0.2f)), corners.get(0).getY());
            GL11.glVertex2f(corners.get(0).getX() + (i * (dim.getWidth()*0.2f)), corners.get(3).getY());
            GL11.glEnd();
        }

        for (int i = 1; i < 20; i++) {
            GL11.glBegin(GL11.GL_LINES);
            GL11.glColor3f(0.0f, 0.0f, 0.5f);
            GL11.glVertex2f(corners.get(0).getX(), corners.get(3).getY() + (i * (dim.getHeight()*0.1f)));
            GL11.glVertex2f(corners.get(1).getX(), corners.get(3).getY() + (i * (dim.getHeight()*0.1f)));
            GL11.glEnd();
        }
    }
    public void Physics(float deltaTime) {
        
    }
}
