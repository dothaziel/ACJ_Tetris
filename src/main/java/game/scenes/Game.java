package game.scenes;

import game.abstractions.GameObject;
import game.abstractions.Scene;
import game.prefabs.HoldBox;
import game.prefabs.LevelBox;
import game.prefabs.NextBox;
import game.prefabs.Playfield;
import game.prefabs.ScoreBox;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;

import java.util.*;
import util.Texture;

public class Game extends Scene {
    Set<GameObject> objects = new HashSet<>();
    int testImg;
    public Game() {
        objects.add(new Playfield());
        objects.add(new LevelBox());
        objects.add(new HoldBox());
        objects.add(new NextBox());
        objects.add(new ScoreBox());

        this.testImg = Texture.loadTexture("src\\main\\java\\game\\scenes\\polkafail.png");
    }

    @Override
    public void update(float deltaTime) {
        for(GameObject obj : objects) {
            obj.Draw();
        }
        glEnable(GL_TEXTURE_2D);
        Texture.bindTexture(testImg);
        System.out.println(testImg);
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0); glVertex2f(-0.5f, 0.5f);  // Top-left
        glTexCoord2f(1, 0); glVertex2f(0.5f, 0.5f);   // Top-right
        glTexCoord2f(1, 1); glVertex2f(0.5f, -0.5f);  // Bottom-right
        glTexCoord2f(0, 1); glVertex2f(-0.5f, -0.5f); // Bottom-left
        glEnd();

// Unbind the texture
glBindTexture(GL_TEXTURE_2D, 0);
    }
}
