import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

public class Day10Task2 {
    public static final long MAGIC = 373803594;

    public static void main(String[] args) throws Exception {
        long[] a = Arrays.stream(Files.readString(Path.of("Day10-input.txt")).split("\\n")).mapToLong(Long::valueOf)
                .toArray();

        Arrays.sort(a);
        long[] adapters = new long[a.length + 2];
        System.arraycopy(a, 0, adapters, 1, a.length);
        adapters[0] = 0;
        adapters[adapters.length - 1] = adapters[adapters.length - 2] + 3;
        System.out.println(Arrays.toString(adapters));

        int lhs = 0;
        int rhs = 1;
        int[] options = new int[adapters.length];
        options[options.length-2] = 1;
        options[options.length-1] = 1;

        while (lhs < adapters.length-1) {
            if (adapters[rhs] - adapters[lhs] <= 3
            && rhs < adapters.length-1) {
                options[lhs]++;
                rhs++;
            } else {
                lhs++;
                rhs = lhs+1;
            }
        }
        
        System.out.println(Arrays.toString(options));
        long[] temp = new long[options.length];

        long[] result = new long[] {1,1,1};
        for (int i = options.length-1; i >=0; i--) {
            if (options[i] == 3){
                result[i % 3] = result[(i+1) % 3] + result[(i+2) % 3] + result[i % 3];
            } else if (options[i] == 2) {
                result[i % 3] = result[(i+1) % 3] + result[(i+2) % 3];
            } else result[i % 3] = result[(i+1) % 3];
            temp[i] = result[i%3];
        }
        System.out.println(Arrays.toString(temp));

        System.out.println(result[0]);
    }

}