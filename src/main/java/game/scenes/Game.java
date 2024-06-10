package game.scenes;

import game.abstractions.GameObject;
import game.abstractions.Scene;
import game.prefabs.HoldBox;
import game.prefabs.LevelBox;
import game.prefabs.NextBox;
import game.prefabs.Playfield;
import game.prefabs.ScoreBox;

import java.util.*;

public class Game extends Scene {
    Set<GameObject> objects = new HashSet<>();

    public Game() {
        objects.add(new Playfield());
        objects.add(new LevelBox());
        objects.add(new HoldBox());
        objects.add(new NextBox());
        objects.add(new ScoreBox());
    }

    @Override
    public void update(float deltaTime) {
        for(GameObject obj : objects) {
            obj.Draw();
        }
    }
}
