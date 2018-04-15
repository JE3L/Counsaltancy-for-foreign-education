
public class Document {
	String name, type;
	boolean verification;
	Student s;
	int size; //in bytes
	
	public Document(Student stu, String n, String type,int s){
		this.s =stu;
		this.name = n;
		this.type = type;
		this.size = s;
		this.verification = false;
	}
	
	public boolean verify(){
		return s.c.verifyDoc(this);
	}
	
	public boolean checkDocumentSize(){
		if(size>1024) return false;
		else return true;
	}
	
}
