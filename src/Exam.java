import java.util.Random;

public class Exam {
	float duraion;
	String type;
	int maxMarks;
	
	public Exam(String t){
		this.duraion = 60;
		this.type = t;
		this.maxMarks = 100;
	}
	
	public void conductExam(Student s){
		//Student give exam and according to that get result
		giveResult(s);
	}
	
	public void giveResult(Student s){
        Random rand = new Random();
        int r = rand.nextInt(101);
		System.out.println("You have got "+r+" marks out of 100\n");
	}

}
