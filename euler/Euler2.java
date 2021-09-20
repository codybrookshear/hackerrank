public class Euler2 {
    
    public static void main(String[] args) {

        long res = sumFibonaciOnlyEvens(4000000);
        
        System.out.println("Sum of even fibonacci: " + res);
    }

    private static long sumFibonaciOnlyEvens(int max) {
        long sum = 0;
        long lastLast = 0;
        long last = 1;
        long current = 0;

        while (current < max) {

            current = lastLast + last;
            if (current % 2 == 0) { 
                sum = sum + current;
            }

            lastLast = last;
            last = current;
        }

        return sum;
    }
}
