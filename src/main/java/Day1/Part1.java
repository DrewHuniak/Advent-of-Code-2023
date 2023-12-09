package Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part1 {

    private final String[] lettersToNums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int readFile(String filename)
    {

        int sum = 0;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null)
            {
                String savedDigits = "";
                char[] letters = line.toCharArray();
                int left = 0;
                int right = letters.length - 1;

                while(left < letters.length && !Character.isDigit(letters[left]))
                {
                    left++;
                }
                if(Character.isDigit(letters[left])) {

                    savedDigits += findFirstIndex(line) < left ? findFirstNumber(line) : String.valueOf(letters[left]);

                }
                while(right >= 0 && !Character.isDigit(letters[right]))
                {
                    right--;
                }
                if(Character.isDigit(letters[right]))
                {
                    savedDigits += findLastIndex(line) > right ? findLastNumber(line) : String.valueOf(letters[right]);
                }
                if(!savedDigits.equals(""))
                {
                    int concat = Integer.parseInt(savedDigits);
                    sum+=concat;
                }
            }

        }
        catch(Exception e)
        {
            System.out.println("Error reading File");
        }
        return sum;
    }

    public int findFirstIndex(String line)
    {
        int index;
        int smallestIndex = line.length();
        for (String lettersToNum : lettersToNums) {
            index = line.indexOf(lettersToNum);
            if (index != -1 && index < smallestIndex) {
                smallestIndex = index;
            }
        }
        return smallestIndex;
    }

    public int findLastIndex(String line)
    {
        int index;
        int largestIndex = 0;
        for (String lettersToNum : lettersToNums) {
            index = line.lastIndexOf(lettersToNum);
            {
                if (index != -1 && index > largestIndex) {
                    largestIndex = index;
                }
            }
        }
        return largestIndex;
    }

    public int findFirstNumber(String line)
    {
        int index;
        int smallestIndex = line.length();
        int savedNumIndex = -1;
        for(int i = 0; i < lettersToNums.length; i++)
        {
            index = line.indexOf(lettersToNums[i]);
            if(index != -1 && index < smallestIndex)
            {
                smallestIndex = index;
                savedNumIndex = i;
            }
        }
        return savedNumIndex;
    }

    public int findLastNumber(String line)
    {
        int index;
        int largestIndex = 0;
        int savedNumIndex = -1;
        for(int i = 0; i < lettersToNums.length; i++)
        {
            index = line.lastIndexOf(lettersToNums[i]);
            {
                if(index != -1 && index > largestIndex)
                {
                    largestIndex = index;
                    savedNumIndex = i;
                }
            }
        }
        return savedNumIndex;
    }

}
