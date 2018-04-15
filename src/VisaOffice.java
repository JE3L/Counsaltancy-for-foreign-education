import java.util.Random;

public class VisaOffice {
	
	String location;
	String appDate;
	
	public VisaOffice(String location){
		this.location = location;
	}
	
	public void recieveApplication(Student s){
        Random rand = new Random();
        int r = rand.nextInt(2);
        if(r==1) System.out.println("Visa accepted");
        else System.out.println("Visa rejected");
	}
	
}
