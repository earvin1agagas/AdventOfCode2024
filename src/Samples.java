package src;

import java.util.*;

public class Samples {
        /*
        New objective:
        - How often each number from the left list appears in the right list
        - "Similarity score" by adding up each number in the left list after multiplying it by the number of times that number appears in the right list
         */
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
            // Using a hashmap to keep a counter for each value in the left list
            // Key is left number, Value is how many times the left number appears in the right
            HashMap<Integer, Integer> map = new HashMap<>();

            for(String s : input.split("\n")) {
                String[] lines = s.split("\\s+");
                left.add(Integer.parseInt(lines[0]));
                right.add(Integer.parseInt(lines[1]));
            }
            right.sort((a, b) -> a - b);
            // The idea here is to create a hashmap using the right list, so when I go through the left list and the map
            // doesn't contain the key then it should be 0!
            for (Integer integer : right) {
                map.put(integer, map.getOrDefault(integer, 0) + 1);
            }
            int answer = 0;

            for (int i = 0; i < left.size(); i++) {
                if(map.containsKey(left.get(i))) {
                    answer += left.get(i) * map.get(left.get(i));
                }
            }
            System.out.println("ANSWER: " + answer);

        }
}
