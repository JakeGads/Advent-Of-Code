import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class part2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));
        ArrayList<Integer> seats = new ArrayList<>();
        while(reader.hasNextLine()){
            String iter = reader.nextLine();
            
            int run = 8 * get_val(iter.subSequence(0, 7).toString());
            run += get_val(iter.subSequence(7, iter.length()).toString());
            
            seats.add(run);
        }

        Collections.sort(seats);

        for(int i = 1; i < seats.size() - 1; i++){
            if(seats.get(i) + 1 == seats.get(i + 1)){
                continue;
            } else{
                System.out.println(seats.get(i) + 1);
            }

            if(seats.get(i) - 1 == seats.get(i - 1)){
                continue;
            } else{
                System.out.println(seats.get(i) - 1);
            }
        }
    }

    private static int get_val(String s) {
        
        int high = 127;
        int low = 0;
        
        char final_char = s.charAt(s.length() - 1);
        if(s.length() == 3){
            high = 7;
        }
        
        for(int i = 0; i < s.length() - 1; i++){
            char here = s.charAt(i);
            if(here == 'F' || here == 'L'){
                high -= ((high - low) / 2) + 1;
            } else {
                low += ((high - low) / 2) + 1;
            }   
        }
        
        if(final_char == 'F' || final_char == 'L'){
            return low;
        }
        return high;


    }
}
