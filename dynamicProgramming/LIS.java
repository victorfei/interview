/* 
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence 
 * of a given sequence such that all elements of the subsequence are sorted in increasing order. 
 * For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6.
 *
 * Source: GeeksForGeeks | Dynamic Programming | Set 3 (Longest Increasing Subsequence)
 */
import java.util.*;

class LIS {

    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };

        // brute force
        System.out.println("lenght: " + lis(arr, 0));

        // brute force sequence
        ArrayList<Integer> result = lis_sequence(arr, 0);
        System.out.print("length: " + result.size() + " | ");
        System.out.print("sequence: ");
        for (Integer i : result) {
            System.out.print(i + ", ");
        }

        // dp result
        System.out.println();
        System.out.println("lengh_dp: " + lis_dp(arr));

    }

    /** Brute force LIS printing out only the length. */
    public static int lis(int[] arr, int beg) {

        if (beg >= arr.length)
            return 0;

        int max_len = 0;
        int curr_val = arr[beg];
        for (int i = beg + 1; i < arr.length; i++) {
            if (arr[i] > curr_val) {
                int prev_len = lis(arr, i);
                if (prev_len > max_len)
                    max_len = prev_len;
    
            }
        }

        return max_len + 1;
    }

    /** Brute force LIS printing out the sequence */
    public static ArrayList<Integer> lis_sequence(int[] arr, int beg) {
        if (beg >= arr.length)
            return new ArrayList<Integer>();

        ArrayList<Integer> max_list = new ArrayList<Integer>();

        int curr_val = arr[beg];
        for (int i = beg + 1; i < arr.length; i++) {
            if (arr[i] > curr_val) {
                ArrayList<Integer> prev_list = lis_sequence(arr, i);
                if (prev_list.size() > max_list.size())
                    max_list = prev_list;
    
            }
        }

        max_list.add(curr_val);

        return max_list;

    }

    /** Dynamic programming LIS */
    public static int lis_dp(int[] arr) {
        int[] partialResult = new int[arr.length];
        partialResult[arr.length-1] = 1;
        int max;

        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[i] && partialResult[i] < partialResult[j] + 1)
                    partialResult[i] = partialResult[j] + 1;
            }
        }
  
          return partialResult[0];
    }
}


