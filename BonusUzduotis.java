public class BonusUzduotis {
    public static String compress(String input) {
        if (input.isEmpty()) {
            return "";
        }
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(input.charAt(i - 1));
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1;
            }
        }
        compressed.append(input.charAt(input.length() - 1));

        return compressed.toString();
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
                count = count * 10 + Character.getNumericValue(input.charAt(i));
            } else {
                for (int j = 0; j < count; j++) {
                    decompressed.append(currentChar);
                }
                currentChar = input.charAt(i);
                count = 0;
            }
        }
        for (int j = 0; j < count; j++) {
            decompressed.append(currentChar);
        }

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