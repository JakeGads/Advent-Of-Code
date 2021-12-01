import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


public class part1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));

        int accumlator = 0;
        int index = 0;

        ArrayList<String> commands = new ArrayList<>();
        Set<Integer> runCommands = new HashSet<>();
        while(reader.hasNext()){
            commands.add(reader.nextLine());
        }

        reader.close();

        do{
            String line = commands.get(index);

            if(runCommands.contains(index)){
                break;
            }
            else{
                runCommands.add(index);
            }

            String command = line.split(" ")[0];
            int value = Integer.parseInt(line.split(" ")[1]);

            if(command.equals("acc")){
                accumlator += value;
                index += 1;
            }
            else if(command.equals("jmp")){
                index += value;
            }
            else if(command.equals("nop")){
                index += 1;
            }
        }while(true);

        System.out.println(accumlator);
    }
}
