package lab03;

public class Tank extends EnemyVehicle{

    public Tank(int minX, int maxX, int y) {
        super(minX, maxX, y);
    }

    @Override
    public void takeDamage(double damage) {
        super.takeDamage(damage/2);
    }
    
    @Override
    String getType() {
        return "Tank";
    }

    @Override
    public String toString() {
        return "A Tank is at location (" + position.getX() + ", " + position.getY()  + "). It has " + health + " points left.";
    }
    
}
