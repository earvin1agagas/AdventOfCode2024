package src.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
//        String input = """
//                3   4
//                4   3
//                2   5
//                1   3
//                3   9
//                3   3
//                """;

        BufferedReader reader;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        try {
            File file = new File("src/day1/input.txt");
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split("\n");
                for(String s : lines) {
                    // Using regex to split individual lines by spaces
                    String[] parts = line.trim().split("\\s+");
                    // Parsing parts and adding to respective lists
                    left.add(Integer.parseInt(parts[0]));
                    right.add(Integer.parseInt(parts[1]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sorting
        left.sort((a, b) -> a - b);
        right.sort((a, b) -> a - b);

        int answer = 0;
        for(int i = 0; i < left.size(); i++) {
            int tmp = Math.abs(left.get(i) - right.get(i));
            answer += tmp;
        }

        System.out.println("AFTER SORT");
        System.out.println("LEFT: " + left);
        System.out.println("RIGHT: " + right);

        System.out.println("ANSWER: " + answer);

    }
}
