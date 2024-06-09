package game.prefabs;

import game.abstractions.GameObject;
import util.Dimension;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class ScoreBox extends GameObject {
    private Dimension dim = new Dimension(0.25f, 0.15f);


    public ScoreBox() {}
    
    @Override
    public void Draw() {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.65f, -0.6f, 0);

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
