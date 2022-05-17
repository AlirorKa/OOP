public class Main {
    public static void main(String[] args) throws Exception {
        int[] numbers = new int[10];
	for (int i = 0; i < numbers.lenght; i++){
		numbers[i] = 895087;
	}
	    
	// consistent
        PrimeNumber primeNumber = new PrimeNumber();
        long consistentStart = System.nanoTime();
        boolean consistent = primeNumber.isAllPrime(numbers);
	long consistentEnd = System.nanoTime();
        long consistentTime = consistentEnd - consistentStart;
        System.out.println("Consistent: " + consistent + " " + consistentTime);

	// threads
        PrimeNumberThreads threads = new PrimeNumberThreads();
        long threadStart = System.nanoTime();
        boolean t_Thread = threads.isPrime(numbers, 4);
        long threadEnd = System.nanoTime();
        long threadTime = threadEnd - threadStart;
        System.out.println("Threads: " + t_Thread + " " + threadTime)

	// parallel
        PrimeNumberStream stream = new PrimeNumberStream();
	long parallelStart= System.nanoTime();
        boolean parallelStream = stream.isPrime(numbers);
        long parallelEnd = System.nanoTime();
        long parallelTime = parallelEnd - parallelStart;
        System.out.println("Parallel: " + parallelStream + " " + parallelTime);
    }
}
