import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
 
public class ReadFileToString
{
	
	String filePath ="A\\WYRAZY\\input.metryka";

public String[] readfiletostring() {
	
	String wyrazy = readLineByLineJava8( filePath );
	int dlugosc = wyrazy.length();
	String wyrazy2 = wyrazy.substring(0, dlugosc-1);
	String[] parts = wyrazy2.split("\n");
	
return parts;	
}

    //Read file content into string with - Files.lines(Path path, Charset cs)
 
    static String readLineByLineJava8(String filePath)
    {
    	
        StringBuilder contentBuilder = new StringBuilder();
 
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
 
        return contentBuilder.toString();
    }

}