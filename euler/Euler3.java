public class Euler3 {

    public static void main(String[] args) {

        long theNumber = 600851475143L; // 13195 ;
        System.out.println("largest prime factor for " + theNumber + " is " + 
            largestPrimeFactor(theNumber));

    }

    private static long largestPrimeFactor(long inNumber) {
        long largestPrimeFactor = 0;
        long theNumber = inNumber;
        long primeFactorsMultiplied = 1;

        // start at 2, as 0 and 1 are not eligible prime factors.
        for (long i = 2; i < inNumber; i++) {

            // if evenly divisible, it's a prime factor
            if (theNumber % i == 0) {

                theNumber /= i;
                largestPrimeFactor = i;
                primeFactorsMultiplied *= largestPrimeFactor;

                if (primeFactorsMultiplied == inNumber)
                   break;
            }
        }
        
        // whatever is left is the biggest prime factor
        return largestPrimeFactor;
    }
}
