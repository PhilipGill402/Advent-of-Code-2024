import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Chal2 {

    public static void printArr(String[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static String[] remove(String[] arr, int index){
        String[] newArr = new String[arr.length-1];
        int count = 0;

        for (int i = 0; i < arr.length; i++){
            if (i != index){
                newArr[count] = arr[i];
                count++;
            } 
        }
        
        return newArr;
    }

    public static Boolean isIncreasing(String[] line){
        Boolean hasAlreadyUsedSkip = false; 
        for (int i = 1; i < line.length; i++){
            Boolean isWithinRange = Integer.parseInt(line[i]) <= Integer.parseInt(line[i-1]) + 3 && Integer.parseInt(line[i]) >= Integer.parseInt(line[i-1]) + 1;
            if (!isWithinRange && hasAlreadyUsedSkip){ 
                return false;
            }
            else if (!isWithinRange && !hasAlreadyUsedSkip){
                if (!isIncreaseingWithSkip(line, i)){
                    return false;
                }
            }
        }
        return true;
    } 
    
    public static Boolean isIncreaseingWithSkip(String[] line, int index){
        line = remove(line, index); 
        for (int i = 1; i < line.length; i++){
             Boolean isWithinRange = Integer.parseInt(line[i]) <= Integer.parseInt(line[i-1]) + 3 && Integer.parseInt(line[i]) >= Integer.parseInt(line[i-1]) + 1;
            if (!isWithinRange){
                return false;
            }
            
        }
        return true;
    }

    public static Boolean isDecreasing(String[] line){
        Boolean hasAlreadyUsedSkip = false; 
        for (int i = 1; i < line.length; i++){
            Boolean isWithinRange = Integer.parseInt(line[i]) <= Integer.parseInt(line[i-1]) - 1 && Integer.parseInt(line[i]) >= Integer.parseInt(line[i-1]) - 3; 
            if (!isWithinRange && hasAlreadyUsedSkip){
                return false;
            }
            else if (!isWithinRange && !hasAlreadyUsedSkip){
                if (!isDecreasingWithSkip(line, i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean isDecreasingWithSkip(String[] line, int index){
        line = remove(line, index); 
        for (int i = 1; i < line.length; i++){
            Boolean isWithinRange = Integer.parseInt(line[i]) <= Integer.parseInt(line[i-1]) - 1 && Integer.parseInt(line[i]) >= Integer.parseInt(line[i-1]) - 3; 
            if (!isWithinRange){
                return false;
            }
            
        }
        return true;
    }
    public static void main (String[] args){
        try{
            File input = new File("Day2Input.txt");
            Scanner Reader = new Scanner(input);

            int count = 0;
            while (Reader.hasNextLine()){
                String data = Reader.nextLine();
                String[] line = data.split(" ");

                if (isDecreasing(line) || isIncreasing(line)){
                    printArr(line);
                    System.out.println("true");
                    count++;
                }
                else{
                    printArr(line);
                    System.out.println("false");
                }
            
            }
            System.out.println(count);

            Reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }

    }
}
