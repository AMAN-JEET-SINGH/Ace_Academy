import java.util.Scanner;
import mypackage.Operations;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Operations ops = new Operations();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1 - Count unique palindromic substrings");
            System.out.println("2 - Nth Fibonacci number");
            System.out.println("3 - Convert snake_case to camelCase");
            System.out.println("4 - Count consonants in a string");
            System.out.println("5 - Binary to Decimal conversion");
            System.out.println("6 - Expand characters based on digits");
            System.out.println("7 - Character frequency in a string");
            System.out.println("8 - Check if a number is prime");
            System.out.println("9 - Convert number to words");
            System.out.println("10 - Length of longest substring without repeating characters");
            System.out.println("0 - Exit");

            System.out.print("Enter your choice: ");
            int userInput = input.nextInt();
            input.nextLine(); // consume newline

            switch (userInput) {
                case 0:
                    System.out.println("Exiting program...");
                    input.close();
                    return;

                case 1:
                    System.out.print("Enter a string: ");
                    String str1 = input.nextLine();
                    int uniqueCount = ops.uniquePalindromesCounter(str1);
                    System.out.println("Unique palindromic substrings: " + uniqueCount);
                    break;

                case 2:
                    System.out.print("Enter N: ");
                    int n = input.nextInt();
                    int fib = ops.getnthFibonacci(n);
                    System.out.println("Nth Fibonacci number: " + fib);
                    break;

                case 3:
                    System.out.print("Enter snake_case string: ");
                    String snake = input.nextLine();
                    System.out.println("CamelCase: " + Operations.convertSnakeToCamel(snake));
                    break;

                case 4:
                    System.out.print("Enter a string: ");
                    String str2 = input.nextLine();
                    int consonants = Operations.countConsonants(str2);
                    System.out.println("Number of consonants: " + consonants);
                    break;

                case 5:
                    System.out.print("Enter binary string: ");
                    String binary = input.nextLine();
                    int decimal = Operations.binaryToDecimal(binary);
                    System.out.println("Decimal: " + decimal);
                    break;

                case 6:
                    System.out.print("Enter string with characters followed by numbers: ");
                    String expand = input.nextLine();
                    System.out.println("Expanded string: " + Operations.expandCharacters(expand));
                    break;

                case 7:
                    System.out.print("Enter a string: ");
                    String freqStr = input.nextLine();
                    System.out.println("Character frequency: " + Operations.getCharFrequency(freqStr));
                    break;

                case 8:
                    System.out.print("Enter a number: ");
                    int num = input.nextInt();
                    boolean prime = Operations.isPrime(num);
                    System.out.println(num + (prime ? " is PRIME" : " is NOT prime"));
                    break;

                case 9:
                    System.out.print("Enter a number: ");
                    int numWords = input.nextInt();
                    System.out.println("Number in words: " + Operations.numberToWords(numWords));
                    break;

                case 10:
                    System.out.print("Enter a string: ");
                    String str3 = input.nextLine();
                    int maxLength = Operations.lengthOfLongestSubstring(str3);
                    System.out.println("Length of longest substring without repeating characters: " + maxLength);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
