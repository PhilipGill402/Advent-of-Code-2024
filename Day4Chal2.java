import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Day4Chal2 {
    public static void print2dArr(char[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static int xmasFinder(char[][] crossword){
        int total = 0;

        for (int i = 0; i < crossword.length; i++){
            for (int j = 0; j < crossword[i].length; j++){
                char letter = crossword[i][j];
                if (letter == 'A' && i >= 1 && i <= crossword[i].length - 2 && j >= 1 && j <= crossword.length - 2){
                    char topLeft = crossword[i-1][j-1];
                    char topRight = crossword[i-1][j+1];
                    char bottomLeft = crossword[i+1][j-1];
                    char bottomRight = crossword[i+1][j+1];

                    if (topLeft == 'M' && bottomLeft == 'M' && topRight == 'S' && bottomRight == 'S'){
                        total++;
                    }
                    else if (topLeft == 'M' && bottomLeft == 'S' && topRight == 'M' && bottomRight == 'S'){
                        total++;
                    }
                    else if (topLeft == 'S' && bottomLeft == 'S' && topRight == 'M' && bottomRight == 'M'){
                        total++;
                    }
                    else if (topLeft == 'S' && bottomLeft == 'M' && topRight == 'S' && bottomRight == 'M'){
                        total++;
                    } 
                }
            }
        } 
        return total;
    }
    public static void main (String[] args){
        try{
            File input = new File("Day4Input.txt");
            Scanner Reader = new Scanner(input);
            
            int total = 0;
            long startTime = System.currentTimeMillis();
            List<String> lines = Files.readAllLines(Paths.get("/Users/philipgill/Developer/java/Advent-of-Code-2024/Day4Input.txt"));
            
            int rows = lines.size();
            int cols = lines.get(0).length();
            
            char[][] crossword = new char[rows][cols];
            
            for (int i = 0; i < rows; i++) {
                crossword[i] = lines.get(i).toCharArray();
            }
            
            total = xmasFinder(crossword);
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
