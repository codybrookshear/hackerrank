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
     * Complete the 'getServedBuildings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY buildingCount
     *  2. INTEGER_ARRAY routerLocation
     *  3. INTEGER_ARRAY routerRange
     */

    public static int getServedBuildings(List<Integer> buildingCount, List<Integer> routerLocation, List<Integer> routerRange) {
    // Write your code here
        
        // initialize a list to keep track of how many routers counts there are per building
        List<Integer> routerCountsPerBuilding = new ArrayList<Integer>();
        for (Integer i : buildingCount) {
            routerCountsPerBuilding.add(0);
        }
    
        for (int routerIndex = 0; routerIndex < routerLocation.size(); routerIndex++) {
            // for each router in the lists, get location and range
            
            // -1 for location so the make the values 0-based instead of 1-based
            int location = routerLocation.get(routerIndex) -1;
            int range = routerRange.get(routerIndex);
            
            // assume all buildings are covered, and then adjust range if smaller
            int firstBuildingCovered = 0;
            int lastBuildingCovered = buildingCount.size() - 1;
            
            if ((location - range) > 0) {
                firstBuildingCovered = location - range;
            }
            
            if ((location + range) < buildingCount.size() - 1) {
                lastBuildingCovered = location + range;
            } 
            
            //System.out.println("router " + routerIndex + " location: " + location + 
            //    " range: " + range + " 1st building: " + firstBuildingCovered + " last: " + lastBuildingCovered);
            
            for (int building = 0; building < buildingCount.size(); building++) {
                // for each building update the capacity served by each router.
                if ((building >= firstBuildingCovered) && (building <= lastBuildingCovered)) {
                    int currentRouterCount = routerCountsPerBuilding.get(building);
                    routerCountsPerBuilding.set(building, currentRouterCount + 1);
                }
            }
            
        }
        
        // we've finised counting router coverage, now to just check against tennant counts.
        int buildingsServed = 0;
        
        for (int building = 0; building < buildingCount.size(); building++) {
            if (routerCountsPerBuilding.get(building) >= buildingCount.get(building) ) {
                buildingsServed++;
            }
        }
    
        return buildingsServed;
    }

}
public class Solution {