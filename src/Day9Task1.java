import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Day9Task1 {
    public static final int PREAMBLE = 25;
    public static final long MAGIC = 373803594;

    public static void main(String[] args) throws Exception {
        long[] cypher = Arrays.stream(
            Files.readString(Path.of("Day9-input.txt")).split("\\n"))
            .mapToLong(Long:: valueOf).toArray();                        

        for (int i = PREAMBLE; i<cypher.length; i++) {
            if (!testCypher(i, cypher)) {
                System.out.println(cypher[i]);
                break;
            }
        }   
    }

    private static boolean testCypher(int n, long[] cypher) {        
        for (int i = n-PREAMBLE; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if (cypher[n] == cypher[i]+cypher[j]) return true;
            }
        }
        return false;
    }
}