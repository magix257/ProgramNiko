public class DanezPliku
{
 
	String filePath ="A\\WYRAZY\\input.metryka";
	ReadFileToString rfts = new ReadFileToString();
	
	public int dlugoscpliku() {
	String wyrazy = rfts.readLineByLineJava8( filePath );
	int dlugosc = wyrazy.length();
		return dlugosc;
}

public String wyrazy() {
	
	String wyrazy = rfts.readLineByLineJava8(filePath);
	int dlugosc = wyrazy.length();
	String wyrazy2 = wyrazy.substring(0, dlugosc-1);
	return wyrazy2;
}

}