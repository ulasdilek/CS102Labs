package lab03;

import java.util.ArrayList;
import java.util.Scanner;

public class Game implements Difficulty{

    public final int STARTING_DISTANCE = 20;
    private final int MAX_NO_OF_PASSING_ENEMIES = 5;

    private int difficulty, score, minX, maxX, noOfEnemiesPast;
    private Player player;
    private ArrayList<EnemyVehicle> enemies;
    private GamePlotter gp;

    public Game(int difficulty) {
        setDifficulty(difficulty);
        score = 0;
        noOfEnemiesPast = 0;
        player = new Player();
        enemies = new ArrayList<>();
        minX = 0;
        maxX = 5 * this.difficulty;
        for (int i = 0; i < this.difficulty*2; i++) {
            enemies.add(getNewRandomVehicle());
        }
        gp = new GamePlotter(this);
    }

    public ArrayList<EnemyVehicle> getEnemies() {
        return enemies;
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        while (noOfEnemiesPast < MAX_NO_OF_PASSING_ENEMIES) {
            printGameState();
            System.out.print("X and Y coordinates of the target: ");
            int x = in.nextInt();
            int y = in.nextInt();
            player.attack(x, y, enemies);
            enemiesTurn();
        }
        in.close();
        System.out.println("\n-------------------------------------------\n\nThe enemies are within our borders!\nThey've won, commander.\nAt least you were able to take down " + score + " of them.");
    }


    @Override
    public void setDifficulty(int difficulty) {
        if (difficulty < 1 || difficulty > 3) {
            this.difficulty = 1;
        }
        else {
            this.difficulty = difficulty;
        }
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }

    private EnemyVehicle getNewRandomVehicle() {
        if (Math.round(Math.random()) == 0) {
            return new Tank(minX, maxX, STARTING_DISTANCE);
        }
        return new Helicopter(minX, maxX, STARTING_DISTANCE);
    }

    private void enemiesTurn() {
        for (int i = 0; i < enemies.size(); i++) {
            EnemyVehicle enemy = enemies.get(i);
            if (enemy.isDestroyed()) {
                enemies.set(i, getNewRandomVehicle());
                score++;
            }
            else if (enemy.getDistanceToBorder() <= 0) {
                enemies.set(i, getNewRandomVehicle());
                noOfEnemiesPast++;
            }
             else {
                enemy.move();
            }
        }
    }

    private void printGameState() {
        gp.plot();
        System.out.println("Current score: " + score);
        System.out.println("Number of enemies within our borders: " + noOfEnemiesPast);
        for (EnemyVehicle enemy : enemies) {
            System.out.println(enemy);
        }
    }
    
}
