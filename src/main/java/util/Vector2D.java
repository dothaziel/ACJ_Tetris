package util;

public class Vector2D {
    private float x;
    private float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    //============= Getters =============
    public float getX() { return x; }
    public float getY() { return y; }

    //============ Setters ===============
    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }
}
