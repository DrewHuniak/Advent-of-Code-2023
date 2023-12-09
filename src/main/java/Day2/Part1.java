package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {
    public int findSum(String filename) {
        int sum = 0;
        int currentGame = 1;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null)
            {
                if(validateGame(line))
                {
                    sum += currentGame;
                }
                currentGame++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }

    private boolean validateGame(String line)
    {
        String[] games = line.split(":");
        String[] rolls = games[1].split(";");
        boolean validGame = true;
        for(String roll : rolls)
        {
            validGame = validGame && validateRoll(roll);
        }
        return validGame;
    }

    private boolean validateRoll(String line)
    {
        String[] cubes = line.split(",");
        for(String cube : cubes)
        {
            String[] items = cube.split(" ");
            int currentNum = 0;
            for(int i = 1; i < items.length; i++)
            {
                if(i % 2 != 0)
                {
                    currentNum = Integer.parseInt(items[i]);
                }
                else
                {
                    if(!isValidNumber(items[i].charAt(0), currentNum))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidNumber(char color, int currentNum)
    {
        switch(color)
        {
            case 'b' -> {
                if (currentNum > 14) return false;
            }
            case 'r' -> {
                if (currentNum > 12) return false;
            }
            case 'g' -> {
                if (currentNum > 13) return false;
            }
        }
        return true;
    }
}

