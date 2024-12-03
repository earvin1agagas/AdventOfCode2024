package src.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day1part2 {
    /*
    New objective:
    - How often each number from the left list appears in the right list
    - "Similarity score" by adding up each number in the left list after multiplying it by the number of times that number appears in the right list
     */
    public static void main(String[] args) {

        BufferedReader reader;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        // Using a hashmap to keep a counter for each value in the left list
        // Key is left number, Value is how many times the left number appears in the right
        HashMap<Integer, Integer> map = new HashMap<>();

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
        right.sort((a, b) -> a - b);
        for(Integer i : right) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int answer = 0;
        for(int i = 0; i < left.size(); i++) {
            if(map.containsKey(left.get(i))) {
                answer += left.get(i) * map.get(left.get(i));
            }
        }
        System.out.println("ANSWER: " + answer);

    }
}
