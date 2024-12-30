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
        for (int i = 1; i < line.length; i++){
            Boolean isWithinRange = Integer.parseInt(line[i]) <= Integer.parseInt(line[i-1]) + 3 && Integer.parseInt(line[i]) >= Integer.parseInt(line[i-1]) + 1;
            
            if (!isWithinRange){
                return false;
            }
        }

        return true;
    } 
    
    public static Boolean isDecreasing(String[] line){
        for (int i = 1; i < line.length; i++){
            Boolean isWithinRange = Integer.parseInt(line[i]) <= Integer.parseInt(line[i-1]) - 1 && Integer.parseInt(line[i]) >= Integer.parseInt(line[i-1]) - 3; 
            
            if (!isWithinRange){
                return false;
            }
        }

        return true;
    }
    
    public static Boolean checkPermutations (String[] line){
        if (isIncreasing(line) || isDecreasing(line)){
            return true;
        } 
        
        for (int i = 0; i < line.length; i++){
            if (isIncreasing(remove(line, i)) || isDecreasing(remove(line, i))){
                return true;
            }
        }

        return false;
    }
    public static void main (String[] args){
        try{
            File input = new File("Day2Input.txt");
            Scanner Reader = new Scanner(input);

            int count = 0;
            long startTime = System.currentTimeMillis();
            while (Reader.hasNextLine()){
                String data = Reader.nextLine();
                String[] line = data.split(" ");

                if (checkPermutations(line)){
                    count++;
                } 
            
            }
            System.out.println(count);

            Reader.close();

            long endTime = System.currentTimeMillis();
            System.out.println("That took " + (endTime - startTime) + " milliseconds");

        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }

    }
}
