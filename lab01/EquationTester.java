package lab01;

/**
 * The tester class for {@code Equation}
 * @see Equation
 * @author Ulas Dilek
 * @version v1.0
 */

import java.util.Scanner;

public class EquationTester {
    static Scanner in;
    public static void main(String[] args) {
        in = new Scanner (System.in);
        int input;
        do {
            System.out.println("\nEXIT : 0\nADD TWO EQUATIONS : 1\nSUBSTRACT TWO EQUATIONS : 2\nCOMPARE TWO EQUATIONS : 3\nREDUCE : 4\n");
            input = in.nextInt();
            switch (input) {
                case 0:
                    break;
                case 1: 
                    sum();
                    break;
                case 2:
                    substract();
                    break;
                case 3:
                    compare();
                    break;
                case 4:
                    reduce();
                    break;
                default:
                    System.out.println("--- invalid input ---");
            }
        } while (input != 0);
        System.out.println("see ya!");
    }

    private static void sum() {
        System.out.print("Enter the value of a, b and c for the first equation: ");
        Equation eq1 = new Equation(in.nextInt(), in.nextInt(), in.nextInt());
        in.nextLine();
        System.out.print("Enter the value of a, b and c for the second equation: ");
        Equation eq2 = new Equation(in.nextInt(), in.nextInt(), in.nextInt());
        in.nextLine();
        System.out.println("The first equation is: " + eq1.toString());
        System.out.println("The second equation is: " + eq2.toString());
        System.out.println("The sum of the equations: " + eq1.add(eq2).toString());
    }

    private static void substract() {
        System.out.print("Enter the value of a, b and c for the first equation: ");
        Equation eq1 = new Equation(in.nextInt(), in.nextInt(), in.nextInt());
        in.nextLine();
        System.out.print("Enter the value of a, b and c for the second equation: ");
        Equation eq2 = new Equation(in.nextInt(), in.nextInt(), in.nextInt());
        in.nextLine();
        System.out.println("The first equation is: " + eq1.toString());
        System.out.println("The second equation is: " + eq2.toString());
        System.out.println("The substraciton of the equations: " + eq1.substract(eq2).toString());
    }

    private static void compare() {
        System.out.print("Enter the value of a, b and c for the first equation: ");
        Equation eq1 = new Equation(in.nextInt(), in.nextInt(), in.nextInt());
        in.nextLine();
        System.out.print("Enter the value of a, b and c for the second equation: ");
        Equation eq2 = new Equation(in.nextInt(), in.nextInt(), in.nextInt());
        in.nextLine();
        System.out.println("The first equation is: " + eq1.toString());
        System.out.println("The second equation is: " + eq2.toString());
        String same;
        if (eq1.equals(eq2)) {
            same = "same.";
        }
        else {
            same = "different.";
        }
        System.out.println("The equations are " + same);
    }

    private static void reduce() {
        System.out.print("Enter the value of a, b and c for the equation: ");
        Equation eq1 = new Equation(in.nextInt(), in.nextInt(), in.nextInt());
        in.nextLine();
        eq1.reduceEquation();
        System.out.println("The reduced version is: " + eq1.toString());
    }
}
