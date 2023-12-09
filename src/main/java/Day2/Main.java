package Day2;

public class Main {

    public static void main(String[] args)
    {
        String filename = "C:\\Users\\Falakalakas\\EclipseProjects\\Advent\\src\\main\\java\\Day2\\input.txt";
        int sum = new Part1().findSum(filename);
        System.out.println(sum);
        sum = new Part2().findSum(filename);
        System.out.println(sum);
    }

}
