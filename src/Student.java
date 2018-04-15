import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Student extends User{
	
	String name, EMail, contactNumber;
	Counselor c;
	
	public Student(String name, String email, String number){
		super();
		this.name = name;
		this.EMail = email;
		this.contactNumber = number;
		//assign a random counselor
		c = new Counselor("imcounselor@vconnect.org","John Doe","23423423");
	}
	
	public void takeadvice(){
		c.giveAdvice();
	}
	
	public University applyForUniversity(String uniName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("university"));
		String line;
		String[] words;
		University u = null;
	    while((line=br.readLine())!=null){
	    	words=line.split(",");
	    	if(uniName.equals(words[2])){
	    		u = new University(words[2],words[0],words[4],words[3]);
	    		System.out.println("Applied Successfully");
	    		br.close();
	    		return u;
	    	}
        }
		br.close();
		return u;
	}
	
	public boolean uploadDocuments(){
		Scanner s = new Scanner(System.in);
		//save the document to document list in database
		System.out.print("Enter document name: ");
		String docName = s.nextLine();
		System.out.print("Enter document type: ");
		String type = s.nextLine();
		System.out.print("Enter document size (in KB): ");
		int size = s.nextInt();
		s.close();
		Document doc = new Document(this,docName,type,size);
		if(!doc.checkDocumentSize()) {
			System.out.println("Document size is too large, please upload a compressed document!");
			return false;
		}
		System.out.println("Sending doc for verification...");
		System.out.println("Document uploaded successfully!");
		this.verifyDoc(doc);
		return true; //if uploaded successfully
	}
	
	public void verifyDoc(Document doc) {
		if(doc.verify()) {
			System.out.println("Document " +doc.name +" verified successfully!");
		}else {
			System.out.println("Document " +doc.name +" verification failed!");
		}
	}
	
	public void generateResume(){
		//code to generate resume
		System.out.println("Resume Generated Successfully\n");
	}
	
}
