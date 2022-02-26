package lab02;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerArrayTester {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Scanner scan = null;
        String filename;
        boolean loop = true;
        do {
            System.out.print("Please enter the filename: ");
            filename = in.nextLine();
            try {
                scan = new Scanner(new File("./lab02/inputs/" + filename));
                loop = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                loop = true;
            }
        }
        while (loop);
        in.close();
        System.out.println();
        IntegerArrayList numbers = new IntegerArrayList(new ArrayList<>());
        while (scan.hasNext()) {
            String number = scan.next();
            numbers.addIntegerArray(number);
            System.out.println("Adding number: " + number);
            System.out.println("Number count: " + numbers.getSize());
        }
        int start = 0;
        int middle = numbers.getSize() / 2;
        int end = numbers.getSize();
        System.out.println("\nstart index = " + start);
        System.out.println("middle index = " + middle);
        System.out.println("start index = " + end);

        System.out.println("\nMinimum of all numbers:");
        System.out.println(numbers.min(start, end));
        System.out.println("Minimum of the first half:");
        System.out.println(numbers.min(start, middle));
        System.out.println("Minimum of the second half:");
        System.out.println(numbers.min(middle, end));
        /*
        System.out.println("\nAdding each consecutive pair...");
        for (int i = 0; i < numbers.getSize() - 1; i++) {
            IntegerArray result = numbers.getIntegerArray(i).add(numbers.getIntegerArray(i + 1));
            System.out.println(numbers.getIntegerArray(i) + " + " + numbers.getIntegerArray(i + 1) + " = " + result);
        }
        System.out.println("\nSubtracting min from each number...");
        IntegerArray min = numbers.min(0, numbers.getSize());
        for (int i = 0; i < numbers.getSize(); i++) {
            IntegerArray result = numbers.getIntegerArray(i).subtract(min);
            System.out.println(numbers.getIntegerArray(i) + " - " + min + " = " + result);
        }
        */
        System.out.println("\nThank you for testing my basic BigInteger class\n");
    }
    
    /*
    public static void main(String[] args) {
        IntegerArray num1 = new IntegerArray("5");
        IntegerArray num2 = new IntegerArray("10");
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num1.subtract(num2));
    }
    */
}
