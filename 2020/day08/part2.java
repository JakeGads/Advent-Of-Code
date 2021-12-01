import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


public class part2 {
    static ArrayList<String> commands;
    static int change_index = 0;

    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));

        commands = new ArrayList<>();
        

        while(reader.hasNext()){
            commands.add(reader.nextLine());
        }
        reader.close();

        int acc = 0;
        
        while(acc == 0){
            acc = trail();
            update_command();
        }

        System.out.println(acc);
    }

    private static void update_command() {
        boolean first = true;
        for(int i = change_index; i < commands.size(); i++){
            String command = commands.get(i).split(" ")[0];
            // changes it back
            if(i == change_index && first){
                if(command.equals("nop")){
                    commands.set(i, commands.get(i).replace("nop", "jmp"));
                }
                else{
                    commands.set(i, commands.get(i).replace("jmp", "nop"));
                }
                first = false;
                continue;
            }
            // changes next
            if(command.equals("nop")){
                commands.set(i, commands.get(i).replace("nop", "jmp"));
                System.out.println("@: " + i + "/" + commands.size());
                change_index = i;
                break;
            }
            else{
                commands.set(i, commands.get(i).replace("jmp", "nop"));
                System.out.println("@: " + i + "/" + commands.size());
                change_index = i;
                break;
            }
        }
    }

    public static int trail() {
        int accumlator = 0;
        int index = 0;
        Set<Integer> runCommands = new HashSet<>();

        do{
            String line;
            try{
                line = commands.get(index);
            } catch (Exception e){
                return accumlator;
            }

            if(runCommands.size() == commands.size()){
                return accumlator;
            }

            if(runCommands.contains(index)){
                return 0;
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
    }
}
