package utilities;

import java.util.Random;

public class StringUtilies {
	
	public static String randomString(int cant){
		int value;
		int cont = 0;
		String string = "";
		Random random = new Random();
		while(cont < cant){
			value = random.nextInt(90);
			if(value < 90 && value > 65){
			string +=  (char)value;
			cont ++;
			}
	  }
		return string;
	}
	

}
