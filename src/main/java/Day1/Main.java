package Day1;

public class Main {
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        String filename = "C:\\Users\\Falakalakas\\EclipseProjects\\Advent\\src\\main\\java\\Day1\\input.txt";
        int sum = part1.readFile(filename);


        System.out.println(sum);
    }
}