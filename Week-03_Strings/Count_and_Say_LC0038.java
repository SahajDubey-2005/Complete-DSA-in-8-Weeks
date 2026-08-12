public class Count_and_Say_LC0038 {

    public static String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String current = "1";

        // Iterative RLE generation from term 2 to n
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = 0; j < current.length(); j++) {
                // Check if next character matches current
                if (j + 1 < current.length() && current.charAt(j) == current.charAt(j + 1)) {
                    count++;
                } else {
                    // Append frequency followed by the character value
                    sb.append(count).append(current.charAt(j));
                    count = 1; // Reset frequency counter
                }
            }

            current = sb.toString();
        }

        return current;
    }

    public static void main(String[] args) {
        // Test Case 1
        int n1 = 1;
        System.out.println("Output 1: " + countAndSay(n1)); // Expected: "1"

        // Test Case 2
        int n2 = 4;
        System.out.println("Output 2: " + countAndSay(n2)); // Expected: "1211"

        // Test Case 3
        int n3 = 5;
        System.out.println("Output 3: " + countAndSay(n3)); // Expected: "111221"
    }
}