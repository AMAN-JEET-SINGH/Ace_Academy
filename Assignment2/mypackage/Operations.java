package mypackage;

/**
 * @filename - Operations.java
 * @description - A custom java class that performs multiple string and number operations based on user choice (e.g- uniquePalindromesCounter, getnthFibonacci,)
 * @author - Aman Jeet Singh
 */

public class Operations {


    // Count the number of unique palindromic substrings present in a given string
    public int uniquePalindromesCounter(String str) {
        String[] uniquePalindromes = new String[str.length() * str.length()];
        int uniqueCount = 0;

        for (int center = 0; center < str.length(); center++) {
            uniqueCount = expandAndStore(str, center, center, uniquePalindromes, uniqueCount);

            uniqueCount = expandAndStore(str, center, center + 1, uniquePalindromes, uniqueCount);
        }

        return uniqueCount;
    }

    // Expand around center and add unique palindromes manually
    private int expandAndStore(String str, int left, int right, String[] uniqueList, int count) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {

            String current = "";
            for (int i = left; i <= right; i++) {
                current += str.charAt(i);
            }

            boolean alreadyExists = false;
            for (int i = 0; i < count; i++) {
                if (isSame(uniqueList[i], current)) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                uniqueList[count] = current;
                count++;
            }

            left--;
            right++;
        }
        return count;
    }

    // Compare two strings manually
    private boolean isSame(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    // Find the Nth number in the Fibonacci sequence
    public int getnthFibonacci(int n){
        if (n == 1) return 0;
        if (n == 2) return 1;
        int first = 0;
        int second = 1;
        int answer = -1;

        for(int i=2 ; i <= n ; i++ ){
            answer = first + second;
            first = second;
            second = answer;
        }
        
        return answer;
    }

    //snakeCase to cammelCase Converter
    public static String convertSnakeToCamel(String snakeCaseString) {
        String result = "";
        boolean toUpper = false;

        for (int i = 0; i < snakeCaseString.length(); i++) {
            char ch = snakeCaseString.charAt(i);

            if (ch == '_') {
                toUpper = true; 
            } else {
                if (toUpper) {
                    if (ch >= 'a' && ch <= 'z') {
                        ch = (char)(ch - 32);
                    }
                    toUpper = false;
                }
                result += ch;
            }
        }

        return result;
    }

    // Count the number of consonants in a given string
    public static int countConsonants(String str) {
        int consonantCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch - 'A' + 'a');
            }

            if (ch >= 'a' && ch <= 'z') {
                if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                    consonantCount++;
                }
            }
        }

        return consonantCount;
    }

    // Convert binary string to decimal number (without built-in methods)
    public static int binaryToDecimal(String binaryString) {
        int decimalValue = 0;
        int base = 1;

        for (int i = binaryString.length() - 1; i >= 0; i--) {
            char bit = binaryString.charAt(i);

            if (bit == '1') {
                decimalValue += base;
            }

            base *= 2;
        }

        return decimalValue;
    }


    // Expand characters based on the following digit
    public static String expandCharacters(String str) {
        String result = "";
        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                i++;
                int count = 0;
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    count = count * 10 + (str.charAt(i) - '0');
                    i++;
                }
                for (int j = 0; j < count; j++) {
                    result += ch;
                }
            } else {
                i++;
            }
        }
        return result;
    }



    // Count frequency of each character and return in compressed form
    public static String getCharFrequency(String str) {
        String result = "";
        int n = str.length();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int count = 1;

            boolean alreadyCounted = false;
            for (int k = 0; k < i; k++) {
                if (str.charAt(k) == ch) {
                    alreadyCounted = true;
                    break;
                }
            }
            if (alreadyCounted) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }

            result += ch;
            result += (char)(count + '0');
        }

        return result;
    }

    //prime number checker
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }


    private static final String[] units = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] teens = {
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", 
        "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    // Convert number to words
    public static String numberToWords(int num) {
        if (num < 0) {
            return "minus " + numberToWords(-num);
        }

        if (num < 10) {
            return units[num];
        } else if (num < 20) {
            return teens[num - 10];
        } else if (num < 100) {
            int tenPart = num / 10;
            int unitPart = num % 10;
            if (unitPart == 0) {
                return tens[tenPart];
            } else {
                return tens[tenPart] + " " + units[unitPart];
            }
        } else if (num < 1000) {
            int hundredPart = num / 100;
            int remainder = num % 100;
            if (remainder == 0) {
                return units[hundredPart] + " hundred";
            } else {
                return units[hundredPart] + " hundred " + numberToWords(remainder);
            }
        } else if (num < 10000) {
            int thousandPart = num / 1000;
            int remainder = num % 1000;
            if (remainder == 0) {
                return units[thousandPart] + " thousand";
            } else {
                return units[thousandPart] + " thousand " + numberToWords(remainder);
            }
        } else {
            return "Number too large";
        }
    }



    // Returns length of the longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }

        int start = 0;

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);

            if (lastIndex[currentChar] >= start) {
                start = lastIndex[currentChar] + 1;
            }

            lastIndex[currentChar] = end;

            int currentLength = end - start + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }



}
