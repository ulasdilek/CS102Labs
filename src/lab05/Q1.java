package lab05;

public class Q1 {

    public static void main(String[] args) {
        int n = 75;
        int k = 25;
        int a = 7;
        System.out.println(eatApples(n, k, a));
    }

    static boolean eatApples(int n, int k, int a) {
        // day 0 is wrong in your implementation but whatever
        if (n < k || a < 0) {
            return false;
        }
        if (n == k) {
            return true;
        }
        // eat either 3 or 2 apples
        return eatApples(n - 3, k, a - 1) || eatApples(n - 2, k, a - 1);
    }
    
}
