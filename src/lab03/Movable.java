package lab03;

import java.awt.Point;

public interface Movable {

    // Objects move only in the -y direction
    void move();

    Point getLocation();
    
}
