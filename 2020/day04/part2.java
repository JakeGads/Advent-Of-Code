import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));
        HashMap<String, String> passport = new HashMap<>();
        int count = 0;
        while(reader.hasNextLine()){
            String base = reader.nextLine();
            Scanner line = new Scanner(base);
            
            if(base.equals("")){
                // test and clear the map
                boolean check = false;
                    
                if(passport.size() == 8){
                    check = true;
                    System.out.print("size 8");
                    check = check && check_byr(passport.get("byr"));
                    check = check && check_iyr(passport.get("iyr"));
                    check = check && check_eyr(passport.get("eyr"));
                    check = check && check_hgt(passport.get("hgt"));
                    check = check && check_hcl(passport.get("hcl"));
                    check = check && check_ecl(passport.get("ecl"));
                    check = check && check_pid(passport.get("pid"));
                    
                    if(check){
                        count += 1;
                        System.out.println(" pass");
                    }
                    else{
                        System.out.println(" fail");
                    }
                }

                else if (passport.size() == 7 && !passport.containsKey("cid")){
                    check = true;
                    System.out.print("size 7");
                    check = check && check_byr(passport.get("byr"));
                    check = check && check_iyr(passport.get("iyr"));
                    check = check && check_eyr(passport.get("eyr"));
                    check = check && check_hgt(passport.get("hgt"));
                    check = check && check_hcl(passport.get("hcl"));
                    check = check && check_ecl(passport.get("ecl"));
                    check = check && check_pid(passport.get("pid"));

                    if(check){
                        count += 1;
                        System.out.println(" pass");
                    }
                    else{
                        System.out.println(" fail");
                    }
                }

                else{
                    System.out.print(passport.size() + " failed");
                }
                passport = new HashMap<>();
     
            }
            

            while(line.hasNext()){
                String[] complete = line.next().split(":");
                if(!passport.containsKey(complete[0])){
                    passport.put(complete[0], complete[1]);
                }
                else {
                    System.out.println("key already exists");
                }
            }

            line.close();
        }

        System.out.println(count);
       
    }

    private static boolean check_pid(String string) {
        boolean check = true;
        // 7. pid (Passport ID) - a nine-digit number, including leading zeroes.
        for(int i = 0; i < string.length(); i++){
            if(!Character.isDigit(string.charAt(i))){
                check = false;
                
                break;
            }
        }
        return check && string.length() == 9;
    }

    private static boolean check_ecl(String string) {
        // 6. ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
        if(
            string.equals("amb") ||
            string.equals("blu") ||
            string.equals("brn") ||
            string.equals("gry") ||
            string.equals("grn") ||
            string.equals("hzl") ||
            string.equals("oth")
        ){
            return true;
        }
        return false;
    }

    private static boolean check_hcl(String string) {
        // 5. hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
        boolean check = true;
        if(!(string.charAt(0) == '#')){
            check = false;
        }

        for(int i = 1; i < string.length(); i++){
            char j = string.charAt(i);
            if(
                Character.isDigit(j) ||
                j == 'a' ||
                j == 'b' ||
                j == 'c' ||
                j == 'd' ||
                j == 'e' ||
                j == 'f'
            ){
                check = check && true;
            }
            else {
                check = check && false;
                
            }
        }

        return check && string.length() == 7;
    }

    private static boolean check_hgt(String string) {
        // 4. hgt (Height) - a number followed by either cm or in:
        //      If cm, the number must be at least 150 and at most 193.
        //      If in, the number must be at least 59 and at most 76.
        
        String id = string.substring(string.length() - 2);
       
        int size = 0;
        try{
            size = Integer.parseInt(string.substring(0, string.length() - 2));
        } catch(NumberFormatException e){
            return false;
        }
        

        if(id.equals("cm")){
            return 150 <= size && size <= 193;
        }
        else if (id.equals("in")){
            return 59 <= size && size <= 76;
        }
        return false;
    }

    private static boolean check_eyr(String string) {
        //3. eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
        int year = Integer.parseInt(string);
        return 2020 <= year && year <= 2030;
    }

    private static boolean check_iyr(String string) {
        // 2. iyr (Issue Year) - four digits; at least 2010 and at most 2020.
        int year = Integer.parseInt(string);
        return 2010 <= year && year <= 2020;
    }

    private static boolean check_byr(String string) {
        // 1. byr (Birth Year) - four digits; at least 1920 and at most 2002.
        int year = Integer.parseInt(string);
        return 1920 <= year && year <= 2002;
    }
}