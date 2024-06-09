package game.scenes;

import game.Scene;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;

import game.MouseListener;

public class Menu extends Scene {
    private long window;
    private float x = 0f;
    private float y = 0f;
    private float dis = 0.1f;
    private int width;
    private int height;
    public Menu(long window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;
    }

    
    @Override
    public void update(float deltaTime) {
        glfwMakeContextCurrent(window);

        //change the square position to that of the mouse
        //turn the mouse number into ndc 
        x = MouseListener.getX() / width * 2 - 1;
        y = 1 - MouseListener.getY() / height * 2;

        //draw the square
        glBegin(GL_QUADS);
        glColor4f(1.0f, 0, 0, 0);
        glVertex2f(x,y);//top left
        glVertex2f(x + dis, y);//top right
        glVertex2f(x + dis, y - dis);//bottom right
        glVertex2f(x, y - dis);//bottom left
        glEnd();
    }
}
