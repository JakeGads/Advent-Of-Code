import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


public class part2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));
    
        long weakness = 144381670l;
        // int weakness = 127;

        ArrayList<Long> array = new ArrayList<>();
        do{        
            array.add(Long.parseLong(reader.nextLine()));
        }while(reader.hasNext());
        reader.close();

        for(int i = 0; i < array.size(); i++){
            for(int size = 1; size < array.size(); size++){
                var sub_array = array.subList(i, i + size);
                long sum = 0;
                for(long part: sub_array){
                    sum += part;
                }
                
                if(sum == weakness){
                    System.out.println(
                        Collections.min(sub_array) + Collections.max(sub_array)
                    );
                } else if(sum > weakness){
                    break;
                }
            }
        }
    }
}