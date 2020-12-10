import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Day9Task2 {
    public static final long MAGIC = 373803594;

    public static void main(String[] args) throws Exception {
        long[] cypher = Arrays.stream(
            Files.readString(Path.of("Day9-input.txt")).split("\\n"))
            .mapToLong(Long::valueOf).toArray();                        

        for (int i = 0; i<cypher.length; i++) {
            long sum = cypher[i];
            long min = cypher[i];
            long max = cypher[i];
            for (int j = i+1; j<cypher.length; j++) {                
                sum += cypher[j];
                min = Math.min(min, cypher[j]);
                max = Math.max(max, cypher[j]);
                if (sum == MAGIC) {
                    System.out.println(min+max);
                    return;
                }
            }
        }
    }

}