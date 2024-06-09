package game.abstractions;

public abstract class Scene {
    public float gravity;
    public Scene() {
        this.gravity = 9.8f;
    }

    public abstract void update(float dt);
}