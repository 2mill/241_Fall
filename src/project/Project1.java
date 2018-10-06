package project;
import collection.MySet;
public class Project1 {
	public static void test() {
		MySet fibonacciSequence = new MySet();
		MySet primeNumSet = new MySet();
		int previous = 0;
		int current = 1;
		for (int i = 0; i < 30;  i++) {
			if (i == 0 || i == 1) fibonacciSequence.add(i);
			else {
				fibonacciSequence.add(previous + current);
				int temp = current;
				current = previous + current;
				previous = temp;	
			}
		}
		System.out.println(fibonacciSequence);
		int primes = 0;
		for (int i = 2; primes < 32; i++) {
			if (isPrime(i)) {
				primeNumSet.add(i);	
				primes++;
			}
		}
		System.out.println(primeNumSet);
        System.out.println(fibonacciSequence.intersection(primeNumSet));
		System.out.println(primeNumSet.symmetricDifference(fibonacciSequence));
		System.out.println(fibonacciSequence.union(primeNumSet));


	}
	public static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return false;	
		}	
		return true;
	}


}
