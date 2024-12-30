import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Chal1 {
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
    public static void main (String[] args){
        try{
            File input = new File("Day2Input.txt");
            Scanner Reader = new Scanner(input);

            int count = 0;
            while (Reader.hasNextLine()){
                String data = Reader.nextLine();
                String[] line = data.split(" ");

                if (isDecreasing(line) || isIncreasing(line)){
                    count++;
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
