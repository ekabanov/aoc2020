import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        var m = Pattern.compile("regex").matcher("input");
        m.find();
    }
}
