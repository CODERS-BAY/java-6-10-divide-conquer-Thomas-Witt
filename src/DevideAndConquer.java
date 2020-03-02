import java.util.Random;
import java.util.Scanner;

public class DevideAndConquer {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        int length;
        int maxNumber;
        System.out.println("How long should your array be?");
        length = scanner.nextInt();
        System.out.println("What should be the highest possible number?");
        maxNumber = scanner.nextInt();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            Random rand = new Random();
            numbers[i] = rand.nextInt(maxNumber);
        }
        for (int i = 0; i < length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.print("The maximum is: " + findHighestNumber(numbers));

    }

    private static int findHighestNumber(int[] numbers) {

        if (numbers.length < 3) {
            if (numbers.length == 1) {
                return numbers[0];
            } else if (numbers[0] > numbers[1]) {
                return numbers[0];
            } else {
                return numbers[1];
            }
        } else {
            int[] numbersLeft = new int[numbers.length / 2];
            for (int i = 0; i < numbers.length / 2; i++) {
                numbersLeft[i] = numbers[i];
            }
            int[] numbersRight;
            if (numbers.length % 2 == 0) {
                numbersRight = new int[numbers.length / 2];
                for (int i = 0; i < (numbers.length / 2); i++) {
                    numbersRight[i] = numbers[numbers.length / 2 + i];
                }
            } else {
                numbersRight = new int[numbers.length / 2 + 1];
                for (int i = 0; i < numbers.length / 2 + 1; i++) {
                    numbersRight[i] = numbers[numbers.length / 2 + i];
                }
            }

            int maxNumbersLeft = findHighestNumber(numbersLeft);
            int maxNumbersRight = findHighestNumber(numbersRight);
            if (maxNumbersLeft > maxNumbersRight) {
                return maxNumbersLeft;
            } else {
                return maxNumbersRight;
            }

        }
    }
}
