import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Chal1 {
    public static void main (String[] args){
        try{
            File input = new File("Day3Input.txt");
            Scanner Reader = new Scanner(input);
            
            int total = 0;
            while (Reader.hasNextLine()){
                String data = Reader.nextLine();

                Pattern pattern = Pattern.compile("mul\\([0-9]{1,4},[0-9]{1,4}\\)");
                Matcher matcher = pattern.matcher(data);

                List<String> matches = new ArrayList<String>();

                while (matcher.find()){
                    matches.add(matcher.group());
                }
                
                for (int i = 0; i < matches.size(); i++){
                    Pattern numPattern = Pattern.compile("[0-9]{1,4}");
                    Matcher numMatcher = numPattern.matcher(matches.get(i));

                    List<String> numMatches = new ArrayList<String>();

                    while (numMatcher.find()){
                        numMatches.add(numMatcher.group());
                    }

                    total += Integer.parseInt(numMatches.get(0)) * Integer.parseInt(numMatches.get(1));
                }
            
            }
            System.out.println(total);
            Reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }

    }
}
