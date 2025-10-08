package mypack;

/**
 * @filename - MyString.java
 * @description - A custom string class using String type (no built-in manipulation methods).
 * All operations are manually implemented using loops and concatenation.
 * Includes append, countWords, replace, isPalindrome, splice, split, maxRepeatingCharacter, sort, shift, reverse, and getString methods.
 * @author - Aman Jeet Singh
 */
public class MyString {
    private String value;

    public MyString(String input) {
        this.value = input;
    }

    @Override
    public String toString() {
        return this.value;
    }


    // Append
    public String append(String newStr) {
        this.value = this.value + newStr;
        return this.value;
    }


    // Count words
    public int countWords() {
        int count = 0;
        boolean inWord = false;
        for (int i = 0; i < this.value.length(); i++) {
            char ch = this.value.charAt(i);
            if (ch != ' ' && ch != '\t') {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }
        return count;
    }

    // Replace all occurrences of a -> b
    public String replace(String a, String b) {
        String newStr = "";
        int i = 0;
        while (i < this.value.length()) {
            boolean match = true;
            if (i + a.length() <= this.value.length()) {
                for (int j = 0; j < a.length(); j++) {
                    if (this.value.charAt(i + j) != a.charAt(j)) {
                        match = false;
                        break;
                    }
                }
            } else {
                match = false;
            }

            if (match) {
                for (int j = 0; j < b.length(); j++) newStr += b.charAt(j);
                i += a.length();
            } else {
                newStr += this.value.charAt(i);
                i++;
            }
        }
        this.value = newStr;
        return this.value;
    }

    // Check palindrome
    public boolean isPalindrome() {
        int i = 0, j = this.value.length() - 1;
        while (i < j) {
            if (this.value.charAt(i) != this.value.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    //Splice (remove substring of given length starting from start)
    public String splice(int start, int length) {
        if (start < 0 || start >= this.value.length() || length <= 0) {
            System.out.println("Invalid range!");
            return "";
        }

        if (start + length > this.value.length())
            length = this.value.length() - start;

        String removed = "";
        String newStr = "";

        for (int i = start; i < start + length; i++) {
            removed += this.value.charAt(i);
        }

        for (int i = 0; i < this.value.length(); i++) {
            if (i < start || i >= start + length) {
                newStr += this.value.charAt(i);
            }
        }

        this.value = newStr;
        return removed;
    }

    // Split by a character
    public String[] split(char element) {
        int parts = 1;
        for (int i = 0; i < this.value.length(); i++) {
            if (this.value.charAt(i) == element)
                parts++;
        }

        String[] result = new String[parts];
        for (int i = 0; i < parts; i++) 
            result[i] = "";

        int idx = 0;
        for (int i = 0; i < this.value.length(); i++) {
            if (this.value.charAt(i) == element)
                idx++;
            else 
                result[idx] += this.value.charAt(i);
        }
        return result;
    }

    // Max repeating character
    public char maxRepeatingCharacter() {
        int[] freq = new int[256];
        for (int i = 0; i < this.value.length(); i++) {
            freq[this.value.charAt(i)]++;
        }

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

    // Sort the string using Quick Sort
    public String sort() {
        char[] arr = this.value.toCharArray();
        quickSort(arr, 0, arr.length - 1);
        this.value = new String(arr);
        return this.value;
    }

    // Recursive quick sort
    private void quickSort(char[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition logic for quick sort
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



    // Shift by n characters
    public String shift(int n) {
        int len = this.value.length();
        if (len <= 1) return this.value;
        n = n % len;
        if (n <= 0) return this.value;

        String shifted = "";
        for (int i = n; i < len; i++) shifted += this.value.charAt(i);
        for (int i = 0; i < n; i++) shifted += this.value.charAt(i);

        this.value = shifted;
        return this.value;
    }

    // Reverse
    public String reverse() {
        String rev = "";
        for (int i = this.value.length() - 1; i >= 0; i--) {
            rev += this.value.charAt(i);
        }
        this.value = rev;
        return this.value;
    }

    // Get current string
    public String getString() {
        return this.value;
    }
}
