package game.abstractions;

import util.Vector2D;

public abstract class GameObject {
    private Vector2D position;
    private float scale;

    public GameObject() {
        this.position = new Vector2D(0.0f, 0.0f);
        this.scale = 1.0f;
    }

    public abstract void Draw(); 

    public void setPosition(float x, float y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public Vector2D getPosition() {
        return this.position;
    }
    public float getScale() {
        return this.scale;
    }
}