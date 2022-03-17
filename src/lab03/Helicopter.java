package lab03;

public class Helicopter extends EnemyVehicle {
    
    private int speed;

    public Helicopter(int minX, int maxX, int y) {
        super(minX, maxX, y);
        speed = BASE_SPEED;
    }

    @Override
    public void move() {
        position.y -= speed;
        speed++;
    }

    @Override
    String getType() {
        return "Helicopter";
    }

    @Override
    public String toString() {
        return "A Helicopter is at location (" + position.getX() + ", " + position.getY()  + "). Its speed is " + speed + ". It has " + health + " points left.";
    }
    
}
