package Lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lab1_5 {
    public static void main(String[] args) {
        int[] originalArray = generateRandomArray(20, -20, 20);

        System.out.println("Початковий масив: " + Arrays.toString(originalArray));

        int[][] resultArray = transformArray(originalArray);

        System.out.println("\nДвовимірний масив:");
        for (int[] row : resultArray) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static int[][] transformArray(int[] originalArray) {
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> fibonacciNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        List<Integer> primeNumbers = new ArrayList<>();

        for (int number : originalArray) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
            if (isFibonacci(number)) {
                fibonacciNumbers.add(number);
            }
            if (number < 0 && number > -17) {
                negativeNumbers.add(number);
            }
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }

        return new int[][]{
                evenNumbers.stream().mapToInt(Integer::intValue).toArray(),
                fibonacciNumbers.stream().mapToInt(Integer::intValue).toArray(),
                negativeNumbers.stream().mapToInt(Integer::intValue).toArray(),
                primeNumbers.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    public static boolean isFibonacci(int n) {
        if (n <= 0) {
            return false;
        }
        int a = 0, b = 1, c;
        while (b < n) {
            c = a + b;
            a = b;
            b = c;
        }
        return b == n;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
