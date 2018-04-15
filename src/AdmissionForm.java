
public class AdmissionForm {
	int formID;
	University u;
	boolean eligibility;
	
	public boolean fillForm(Student s,University u){
		this.u = u;
		sendApplication();
		return true;
	}
	
	public void sendApplication(){
		u.fetchApplications();
	}
	
}
