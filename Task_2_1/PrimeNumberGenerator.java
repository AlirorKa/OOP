import java.util.Random;

public class PrimeNumberGenerator {
    public static int[] Generate(int size, long seed) {
        if (size < 1)
            throw new ArrayIndexOutOfBoundsException("Array's size must be positive");

        int[] numbers = new int[size];

        Random r = new Random(seed);
        for (int i = 0; i < size; i++) {
            int index = Math.abs(r.nextInt() % firstPrimes.length);
            numbers[i] = firstPrimes[index];
        }

        return numbers;
    }
