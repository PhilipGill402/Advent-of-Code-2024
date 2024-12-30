import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Chal1 {

    public static List<String> findMatches (String data, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        List<String> matches = new ArrayList<String>();

        while (matcher.find()){
            matches.add(matcher.group());
        }

        return matches;
    }
    public static void main (String[] args){
        try{
            File input = new File("Day3Input.txt");
            Scanner Reader = new Scanner(input);
            
            int total = 0;
            long startTime = System.currentTimeMillis();
            while (Reader.hasNextLine()){
                String data = Reader.nextLine();
                String regex = "mul\\([0-9]{1,4},[0-9]{1,4}\\)";
                
                List<String> matches = findMatches(data, regex);

                for (int i = 0; i < matches.size(); i++){
                    String numData = matches.get(i);
                    String numRegex = "[0-9]{1,4}";

                    List<String> numMatches = findMatches(numData, numRegex);

                    total += Integer.parseInt(numMatches.get(0)) * Integer.parseInt(numMatches.get(1));
                }
            
            }
            System.out.println(total);
            long endTime = System.currentTimeMillis();
            System.out.println("That took " + (endTime - startTime) + " milliseconds");
            Reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }

    }
}
