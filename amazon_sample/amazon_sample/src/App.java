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
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
    
        // map a given int to a count
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i : ar) {

            Integer sockCount = map.get(i);
            if (sockCount == null) {
                sockCount = 0;
            }
            
            // set the new sock count
            map.put(i, sockCount+1);
        }

        // now count matches
        int pairs, totalPairs = 0;
        for (Integer i : map.values()) {
            pairs = i/2;
            totalPairs += pairs;
        }

        return totalPairs;
    }

}