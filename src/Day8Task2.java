import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Day8Task2 {
    private static String string;

    public static void main(String[] args) throws Exception {
        var content = Files.readString(Path.of("Day8-input.txt"));
        var instructions = new ArrayList<String>();
        var offsets = new ArrayList<Integer>();        
        Pattern.compile("(nop|acc|jmp) (\\p{Punct}\\d+)")
            .matcher(content).results()
            .forEach(mr -> {
                instructions.add(mr.group(1));
                offsets.add(Integer.valueOf(mr.group(2)));            
            });
        System.out.println(instructions);
        System.out.println(offsets);
        for (int i = 0; i<instructions.size(); i++) {
            var r = tryFlip(i, instructions, offsets);
            if (r != -1) {
                System.out.println(r);
                break;
            }
        }
    }

    public static int tryFlip(int flip, List<String> instructions, List<Integer> offsets) {
        var seen = new boolean[instructions.size()];
        int acc = 0;
        int  i = 0;
        while (i<instructions.size()) {
            if (seen[i]) return -1;
            seen[i]=true;
            var instruction = instructions.get(i);
            if (i==flip) {
                if (instruction.equals("jmp")) instruction = "nop";
                else if (instruction.equals("nop")) instruction = "jmp";
            }
            
            if (instruction.equals("acc")) acc += offsets.get(i);
            if (instruction.equals("jmp")) {
                i += offsets.get(i); 
                continue;
            }
            
            i++;
            if (i<0) i = 0;
        }
        return acc;
    }

}