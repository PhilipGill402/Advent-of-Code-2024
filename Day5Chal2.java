import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Day5Chal2 {
    public static void printArr(List<String> arr){
        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }

    public static void printArr(String[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static Boolean checkUpdate(String update, List<String> rules){
        String[] updateStringNums = update.split(",");
        int[] nums = new int[updateStringNums.length];
        for (int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(updateStringNums[i]);
        }
        
        for (int i = 0; i < rules.size(); i++){
            String rule = rules.get(i);
            String[] ruleNums = rule.split("\\|");
            int num1 = Integer.parseInt(ruleNums[0]);
            int num2 = Integer.parseInt(ruleNums[1]);
            Boolean seenNum2 = false;

            for (int j = 0; j < nums.length; j++){
                if (nums[j] == num2){
                    seenNum2 = true;
                }
                else if (nums[j] == num1 && seenNum2){
                    return false;
                }
            }
        }
        
        return true;
    }

    public static String reorderUpdate(String update, List<String> rules){
        String[] updateStringNums = update.split(",");
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < updateStringNums.length; i++){
            nums.add(Integer.parseInt(updateStringNums[i]));
        }

        for (int i = 0; i < rules.size(); i++){
            String rule = rules.get(i);
            String[] ruleNums = rule.split("\\|");
            int num1 = Integer.parseInt(ruleNums[0]);
            int num2 = Integer.parseInt(ruleNums[1]);
            Boolean seenNum2 = false;

            for (int j = 0; j < nums.size(); j++){
                if (nums.get(j) == num2){
                    seenNum2 = true;
                }
                else if (nums.get(j) == num1 && seenNum2){
                    int indexOfNum1 = nums.indexOf(num1);
                    int indexOfNum2 = nums.indexOf(num2);
                    if (indexOfNum2-1 == -1){
                        indexOfNum2 = 1;
                    } 
                    nums.add(indexOfNum2-1, num1);
                    nums.remove(indexOfNum1+1); 
                }
            }
        }
        String newUpdate = "";
        for (int i = 0; i < nums.size(); i++){
            newUpdate += nums.get(i);
            if (i < nums.size()-1){
                newUpdate += ",";
            }
        }

        return newUpdate;
    }

    public static int findMidValue(String update){
        String[] updateStringNums = update.split(",");
        int[] nums = new int[updateStringNums.length];
        for (int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(updateStringNums[i]);
        }
        
        int midpoint = nums[nums.length/2];
        
        return midpoint;
    }

    public static void main (String[] args){
        try{
            File input = new File("Day5Input.txt");
            Scanner Reader = new Scanner(input);
            
            int total = 0;
            long startTime = System.currentTimeMillis();
            List<String> lines = Files.readAllLines(Paths.get("/Users/philipgill/Developer/java/Advent-of-Code-2024/Day5Input.txt"));
            List<String> rules = new ArrayList<String>();
            List<String> updates = new ArrayList<String>(); 
            Boolean isRules = true;

            for (int i = 0; i < lines.size(); i++){
                //System.out.println(lines.get(i)); 
                if (lines.get(i).equals("")){
                    isRules = false;
                }
                else if(isRules){
                    rules.add(lines.get(i));
                }
                else{
                    updates.add(lines.get(i));
                }
            }
            
            for (int i = 0; i < updates.size(); i++){
                if (!checkUpdate(updates.get(i), rules)){ 
                    String newUpdate = updates.get(i);
                    while(!checkUpdate(newUpdate, rules)){
                        newUpdate = reorderUpdate(newUpdate, rules);
                    }
                    total += findMidValue(newUpdate);
                }
                
            }
            
            System.out.println(total);
            long endTime = System.currentTimeMillis();
            System.out.println("That took " + (endTime - startTime) + " milliseconds");
            Reader.close();
        }
        catch (IOException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }

    }
}