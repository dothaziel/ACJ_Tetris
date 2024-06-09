package game;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class KeyListener {
    private static KeyListener instance;
    private boolean KeyPressed[] = new boolean[350];

    private KeyListener() {

    }
    private static KeyListener get() {
        if(KeyListener.instance == null) {
            KeyListener.instance = new KeyListener();
        }
        return KeyListener.instance;
    }
    public static void KeyCallback(long window, int key, int scancode, int action, int mods) {
        if(action == GLFW_PRESS) {
            get().KeyPressed[key] = true;
        } else if(action == GLFW_RELEASE) {
            get().KeyPressed[key] = false;
        }
    }

    public static boolean isKeyPressed(int keyCode) {
        if(keyCode < get().KeyPressed.length) {
            return get().KeyPressed[keyCode];
        } else {
            return false;
        }
    }
}