package game.prefabs;

import game.abstractions.GameObject;
import util.Vector2D;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;

public class Square extends GameObject {

    public Square() {
        
    }
    public void Draw() {
        Vector2D pos = this.getPosition();
        glBegin(GL_QUADS);
        glColor4f(1.0f, 0, 0, 0);
        glVertex2f(pos.getX(), pos.getY());//top left
        glVertex2f(pos.getX() + this.getScale(), pos.getY());//top right
        glVertex2f(pos.getX() + this.getScale(), pos.getY() - this.getScale());//bottom right
        glVertex2f(pos.getX(), pos.getY() - this.getScale());//bottom left
        glEnd();
    }
    public void Physics(float deltaTime) {
        
    }
}
