package game.abstractions;

public abstract class PhysicsObject extends GameObject{
    public void fixedUpdate() {
        this.runPhysics();
    }
    public abstract void runPhysics();
}
