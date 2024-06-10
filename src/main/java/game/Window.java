package game;

import java.awt.Toolkit;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_MAXIMIZED;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.glfwSetScrollCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.system.MemoryUtil.NULL;

import game.scenes.Game;
import game.scenes.Menu;
import game.abstractions.Scene;
import game.listeners.KeyListener;
import game.listeners.MouseListener;
import util.Time;

public class Window {
    private String title;
    // Window pointer.
    private long glfwWindow;
    //methods to get the screen width and height
    public int screen_width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public int screen_height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public final int WINDOW_HEIGHT = (int)Math.floor(screen_height * 0.8);
    public final int WINDOW_WIDTH = (int)Math.floor(WINDOW_HEIGHT * 0.785);
    public float r,g,b,a;

    // Window class instance
    public static Window window = null;

    // The current rendered scene
    public static Scene currentScene = null;

    private Window() {
        this.title = "Tetris by ACJ";

        // We define the initial window background
        this.r = 1.0f;
        this.g = 1.0f;
        this.b = 1.0f;
        this.a = 1.0f;
    }

    /**
     * Switch scenes
     * @param newScene scene Id
     */
    public static void changeScene(int newScene) {
        switch(newScene) {
            case 0:
                currentScene = new Game();
                //currentScene.init();
                break;
            default:
                assert false : "Unknown Scene '" + newScene + "'";
                break;
        }
    }

    // Create a Window if no one exists
    // Singleton.
    public static Window get() {
        if(Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    // Window initialization.
    public void run(){
        // Window params setup
        init();

        // Main game loop function call
        loop();

        glfwTerminate();
    }
    public void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        if(!glfwInit()) {
            throw  new IllegalStateException("Unable to initialize GLFW.");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, 0);
        glfwWindowHint(GLFW_MAXIMIZED, 0);

        glfwWindow = glfwCreateWindow(WINDOW_WIDTH, WINDOW_HEIGHT, this.title, NULL, NULL); // Create the window
        if(glfwWindow == NULL) {
            throw new IllegalStateException("Failed to create GLFW window."); // Erro handling
        }
        
        glfwSetWindowPos(glfwWindow, (screen_width - WINDOW_WIDTH) / 2, (screen_height - WINDOW_HEIGHT) / 2);

        glfwSetCursorPosCallback(glfwWindow, MouseListener::mousePosCallback);
        glfwSetMouseButtonCallback(glfwWindow, MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(glfwWindow, MouseListener::mouseScrollCallback);
        glfwSetKeyCallback(glfwWindow, KeyListener::KeyCallback);

        glfwMakeContextCurrent(glfwWindow); // Setup opengl window context
        glfwSwapInterval(1); // Enable V-Sync

        glfwShowWindow(glfwWindow); // Display the final window
        GL.createCapabilities(); // Enable open gl api
        Window.changeScene(0); // Init on first scene.
    }

    // Game loop
    private void loop() {
        // Delta time handler
        float beginTime = Time.getTime();
        float endTime;
        float dt = -1.0f;

        while(!glfwWindowShouldClose(glfwWindow)) {
            glfwPollEvents();
            glClearColor(r, g, b, a);
            glClear(GL_COLOR_BUFFER_BIT);

            if(dt >= 0) {
                currentScene.update(dt); // Call the scene update function (function that repeats on every frame.)
            }

            glfwSwapBuffers(glfwWindow);
            endTime = Time.getTime();
            dt = endTime - beginTime;
            beginTime = endTime;
        }
    }
}
