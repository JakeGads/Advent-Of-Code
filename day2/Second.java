import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Second {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));
        int count = 0;
        while(reader.hasNext()){
            PassOne temp = parse(reader.nextLine());

            if(temp.check()){
                count += 1;
            }
        }

        System.out.println(count);
    }

    public static PassOne parse(String raw){
        Scanner text = new Scanner(raw);
        String high_low = text.next();
        int high = Integer.parseInt(high_low.split("-")[0]);
        int low = Integer.parseInt(high_low.split("-")[1]);
        char key = text.next().charAt(0);
        String pass = text.next();

        return new PassOne(high, low, key, pass);
    }
}


class PassOne {
    int low;
    int high;
    char given;
    String password;

    boolean valid;

    public PassOne(int low, int high, char given, String password){
        this.low = low - 1;
        this.high = high - 1;
        this.given = given;
        this.password = password;

        this.valid = eval();
    }

    private boolean eval(){
        return (this.password.charAt(low) == this.given && (this.password.charAt(high) != this.given)) ||
        (this.password.charAt(high) == this.given && (this.password.charAt(low) != this.given)); 
    }

    public boolean check(){
        return this.valid;
    }
}