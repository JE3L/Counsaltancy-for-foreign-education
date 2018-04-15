import java.io.*;

public class Professor extends User{
	String name, email, subject, contactNumber;
	
	public Professor(String name, String email, String subject, String number){
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.contactNumber = number;
	}
	
	public void giveWebinar(String date,float f) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("webinar",true));
		bw.write(this.name+" is giving lecture on "+date+" about "+f+" minute long on "+this.subject+"\n");
		bw.close();
	}
}
