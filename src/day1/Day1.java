package src.day1;

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

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        String[] lines = input.split("\n");

        for(String line : lines) {
            // Using regex to split individual lines by spaces
            String[] parts = line.trim().split("\\s+");
            // Parsing parts and adding to respective lists
            left.add(Integer.parseInt(parts[0]));
            right.add(Integer.parseInt(parts[1]));
        }
        int left1 = 0;
        int right1 = 0;
        System.out.println("BEFORE SORT");
        System.out.println("LEFT: " + left);
        System.out.println("RIGHT: " + right);
        for(int i = 0; i < left.size(); i++) {
            left1 += left.get(i);
            right1 += right.get(i);
        }
        int result1 = Math.abs(left1 - right1);
        System.out.println("ANSWER: " + result1);

        // Sorting
        left.sort((a, b) -> a - b);
        right.sort((a, b) -> a - b);

        int left2 = 0;
        int right2 = 0;
        for(int i = 0; i < left.size(); i++) {
            left2 += left.get(i);
            right2 += right.get(i);
        }

        System.out.println("AFTER SORT");
        System.out.println("LEFT: " + left);
        System.out.println("RIGHT: " + right);
        int result2 = Math.abs(left2 - right2);
        System.out.println("ANSWER: " + result2);

    }
}
