public class Euler7 {
    
    public static void main(String[] args) {

        // first 6 primes: 2, 3, 5, 7, 11, and 13

        int prime = 10001;
        System.out.println("The " + prime + "th prime number is: " + getPrime(prime));

    }

    private static long getPrime(int primeIndex) {
        long nextPrime = 1 ;
        long res;

        for (int i = 0; i < primeIndex; i++) {
            res = getNextPrime(nextPrime);
            nextPrime = res;
        }

        return nextPrime;
    }

    private static long getNextPrime(long lastPrime) {
        
        long possiblePrime = lastPrime + 1;
        
        while(true) {
            if (isPrime(possiblePrime)) {
                return possiblePrime;
            }
            possiblePrime++;
        }
    }

    private static boolean isPrime(long val) {

        for (int i = 2; i < val; i++) {
            if (val % i == 0)
                return false;
        }
        return true;
    }
}
