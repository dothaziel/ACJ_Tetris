package game.abstractions;

import java.util.HashSet;
import java.util.Set;

public abstract class Scene {
    public float gravity;
    public Set<PhysicsObject> physicsObjects = new HashSet<>();
    public Set<GameObject> gameObjects = new HashSet<>();
    public Scene() {
        this.gravity = 9.8f;
    }

    public abstract void update(float dt);
}