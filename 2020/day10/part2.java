import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


public class part2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(new File("input"));
        ArrayList<Integer> voltages = new ArrayList<>();
        do{
            int line = Integer.parseInt(reader.nextLine());
            voltages.add(line);
        }while(reader.hasNext());
        reader.close();
        Collections.sort(voltages);
        
        int voltage = get_voltage(voltages);
        int[] arr = new int[voltages.size()];
        for(int i = 0; i < voltages.size(); i++){
            arr[i] = voltages.get(i);
        }
        var perms = permute(arr);
        var per_strings = new HashSet<String>();

        int correct = 0;
        System.out.print("HERE WE GO!!!");
        for(var iter: perms){
            if(!per_strings.contains(list_to_string(iter))){
                per_strings.add(list_to_string(iter));
                if(check(iter) && Collections.max(iter) <= voltage - 3){
                    correct += 1;
                    System.out.println(correct);
                }
            }
        }

        System.out.println(correct);
        
    }

    public static int get_voltage(ArrayList<Integer> voltages){
        int current_volt = 0;
        
        int[] current_difference = {0,0,0};
        for(int i: voltages){
            if(is_between(current_volt, i, current_volt + 3)){
                current_difference[i - current_volt - 1] += 1;
                current_volt = i;
            }
        }
        return current_volt + 3;
    }

    public static boolean is_between(int low, int term, int high){
        return low <= term && term <= high;
    }

    public static boolean check(List<Integer> arr){
        
        int starter = 0;
        for(int i = 0; i < arr.size(); i++){
            if(starter < arr.get(i) - 3){
                return false;
            }
            starter = arr.get(i);
        }
        return true;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }
     
    private static  void helper(int start, int[] nums, List<List<Integer>> result){
        if(start==nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            if(check(list)){
                result.add(list);
            }
            return;
        }
     
        for(int i=start; i<nums.length; i++){
            swap(nums, i, start);
            helper(start+1, nums, result);
            swap(nums, i, start);
        }
    }
     
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static String list_to_string(List<Integer> arr){
        String j = "";
        for(var i: arr){
            j += i + ",";
        }
        return j;
    }
    
}
