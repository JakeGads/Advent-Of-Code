import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


public class part2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));
        int sum = 0;
        int size = 0;
        HashMap<Character, Integer> q = new HashMap<>();

        for(char i: "abcdefghijklmnopqrstuvwxyz".toCharArray()){
            q.put(i, 0);
        }

        do{
            String line = reader.nextLine();

            if(line.equals("")){
                for(char i: q.keySet()){
                    if(q.get(i) == size){
                        sum += 1;
                    }
                    q.put(i, 0);
                }
                size = 0;
                continue;
            }

            for(char i : line.toCharArray()){
                try{
                    q.put(i, q.get(i) + 1);
                } catch(NullPointerException e){
                    q.put(i, 1);
                }
                
            }
            size += 1;
        }while(reader.hasNext());

        
        
        System.out.println(sum);
    }
}
