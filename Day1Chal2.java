import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Day1Chal2 {
    public static void main (String args[]){
        ArrayList<Integer> left = new ArrayList<Integer>(); 
        ArrayList<Integer> right = new ArrayList<Integer>();

        // opens the file and then adds each column of data to its respective list
        try {
            File input = new File("Day1Input.txt");
            Scanner Reader = new Scanner(input);

            while (Reader.hasNextLine()){
                String data = Reader.nextLine();
                String[] line = data.split(" ");
                left.add(Integer.parseInt(line[0]));
                right.add(Integer.parseInt(line[line.length-1]));
            }

            Reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }

        //calculate total similarity score
        int simScore = 0;

        for (int i = 0; i < left.size(); i++){
            Integer num = left.get(i); 
            int frequency = Collections.frequency(right, num);

            simScore += num * frequency;
        }

        //prints the similarity score
        System.out.println(simScore);

    }
} 

