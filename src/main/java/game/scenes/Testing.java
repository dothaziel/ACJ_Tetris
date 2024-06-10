package game.scenes;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_E;

import java.util.HashSet;
import java.util.Set;

import game.abstractions.PhysicsObject;
import game.abstractions.Scene;
import game.listeners.KeyListener;
import game.listeners.MouseListener;
import game.managers.SceneManager;
import game.prefabs.Square;
import util.Vector2D;

public class Testing extends Scene { 

    public Testing() {
        System.out.println("On Testing Scene");
    }

    @Override
    public void update(float deltaTime) {
        if(KeyListener.isKeyPressed(GLFW_KEY_E)) {
            SceneManager.instantiateObject(new Square(), new Vector2D(MouseListener.getX(), MouseListener.getY()), 0.1f);
            System.out.println("Object created.");
        }
    }
}
