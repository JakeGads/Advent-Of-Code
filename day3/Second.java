import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) throws IOException{
        int[] right = {1,3,5,7,1}; 
        int[] down  = {1,1,1,1,2};

        Long mult = 1L;

        for(int i = 0; i < right.length; i++){
            Long count = 0L;
            int index = 0;
            Scanner reader = new Scanner(new File("input"));
            
            while(reader.hasNextLine()){
                String line = reader.nextLine();

                if(line.charAt(index % line.length()) == '#'){
                    count += 1;
                }

                for(int j = 0; j < down[i] - 1; j++){
                    try{
                        reader.nextLine();
                    }
                    catch (Exception e){
                        break;
                    }
                }

                index += right[i];
            }
            System.out.println(count);
            if(count == 0){
                count = 1L;
            }
            mult *= count;
        }
        System.out.println(mult);
    }    
}
