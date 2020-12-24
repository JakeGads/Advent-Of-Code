import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


public class part1 {
    static int size = 25;
    
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));
        
        int[] preamble = new int[size];

        for(int i = 0; i < size; i++){
            preamble[i] = Integer.parseInt(reader.nextLine());
        }
        
        boolean exists;

        do{
            exists = false;
            int inter = Integer.parseInt(reader.nextLine());
            for(int i: preamble){
                for(int j: preamble){
                    if(i + j == inter){
                        exists = true;
                    }
                }
            }

            if(!exists){
                System.out.println(inter);
                break;
            }else{
                preamble = calc_preamble(preamble, inter);
            }
              
        }while(reader.hasNext());

        
    }

    private static int[] calc_preamble(int[] preamble, int addition) {
        int[] array = new int[size];
        for(int i = 1; i < preamble.length; i++){
            array[i - 1] = preamble[i];
        }
        array[size - 1] = addition;
        
        return array;
    }
}