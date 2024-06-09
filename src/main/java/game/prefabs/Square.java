package game.prefabs;

import game.abstractions.GameObject;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;

import game.Vector2D;

public class Square extends GameObject {

    public Square() {
        
    }
    public void Draw() {
        Vector2D position = this.getPosition();
        glBegin(GL_QUADS);
        glColor4f(1.0f, 0, 0, 0);
        glVertex2f(position.x, position.y);//top left
        glVertex2f(position.x + this.getScale(), position.y);//top right
        glVertex2f(position.x + this.getScale(), position.y - this.getScale());//bottom right
        glVertex2f(position.x, position.y - this.getScale());//bottom left
        glEnd();
    }
    public void Physics(float deltaTime) {
        
    }
}
