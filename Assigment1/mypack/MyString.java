package mypack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @filename - MyString.java
 * @description - A custom string class with various string manipulation methods.
 * @author - Aman Jeet Singh
 */
public class MyString {
    private String str;

    public MyString(String input) {
        str = input;
    }

    @Override
    public String toString() {
        return this.str;
    }

    // Append
    public String append(String newStr) {
        this.str += newStr;
        return this.str;
    }

    // Count words
    public int countWords() {
        int words = 0;
        boolean inWord = false;
        for (char ch : str.toCharArray()) {
            if (ch != ' ' && ch != '\t') {
                if (!inWord) {
                    words++;
                    inWord = true;
                }
            } else inWord = false;
        }
        return words;
    }

    // Replace substring (your custom logic retained but fixed)
    public String replace(String a, String b) {
        StringBuilder s = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (i + a.length() <= str.length() && str.substring(i, i + a.length()).equals(a)) {
                s.append(b);
                i += a.length();
            } else {
                s.append(str.charAt(i));
                i++;
            }
        }
        str = s.toString();
        return str;
    }

    // Check palindrome
    public boolean isPalindrome() {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    // Splice
    public String splice(int start, int end) {
        if (start >= 0 && end <= str.length() && start < end) {
            return str.substring(start, end);
        } else {
            System.out.println("Invalid range!");
            return "";
        }
    }

    // Split
    public ArrayList<String> split(char element) {
    ArrayList<String> parts = new ArrayList<>();
    StringBuilder cur = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (ch == element) {
            // jab split character mile to cur string add kar do
            parts.add(cur.toString());
            cur.setLength(0); // reset builder
        } else {
            cur.append(ch);
        }
    }

    // last part add karna mat bhool
    parts.add(cur.toString());

    return parts;
}

    // Max repeating character
    public char maxRepeatingCharacter() {
        int[] freq = new int[256];
        for (char ch : str.toCharArray()) freq[ch]++;
        int max = 0;
        char maxCh = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxCh = (char) i;
            }
        }
        return maxCh;
    }

    // Sort (converted to use char array)
    public String sort() {
        char[] arr = str.toCharArray();
        quickSort(arr, 0, arr.length - 1);
        str = new String(arr);
        System.out.println("Sorted string: " + str);
        return str;
    }

    private void quickSort(char[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(char[] arr, int low, int high) {
        char pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        char temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Shift string characters by n
    public String shift(int n) {
        if (str.length() <= 1) return str;
        n = n % str.length();
        if (n <= 0) return str;

        str = str.substring(n) + str.substring(0, n);
        return str;
    }

    // Reverse string
    public String reverse() {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        str = sb.toString();
        return str;
    }

    // Get string
    public String getString() {
        return this.str;
    }
}
