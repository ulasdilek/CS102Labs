package lab05;

public class Q3 {

    public static void main(String[] args) {
        String A = "plane";
        String B = "plane";
        System.out.println(fredericksen(A, B));
    }

    static int fredericksen(String A, String B) {
        return helperFredericksen(A, B, 0);
    }

    static int helperFredericksen(String A, String B, int moves) {
        if (A.equals(B)) {
            return moves;
        }
        // reduce the problem into a smaller one
        if (!A.isEmpty() && !B.isEmpty() && A.charAt(0) == B.charAt(0)) {
            return helperFredericksen(A.substring(1), B.substring(1), moves);
        }
        
        // substitute a character
        int sub = Integer.MAX_VALUE;
        if (!A.isEmpty() && !B.isEmpty() && A.charAt(0) != B.charAt(0)) {
            sub = helperFredericksen(A.substring(1), B.substring(1), moves + 1);
        }
        
        // add a character
        int add = Integer.MAX_VALUE;
        if (A.length() < B.length()) {
            add = helperFredericksen(A, B.substring(1), moves + 1);
        }
        
        // remove a character
        int rem = Integer.MAX_VALUE;
        if (A.length() > B.length()) {
            rem = helperFredericksen(A.substring(1), B, moves + 1);
        }

        return Math.min(Math.min(sub, add), rem);
    }
    
}
