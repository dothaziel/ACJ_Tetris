package game.prefabs;

import game.abstractions.GameObject;
import util.Dimension;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class LevelBox extends GameObject {
    private Dimension dim = new Dimension(0.35f, 0.075f);


    public LevelBox() {}
    
    @Override
    public void Draw() {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.9f, 0);

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
