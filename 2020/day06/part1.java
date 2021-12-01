import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


public class part1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));
        int sum = 0;
        
        Set<Character> q = new HashSet<Character>();

        do{
            String line = reader.nextLine();

            if(line.equals("")){
                sum += q.size();
                q = new HashSet<>();
                continue;
            }

            for(char i : line.toCharArray()){
                q.add(i);
            }
        }while(reader.hasNext());

        System.out.println(sum);
    }
}
