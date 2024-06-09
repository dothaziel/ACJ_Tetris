package game;

import game.scenes.Menu;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import util.Time;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private int width, height;
    private String title;
    // Window pointer.
    private long glfwWindow;

    public float r,g,b,a;

    // Window class instance
    public static Window window = null;

    // The current rendered scene
    public static Scene currentScene = null;

    private Window() {
        this.width  = 1920;
        this.height = 1080;
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
                currentScene = new Menu();
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

        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);
    }
    public void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        if(!glfwInit()) {
            throw  new IllegalStateException("Unable to initialize GLFW.");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // Display the window
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // Make the window resizable
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE); // The window start maximized

        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL); // Create the window
        if(glfwWindow == NULL) {
            throw new IllegalStateException("Failed to create GLFW window."); // Erro handling
        }

        glfwSetCursorPosCallback(glfwWindow, MouseListener::mousePosCallback); // Mouse listener setup
        glfwSetMouseButtonCallback(glfwWindow, MouseListener::mouseButtonCallback); // Mouse buttons listener setup
        glfwSetScrollCallback(glfwWindow, MouseListener::mouseScrollCallback); // Mouse scroll setup
        glfwSetKeyCallback(glfwWindow, KeyListener::KeyCallback); // Key events setup

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
