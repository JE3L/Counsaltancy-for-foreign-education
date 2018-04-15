import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class User {
	String username, password; 
	
	public boolean make_profile(String username, String password){
		this.username = username;
		this.password = password;
		return true;
	}
	
	public static boolean checkEmailValidity(String email){
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(email);
		if(matcher.find()) return true;
		else return false;
	}
	
}
