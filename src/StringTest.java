import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

	public static void main(String[] args) {
		String str = "Hello, " + "World!";
		str = new StringBuilder().append("Hello, ").append("World!").toString();
		
		String testString = "Test String";
		String testString2 = new String("Test String");
		String testString3 = testString.concat("Test 112");
		
		System.out.println("Test" == new String("Test"));
		String test = "Test".intern();
		System.out.print("Test" == test);
		String converterString = "";
		try {
			converterString = new String("РёРѕРЅРёР".getBytes("Cp1251"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(converterString);
		
		String[] strings = "Test,fsdgsf,fgsgsf,gsgs, fgsd gsg,gsgsfg".split("[,\\s]");
		for (String s : strings){
			System.out.println(s);
		}	
		System.out.println("fsdf5454fd542v6gf46fs356653".replaceAll("\\D+", ""));
		System.out.println("-------------------");
		StringTokenizer sTokenizer = new StringTokenizer("Test,fsdgsf, f gsgsf,gsgs, fgsdgsg,gsgsfg", ", ");
		while(sTokenizer.hasMoreTokens()){
			String token = sTokenizer.nextToken("g");
			if (token.startsWith("f")){
				
			}
			if (token.endsWith("f")){
				
			}
			System.out.println(token);
		}
		
		System.out.println("++++++++++++++++++");
		Pattern pattern = Pattern.compile("(\\d+)");
		Matcher m = pattern.matcher("fsdf5454fd542v6gf46fs356653");
		if (m.find()){
			for (int i = 0; i < m.groupCount(); i++){
				System.out.println(m.group(i));
			}
		}
		
	}

}
