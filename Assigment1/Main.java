import java.util.Scanner;
import mypack.MyString;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

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
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String appendStr = sc.nextLine();
                    myStr.append(appendStr);
                    break;
                case 2:
                    myStr.countWords();
                    break;
                case 3:
                    System.out.print("Enter old character: ");
                    char oldC = sc.next().charAt(0);
                    System.out.print("Enter new character: ");
                    char newC = sc.next().charAt(0);
                    myStr.replace(oldC, newC);
                    break;
                case 4:
                    myStr.isPalindrome();
                    break;
                case 5:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter end index: ");
                    int end = sc.nextInt();
                    myStr.splice(start, end);
                    break;
                case 6:
                    System.out.print("Enter character to split by: ");
                    char delim = sc.next().charAt(0);
                    myStr.split(delim);
                    break;
                case 7:
                    myStr.maxRepeatingCharacter();
                    break;
                case 8:
                    myStr.sort();
                    break;
                case 9:
                    System.out.print("Enter number of characters to shift: ");
                    int n = sc.nextInt();
                    myStr.shift(n);
                    break;
                case 10:
                    myStr.reverse();
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
