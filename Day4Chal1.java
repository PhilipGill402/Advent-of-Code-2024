import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Day4Chal1 {
    public static void print2dArr(char[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static int wordFinder (char[][] crossword, String word){
        int total = 0;

        for (int i = 0; i < crossword.length; i++){
            for (int j = 0; j < crossword[i].length; j++){
                char letter = crossword[i][j];
                if (letter == 'X'){
                    for (int k = 1; k <= 8; k++){
                        String newWord = ""; 
                        if (k == 1 && i >= 3){
                            newWord = "" + crossword[i][j] + crossword[i-1][j] + crossword[i-2][j] + crossword[i-3][j]; 
                        }
                        else if (k == 2 && i >= 3 && j <= crossword.length - 4){
                            newWord = "" + crossword[i][j] + crossword[i-1][j+1] + crossword[i-2][j+2] + crossword[i-3][j+3];
                        }
                        else if (k == 3 && j <= crossword.length - 4){
                            newWord = "" + crossword[i][j] + crossword[i][j+1] + crossword[i][j+2] + crossword[i][j+3];
                        }
                        else if (k == 4 && i <= crossword[i].length - 4 && j <= crossword.length - 4){
                            newWord = "" + crossword[i][j] + crossword[i+1][j+1] + crossword[i+2][j+2] + crossword[i+3][j+3];
                        }
                        else if (k == 5 && i <= crossword[i].length - 4){
                            newWord = "" + crossword[i][j] + crossword[i+1][j] + crossword[i+2][j] + crossword[i+3][j];
                        }
                        else if (k == 6 && i <= crossword[i].length - 4 && j >= 3){
                            newWord = "" + crossword[i][j] + crossword[i+1][j-1] + crossword[i+2][j-2] + crossword[i+3][j-3];
                        }
                        else if (k == 7 && j >= 3){
                            newWord = "" + crossword[i][j] + crossword[i][j-1] + crossword[i][j-2] + crossword[i][j-3];
                        }
                        else if (k == 8 && i >= 3 && j >= 3){
                            newWord = "" + crossword[i][j] + crossword[i-1][j-1] + crossword[i-2][j-2] + crossword[i-3][j-3];
                        }

                        if (word.equals(newWord)){ 
                            total++;
                        }
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
            
            total = wordFinder(crossword, "XMAS");    
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
