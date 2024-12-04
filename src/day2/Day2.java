package src.day2;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        day2sample();
    }

    public static int day2sample() {
        // This is a list of many reports
        // 1 report per line
        // Each report is a list of numbers called levels
        // The levels are separated by spaces
        String reports = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9
                """;
        // Need to determine which levels are safe vs unsafe
        // Safe
        // 1. Levels are all increasing or all decreasing
        // 2. Any 2 adjacent levels differ by at LEAST one and at MOST 3
        // ANSWER: For the sample reports string the answer is 2!


        // TODO
        // Parse reports into lines
        // Go through each line and determine if all increasing or all decreasing
        // If the above is true, do additional check for adjacent level differences

        List<int[]> levels = new ArrayList<>();
        // Splitting the reports into levels
        for(String report : reports.split("\n")) {
            // Processing each level
            String[] level = report.split("\\s+");
            // Temp array when converting each level into an int
            int[] tmp = new int[level.length];
            for(int i = 0; i < tmp.length; i++) {
                tmp[i] = Integer.parseInt(level[i]);
            }
            levels.add(tmp);
        }

        levels.forEach(level -> {
                    for(int i = 0; i < level.length - 1; i++) {
                        if(level[i] > level[i + 1]) {
                            System.out.println("Increasing");
                        }
                        else if(level[i] < level[i + 1]) {
                            System.out.println("Decreasing");
                        } else {
                            System.out.println("Unsafe");
                        }
                    }
                }
                );
        return 0;
    }
}
