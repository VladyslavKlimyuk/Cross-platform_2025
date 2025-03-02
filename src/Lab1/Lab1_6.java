package Lab1;

import java.util.Arrays;
import java.util.Random;

public class Lab1_6 {
    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt(10) + 1;
        double[] numbers = new double[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextDouble() * 100;
        }

        System.out.println("Початковий масив: " + Arrays.toString(numbers));

        double[] sortedNumbers = sortByMaxCenter(numbers);
        System.out.println("Відсортований масив: " + Arrays.toString(sortedNumbers));
    }

    public static double[] sortByMaxCenter(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new double[0];
        }

        double max = numbers[0];
        int maxIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
        }

        double[] sortedNumbers = new double[numbers.length];
        int centerIndex = numbers.length / 2;
        sortedNumbers[centerIndex] = max;

        double[] temp = numbers.clone();
        temp[maxIndex] = Double.MIN_VALUE;

        int left = centerIndex - 1;
        int right = centerIndex + 1;

        while (left >= 0 || right < numbers.length) {
            double leftMax = Double.MIN_VALUE;
            int leftMaxIndex = -1;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] > leftMax) {
                    leftMax = temp[i];
                    leftMaxIndex = i;
                }
            }
            if (left >= 0 && leftMaxIndex != -1) {
                sortedNumbers[left] = leftMax;
                temp[leftMaxIndex] = Double.MIN_VALUE;
                left--;
            }

            double rightMax = Double.MIN_VALUE;
            int rightMaxIndex = -1;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] > rightMax) {
                    rightMax = temp[i];
                    rightMaxIndex = i;
                }
            }
            if (right < numbers.length && rightMaxIndex != -1) {
                sortedNumbers[right] = rightMax;
                temp[rightMaxIndex] = Double.MIN_VALUE;
                right++;
            }
        }
        return sortedNumbers;
    }
}
