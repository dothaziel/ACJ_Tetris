package game.managers;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_0;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_1;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_2;

import game.abstractions.GameObject;
import game.abstractions.PhysicsObject;
import game.abstractions.Scene;
import game.listeners.KeyListener;
import game.scenes.Game;
import game.scenes.Menu;
import game.scenes.Testing;
import util.Vector2D;

public class SceneManager {
    private Scene current = null;
    private static SceneManager instance = null;

    public SceneManager() {
        current = new Menu();
    }

    public static Scene getScene() {
        return SceneManager.get().current;
    }
    public static void setCurrent(Scene scene) {
        SceneManager.get().current = scene;
    }

    public static SceneManager get() {
        if(SceneManager.instance == null) {
            SceneManager.instance = new SceneManager();
        }

        return SceneManager.instance;
    }

    public static void instantiateObject(GameObject obj, Vector2D position, float Scale) {
        obj.setPosition(position.getX(), position.getY());
        obj.setScale(Scale);
        SceneManager.get().current.gameObjects.add(obj);
    }

    public static void instantiatePhysicsObject(PhysicsObject obj, Vector2D position) {
        obj.setPosition(position.getX(), position.getY());
        SceneManager.get().current.physicsObjects.add(obj);
    }

    public static void changeScene(int index) {
        switch (index) {
            case 0:
                SceneManager.setCurrent(new Menu());
                break;
            case 1:
                SceneManager.setCurrent(new Game());
                break;
            case 2: 
                SceneManager.setCurrent(new Testing());
                break;
            default:
                break;
        }
    }

    public static void runScene(float dt) {
        SceneManager.getScene().update(dt);
        for(GameObject obj : SceneManager.getScene().gameObjects) {
            obj.run();
        }

        if(KeyListener.isKeyPressed(GLFW_KEY_0)) {
            SceneManager.changeScene(0);
        } else if(KeyListener.isKeyPressed(GLFW_KEY_2)) {
            SceneManager.changeScene(2);
        } else if(KeyListener.isKeyPressed(GLFW_KEY_1)) {
            SceneManager.changeScene(1);
        }
    }
}
