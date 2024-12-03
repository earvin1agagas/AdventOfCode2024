import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public static void main(String[] args) {

        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                """;

        // TODO:
        // Sort through each list (least to greatest)
        // Subtract lowest value from each list
        // Save that number and continue doing the same down the newly sorted lists
        // Add all the saved numbers up
        // From the sample the answer should be 11
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        String[] lines = input.split("\n");

        for (String line : lines) {
            // Splitting the line by spaces
            String[] parts = line.trim().split("\\s+");
            // Parsing and adding numbers to the appropriate list
            left.add(Integer.parseInt(parts[0]));
            right.add(Integer.parseInt(parts[1]));
        }
        System.out.println("BEFORE SORT");
        System.out.println("LEFT: " + left);
        System.out.println("RIGHT: " + right);

        left.sort((a, b) -> a - b);
        right.sort((a, b) -> a - b);

        System.out.println("AFTER SORT");
        System.out.println("LEFT: " + left);
        System.out.println("RIGHT: " + right);

        int counter = 0;
        for(int i = 0; i < left.size(); i++) {
            int tmp = Math.abs(left.get(i) - right.get(i));
            counter += tmp;
        }

        System.out.println("ANSWER = " + counter);
    }
}