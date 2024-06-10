package game.scenes;

import game.abstractions.GameObject;
import game.abstractions.Scene;
import game.prefabs.HoldBox;
import game.prefabs.LevelBox;
import game.prefabs.NextBox;
import game.prefabs.Playfield;
import game.prefabs.ScoreBox;
import util.Vector2D;

import java.util.*;

public class Game extends Scene {
    Set<GameObject> objects = new HashSet<>();

    public Game() {
        objects.add(new Playfield());
        objects.add(new LevelBox());
        objects.add(new HoldBox());
        objects.add(new NextBox());
        objects.add(new ScoreBox()); 

        Playfield pf = Game.getPlayFieldFromSet(objects);
        List<Vector2D> corners = pf.getCorners();
        
    }

    private static Playfield getPlayFieldFromSet(Set<GameObject> set) {
        for (GameObject obj : set) {
            if (obj instanceof Playfield) {
                return (Playfield) obj;
            }
        }
        return null; // Retornar null si no se encontró un objeto de tipo PlayField
    }

    @Override
    public void update(float deltaTime) {
        for(GameObject obj : objects) {
            obj.run();
            if(obj instanceof Playfield) {

            }
        }
    }
}
