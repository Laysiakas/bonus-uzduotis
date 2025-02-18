public class BonusUzduotis {
    public static String compress(String input) {
        // if input string is empty, return empty string.
        if (input.isEmpty()) {
            return "";
        }
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        // input.length() - 1 because we are comparing current character with the next one.
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
                // if we are at the end of the string, append the last character and count.
            } else {
                compressed.append(input.charAt(i - 1));
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1;
            
            }
        }
        compressed.append(input.charAt(input.length() - 1)); 

        return compressed.toString(); // return compressed string.
    }
    public static String decompress(String input) { 
        if (input.isEmpty()) {
            return "";
        }
        StringBuilder decompressed = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 0;

        for (int i = 1; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                count = count * 10 + Character.getNumericValue(input.charAt(i)); // get the number of repetitions.
            } else {
                for (int j = 0; j < count; j++) {
                    decompressed.append(currentChar);
                } // append the character count times.
                currentChar = input.charAt(i);
                count = 0;
            }
        }
        for (int j = 0; j < count; j++) {
            decompressed.append(currentChar);
        } // append the last character count times.

        return decompressed.toString();
    }
    public static void main(String[] args) {
        String input = "aaabbcdddd";
        String compressed = compress(input);
        System.out.println("Compressed: " + compressed);
        String decompressed = decompress(compressed);
        System.out.println("Decompressed: " + decompressed);
    }
}