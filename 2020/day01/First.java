package dayonel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class First {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("1-1.txt"));
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer[]> hits = new ArrayList<>();

        while(reader.hasNext()){
            arr.add(Integer.parseInt(reader.nextLine()));
        }
        
        for(int i = 0; i < arr.size(); i++){
            for(int j = 0; j < arr.size(); j++){
                if(arr.get(i) + arr.get(j) == 2020){
                    hits.add(
                        new Integer[] {arr.get(i), arr.get(j)}
                    );
                    
                }
            }
        }

        for(Integer[] i : hits){
            System.out.println("" + i[0] + "\t" + i[1] + "\t\t" + (i[0] * i[1]));
        }

    }

}

