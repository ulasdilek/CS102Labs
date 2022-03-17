package lab03;

import java.util.Scanner;

public class GameTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the difficulty (1 - 2 - 3): ");
        int dif = sc.nextInt();
        // sc.close();
        Game game = new Game(dif);
        game.play();
    }
}
