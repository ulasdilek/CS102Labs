package lab05;

import java.util.ArrayList;

public class Q2 {

    public static void main(String[] args) {
        int[] gigabytes = {45, 10, 15, 20, 25, 100};
        int[] scores = {50, 85, 45, 100, 6, 100};
        int n = 150;
        ArrayList<Integer> downloads = download(gigabytes, scores, n);
        System.out.println(downloads);
    }

    public static ArrayList<Integer> download(int[] gigabytes, int[] scores, int limit) {
        ArrayList<Integer> result = helperDownload(gigabytes, scores, limit, scores.length);
        return result;
    }

    private static ArrayList<Integer> helperDownload(int[] gigabytes, int[] scores, int limit, int i) {

        // Base case. Creates an ArrayList to append the following scores
        if (limit <= 0 || i == 0) {
            return new ArrayList<>();
        }
        // If the current game is too big, the only option is to not donwload it
        if (limit < gigabytes[i - 1]) {
            return helperDownload(gigabytes, scores, limit, i - 1);
        }

        // Otherwise, there are two options:
        // 1 - We download the current game
        ArrayList<Integer> add = helperDownload(gigabytes, scores, limit - gigabytes[i-1], i - 1);
        add.add(scores[i - 1]);
        // 2 - We do not download the current game
        ArrayList<Integer> dont = helperDownload(gigabytes, scores, limit, i - 1);

        // Whichever choice gives us a better score, we return it
        if (sum(add) > sum(dont)) {
            return add;
        }
        else {
            return dont;
        }
    }

    // A helper method to add all the integers in an arraylist
    private static int sum(ArrayList<Integer> a) {
        int result = 0;
        for (Integer i : a) {
            result += i;
        }
        return result;
    }
    
}
