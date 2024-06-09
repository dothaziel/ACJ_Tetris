package game.abstractions;

import game.Vector2D;

public abstract class GameObject {
    private Vector2D Position;
    private float Scale;

    public GameObject() {
        this.Position = new Vector2D(0.0f, 0.0f);
        this.Scale = 1.0f;
    }

    public void setPosition(float x, float y) {
        this.Position.x = x;
        this.Position.y = y;
    }

    public void setScale(float scale) {
        this.Scale = scale;
    }

    public Vector2D getPosition() {
        return this.Position;
    }
    public float getScale() {
        return this.Scale;
    }
}