package util;

import java.util.*;

public class SceneMath {

    public static List<Vector2D> getCorners(Dimension dim, Vector2D pos) {
        List<Vector2D> corners = new ArrayList<>();

        corners.add(new Vector2D(pos.getX() - (dim.getWidth()), pos.getY() + (dim.getHeight())));
        corners.add(new Vector2D(pos.getX() + (dim.getWidth()), pos.getY() + (dim.getHeight())));
        corners.add(new Vector2D(pos.getX() + (dim.getWidth()), pos.getY() - (dim.getHeight())));
        corners.add(new Vector2D(pos.getX() - (dim.getWidth()), pos.getY() - (dim.getHeight())));

        // corners.add(new Vector2D(pos.getX() - (dim.getWidth() / 2), pos.getY() + (dim.getHeight() / 2)));
        // corners.add(new Vector2D(pos.getX() + (dim.getWidth() / 2), pos.getY() + (dim.getHeight() / 2)));
        // corners.add(new Vector2D(pos.getX() + (dim.getWidth() / 2), pos.getY() - (dim.getHeight() / 2)));
        // corners.add(new Vector2D(pos.getX() - (dim.getWidth() / 2), pos.getY() - (dim.getHeight() / 2)));

        return corners;
    }
    
}
