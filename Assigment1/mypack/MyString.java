package mypack;

import java.util.Scanner;

public class MyString {
    private char[] c;

    public MyString(String input) {
        c = input.toCharArray();
    }

    // Append
    public void append(String newStr) {
        char[] newC = new char[c.length + newStr.length()];
        for (int i = 0; i < c.length; i++) newC[i] = c[i];
        for (int i = 0; i < newStr.length(); i++) newC[c.length + i] = newStr.charAt(i);
        c = newC;
        System.out.println("After append: " + new String(c));
    }

    // Count words
    public void countWords() {
        int words = 0;
        boolean inWord = false;
        for (char ch : c) {
            if (ch != ' ' && ch != '\t') {
                if (!inWord) {
                    words++;
                    inWord = true;
                }
            } else inWord = false;
        }
        System.out.println("Word count: " + words);
    }

    // Replace character
    public void replace(char oldC, char newC) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] == oldC) c[i] = newC;
        }
        System.out.println("After replace: " + new String(c));
    }

    // Check palindrome
    public void isPalindrome() {
        boolean palin = true;
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            if (Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) {
                palin = false;
                break;
            }
        }
        System.out.println(palin ? "Palindrome!" : "Not a palindrome.");
    }

    // Splice
    public void splice(int start, int end) {
        if (start >= 0 && end <= c.length && start < end) {
            char[] sub = new char[end - start];
            for (int i = start; i < end; i++) sub[i - start] = c[i];
            System.out.println("Spliced string: " + new String(sub));
        } else System.out.println("Invalid range!");
    }

    // Split
    public void split(char element) {
    System.out.println("Split result by '" + element + "':");
    int start = 0;
    for (int i = 0; i <= c.length; i++) {
        if (i == c.length || c[i] == element) {
            for (int j = start; j < i; j++) System.out.print(c[j]);
            System.out.println();
            start = i + 1;
        }
    }
    }

    // Max repeating character
    public void maxRepeatingCharacter() {
        int[] freq = new int[256];
        for (char ch : c) freq[ch]++;
        int max = 0;
        char maxCh = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxCh = (char) i;
            }
        }
        System.out.println("Max repeating character: " + maxCh + " (" + max + " times)");
    }

    // Sort
    public void sort() {
    quickSort(0, c.length - 1);
    System.out.println("Sorted string: " + new String(c));
    }

    private void quickSort(int low, int high) {
    if (low < high) {
        int pi = partition(low, high);
        quickSort(low, pi - 1);
        quickSort(pi + 1, high);
    }
    }

    private int partition(int low, int high) {
    char pivot = c[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (c[j] <= pivot) {
            i++;
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }
    char temp = c[i + 1];
    c[i + 1] = c[high];
    c[high] = temp;
    return i + 1;
    }

    // Shift
    public void shift(int n) {
        if (c.length <= 1) return;

        n = n % c.length;
        if (n <= 0) return;

        char[] temp = new char[c.length];
        for (int i = n; i < c.length; i++) temp[i - n] = c[i];
        for (int i = 0; i < n; i++) temp[c.length - n + i] = c[i];
        c = temp;
        System.out.println("After shift: " + new String(c));
    }

    // Reverse
    public void reverse() {
        int j=c.length-1;
        for (int i=0;i<j;i++) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            j--;
        }
        System.out.println("Reversed string: " + new String(c));
    }

    // Get string
    public String getString() {
        return new String(c);
    }
}
