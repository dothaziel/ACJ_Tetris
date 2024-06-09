package game.scenes;

import game.MouseListener;
import game.Window;
import game.abstractions.Scene;
import game.prefabs.Square;



public class Menu extends Scene {
    
    private Square square;

    public Menu() {
        square = new Square();
        square.setScale(0.1f);
        square.setPosition(-0.05f, 0.0f);
    }

    
    @Override
    public void update(float deltaTime) {
        float x = (2*(MouseListener.getX()-(Window.get().WINDOW_WIDTH/2)))/Window.get().WINDOW_WIDTH;
        float y = -(2*(MouseListener.getY()-(Window.get().WINDOW_HEIGHT/2)))/Window.get().WINDOW_HEIGHT;
        square.setPosition(x, y);
        square.Draw();
    }
}
