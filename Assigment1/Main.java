import java.util.Scanner;
import mypack.MyString;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner InputScanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = InputScanner.nextLine();

        MyString myStr = new MyString(input);

        int choice;
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Append");
            System.out.println("2. Count Words");
            System.out.println("3. Replace");
            System.out.println("4. isPalindrome");
            System.out.println("5. Splice");
            System.out.println("6. Split");
            System.out.println("7. MaxRepeatingCharacter");
            System.out.println("8. Sort");
            System.out.println("9. Shift");
            System.out.println("10. Reverse");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = InputScanner.nextInt();
            InputScanner.nextLine(); 
            String ans;
            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String appendStr = InputScanner.nextLine();
                    ans=myStr.append(appendStr);
                    System.out.println("After append: " + ans);
                    break;
                case 2:
                    int a=myStr.countWords();
                    System.out.println("Word count: " + a);
                    break;
                case 3:
                    System.out.print("Enter old String: ");
                    String oldC = InputScanner.next();
                    System.out.print("Enter new String: ");
                    String newC = InputScanner.next();
                    ans=myStr.replace(oldC, newC);
                    System.out.println("After replace: " + ans);
                    break;
                case 4:
                    boolean b=myStr.isPalindrome();
                    System.out.println("Is palindrome: " + b);
                    break;
                case 5:
                    System.out.print("Enter start index: ");
                    int start = InputScanner.nextInt();
                    System.out.print("Enter length to remove: ");
                    int length = InputScanner.nextInt();
                    InputScanner.nextLine(); // consume newline
                    ans = myStr.splice(start, length);
                    System.out.println("Removed part: " + ans);
                    System.out.println("Remaining string: " + myStr.getString());
                    break;
                case 6:
                    System.out.print("Enter character to split by: ");
                    String delimInput = InputScanner.nextLine();
                    char delim = delimInput.isEmpty() ? ' ' : delimInput.charAt(0);
                    String[] parts = myStr.split(delim);
                    System.out.println("Split parts:");
                    for (String part : parts) {
                        System.out.println(part);
                    }
                    break;
                case 7:
                    char maxChar = myStr.maxRepeatingCharacter();
                    System.out.println("Max repeating character: " + maxChar);
                    break;
                case 8:
                    ans=myStr.sort();
                    System.out.println("Sorted string: " + ans);
                    break;
                case 9:
                    System.out.print("Enter number of characters to shift: ");
                    int n = InputScanner.nextInt();
                    ans=myStr.shift(n);
                    System.out.println("After shift: " + ans);
                    break;
                case 10:
                    ans=myStr.reverse();
                    System.out.println("Reversed string: " + ans);
                    break;
                case 0:
                    System.out.println("Exit!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
