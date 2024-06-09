package game.prefabs;

import game.abstractions.GameObject;
import util.Dimension;
import util.Vector2D;

import org.lwjgl.opengl.GL11;

public class LevelBox extends GameObject {
    private Dimension dim = new Dimension(0.35f, 0.075f);
    private Vector2D pos = new Vector2D(0.0f, 0.85f);


    public LevelBox() {}
    
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
