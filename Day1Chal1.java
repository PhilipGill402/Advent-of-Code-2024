import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Day1Chal1 {
    public static void main(String[] args) {
        int[] left = new int[1000];
        int[] right = new int[1000];

        // opens the file and then adds each column of data to its respective list
        try {
            File input = new File("Day1Input.txt");
            Scanner Reader = new Scanner(input);

            int count = 0;
            while (Reader.hasNextLine()){
                String data = Reader.nextLine();
                String[] line = data.split(" ");
                left[count] = Integer.parseInt(line[0]);
                right[count] = Integer.parseInt(line[line.length-1]);
                count++;
            }

            Reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }

        // sort each list
        Arrays.sort(left);
        Arrays.sort(right);

        //compare each distance
        int distance = 0;

        for (int i = 0; i < left.length; i++){
            distance += Math.abs(left[i] - right[i]);
        }

        //print total distance
        System.out.println(distance);
    } 
}
