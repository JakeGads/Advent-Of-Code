import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class First {
    public static void main(String[] args) throws IOException{
        int count = 0, index = 0;
        Scanner reader = new Scanner(new File("input"));
        
        while(reader.hasNextLine()){
            String line = reader.nextLine();

            if(line.charAt(index % line.length()) == '#'){
                count += 1;
            }

            index += 3;
        }

        System.out.println(count);
    }    
}
