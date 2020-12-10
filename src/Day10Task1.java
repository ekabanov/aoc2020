import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;

public class Day10Task1 {
    public static final long MAGIC = 373803594;

    public static void main(String[] args) throws Exception {
        long[] adapters = Arrays.stream(
            Files.readString(Path.of("Day9-input.txt")).split("\\n"))
            .mapToLong(Long::valueOf).toArray();                        
        
        Arrays.sort(adapters);

        int one_diff = 0;
        int three_diff = 1;
        for (int i = 0; i<adapters.length; i++) {
            if (adapters[i]-adapters[i+1] == 1) one_diff++; else three_diff++;
        }
        System.out.println(one_diff*three_diff);
    }

}