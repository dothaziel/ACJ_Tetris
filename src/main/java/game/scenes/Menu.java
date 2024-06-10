package game.scenes;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_E;

import java.util.ArrayList;

import game.KeyListener;
import game.MouseListener;
import game.Window;
import game.abstractions.GameObject;
import game.abstractions.Scene;
import game.prefabs.Square;



public class Menu extends Scene {
    
    private Square square;
    private ArrayList<GameObject> sceneObjects;

    public Menu() {
        sceneObjects = new ArrayList<>();
        
    }

    
    @Override
    public void update(float deltaTime) {
        if(KeyListener.isKeyPressed(GLFW_KEY_E)) {
            square = new Square();
            square.setPosition(MouseListener.getX(), MouseListener.getY());
            square.setScale(0.1f);
            square.Draw();
            sceneObjects.add(square);
        }

        for(GameObject object : sceneObjects) {
            object.Draw();
        }
    }
}
