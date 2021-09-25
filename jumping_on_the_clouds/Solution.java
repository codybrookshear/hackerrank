import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minMoves(List<Integer> arr) {

        if (arr.size() == 1)
            return 0;
                        
        int minZeroFirstSwaps = swapCount(arr, 0,1);
        int minOneFirstSwaps = swapCount(arr, 1,0);
                        
        if (minZeroFirstSwaps < minOneFirstSwaps)
            return minZeroFirstSwaps;
        else
            return minOneFirstSwaps;
    }

    private static int swapCount(List<Integer> arrIn, int a, int b) {
        int totalSwaps = 0;
        List<Integer> arr = new ArrayList<Integer>(arrIn);
        
        while (true) {
            // keep going until sorted
            
            int thisIterSwaps = 0;
            
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) == a && arr.get(i-1) == b) {
                    // swap desired
                    arr.set(i, b);
                    arr.set(i-1, a);        
                    thisIterSwaps++;
                }
            }
            
            if (thisIterSwaps == 0) {
                break;
            }
            
            totalSwaps += thisIterSwaps;
        }

        
        return totalSwaps;
    }

}

public class Solution {