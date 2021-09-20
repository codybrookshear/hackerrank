public class Euler5 {
    
    public static void main(String[] args) {
        System.out.println("smallest number evenly divisible by all numbers 1 to 20: " +
            findSolution());
    }

    private static int findSolution() {

        for (int i = 1; ; i++) {
            if (dividesDownTo2(i, 20))
                return i;
        }
    }

    private static boolean dividesDownTo2(int val, int divider) {
        if (val % divider == 0) {

            if (divider == 2)
                return true;
            else
                // recurse until we get down to 2
                return dividesDownTo2(val, divider-1);
        } 
        else {
            return false;
        }
    }
}
