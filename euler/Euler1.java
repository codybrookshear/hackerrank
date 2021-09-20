public class Euler1 {
    
     public static void main(String[] args) {

        int res = sumMultiplesOf3Or5(1000);
        
        System.out.println("Sum of multiples of 3 and 5: " + res);
    }

    private static int sumMultiplesOf3Or5(int max) {
        int sum = 0;
        for (int i = 0; i < max; i++) {
            if (i%3 == 0 || i%5 == 0) {
                sum += i;
            }
        }

        return sum;
    }

}
