import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


public class part1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));
        ArrayList<Integer> voltages = new ArrayList<>();
        do{
            int line = Integer.parseInt(reader.nextLine());
            voltages.add(line);
        }while(reader.hasNext());
        reader.close();
        Collections.sort(voltages);

        int current_volt = 0;
        
        int[] current_difference = {0,0,0};
        for(int i: voltages){
            System.out.println(current_volt + ":" + i + ":" + (current_volt+3));
            if(is_between(current_volt, i, current_volt + 3)){
                current_difference[i - current_volt - 1] += 1;
                current_volt = i;
            }
        }

        System.out.print(current_difference[0] * (current_difference[2] + 1));
    }

    public static boolean is_between(int low, int term, int high){
        return low <= term && term <= high;
    }
}
