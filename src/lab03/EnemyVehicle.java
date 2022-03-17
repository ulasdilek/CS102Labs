package lab03;

import java.awt.Point;
import java.util.Random;

public abstract class EnemyVehicle implements Movable, Destructible {

    final int BASE_SPEED = 3;
    protected Point position;
    protected double health;
    
    public EnemyVehicle(int minX, int maxX, int y){
        Random rnd = new Random();
        position = new Point(rnd.nextInt(maxX - minX) + minX, y);
        health = 100;
    }

    int getDistanceToBorder() {
        return (int) position.getY();
    }

    abstract String getType();

    @Override
    public void move() {
        position.y -= BASE_SPEED;
    }

    @Override
    public Point getLocation() {
        return position;
    }

    @Override
    public boolean isDestroyed() {
        return health <= 0;
    }

    @Override
    public void takeDamage(double damage) {
        health -= damage;
    }
    
}
