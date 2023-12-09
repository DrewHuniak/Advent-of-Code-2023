package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Part2 {
    public int findSum(String filename)
    {
        int sum = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null)
            {
                sum += calculateGameMap(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }

    private int calculateGameMap(String line)
    {
        String[] games = line.split(":");
        String[] rolls = games[1].split(";");
        int largestRed = 1;
        int largestGreen = 1;
        int largestBlue = 1;
        for(String roll : rolls)
        {
            Map<Character, Integer> map = rollToMap(roll);
            largestBlue = Math.max(map.getOrDefault('b',1), largestBlue);
            largestRed = Math.max(map.getOrDefault('r',1), largestRed);
            largestGreen = Math.max(map.getOrDefault('g',1), largestGreen);
        }
        return largestRed * largestGreen * largestBlue;
    }

    private Map<Character, Integer> rollToMap(String line)
    {
        Map<Character, Integer> map = new HashMap<>();
        String[] cubes = line.split(",");
        for(String cube : cubes) {
            String[] items = cube.split(" ");
            int currentNum = 0;
            for (int i = 1; i < items.length; i++) {
                if (i % 2 != 0)
                {
                    currentNum = Integer.parseInt(items[i]);
                }
                else
                {
                    map.put(items[i].charAt(0), currentNum);
                }
            }
        }
        return map;
    }
}
