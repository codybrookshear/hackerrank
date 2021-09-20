public class Euler6 {
    public static void main(String[] args) {
        System.out.println("answer: " + findSolution());
    }

    public static int findSolution() {
        return squareOfSums(100) - sumOfSquares(100); 
    }

    private static int squareOfSums(int max) {
        
        int sum = 0;

        for (int i = 1; i <= max; i++) {
            sum += i;
        }

        return sum * sum;
    } 

    private static int sumOfSquares(int max) {
        
        int sum = 0;
        
        for (int i = 1; i <= max; i++) {

            sum = sum + (i * i);
        }

        return sum;
    }
}
