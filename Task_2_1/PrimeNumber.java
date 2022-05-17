public class PrimeNumber {
    
    public boolean isAllPrime(int[] numbers) {
        boolean isPrimeFlag = true;

        for (int num: numbers) {
            if (!isPrimeNumber(num)) {
                isPrimeFlag = false;
                break;
            }
        }

        return isPrimeFlag;
    }

    public boolean isPrimeNumber(int number) {
        double numSqrt = Math.sqrt(number);
        int numBound = (int) Math.round(numSqrt);

        boolean isPrimeFlag = true;

        if (number % 2 == 0) {
            if (number != 2)
                isPrimeFlag = false;
        }
        else {
            for (int i = 3; i <= numBound; i += 2) {
                if (number % i == 0) {
                    isPrimeFlag = false;
                    break;
                }
            }
        }

        return isPrimeFlag;
    }
}