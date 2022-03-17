package lab03;

import java.util.ArrayList;
import java.awt.Point;

public class Player {

    final double BOMB_RADIUS = 2.0;
    final double DAMAGE = 50.0;

    public Player() {

    }

    public void attack(int x, int y, ArrayList<EnemyVehicle> enemies) {
        Point impactPosition = new Point(x, y);
        for (EnemyVehicle enemy : enemies) {
            double distance = impactPosition.distance(enemy.getLocation());
            if (distance <= BOMB_RADIUS) {
                enemy.takeDamage(DAMAGE);
            }
        }
    }
    
}
