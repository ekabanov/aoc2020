import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8Task1 {
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
        var seen = new boolean[instructions.size()];
        int acc = 0;
        int  i = 0;
        while (i<instructions.size()) {
            if (seen[i]) break;
            seen[i]=true;
            System.out.println(i);
            if (instructions.get(i).equals("acc")) acc += offsets.get(i);
            if (instructions.get(i).equals("jmp")) {
                i += offsets.get(i); 
                continue;
            }
            
            i++;
            if (i<0) i = 0;
        }
        System.out.println(acc);
    }
}
