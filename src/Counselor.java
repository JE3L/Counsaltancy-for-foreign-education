
public class Counselor {
	String email, name, contactNumber;
	
	public Counselor(String email, String name, String number){
		this.email = email;
		this.name = name;
		this.contactNumber = number;
	}
	
	public void giveAdvice(){
		//advice whatever counselor give
		System.out.println("Don't worry, You are doing just fine\n");
	}
	
	public boolean verifyDoc(Document d) {
		//counselor will manually verify document according to some parameters
		//this function will include GUI that's why we havent implemented this
		return true;
	}
}
