
public class University extends User{
	
	String name, email, location, contactNumber;
	
	public University(String name, String email, String location, String number){
		super();
		this.name = name;
		this.email = email;
		this.location = location;
		this.contactNumber = number;
	}
	
	public void fetchApplications(){
		System.out.println("Application Fetched Successfully\n");
		//code to fetch applications from database
	}

}
