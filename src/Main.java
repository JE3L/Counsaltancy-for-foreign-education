import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to VConnect portal!");
		Scanner s = new Scanner(System.in);
		while(true){
			System.out.println("Press:\n1. Sign In\n2. Sign Up\n3. forgot password\n4. Exit");
			System.out.print("Enter your choice: ");
			int option = s.nextInt();
			if(option==1){
				boolean flag = false;
				String line;
				String[] words = null;
				s.nextLine();
				System.out.println("Enter the given fields:");
				System.out.print("Type of user that you are <Student/Professor/University>: ");
				String type = s.nextLine();
				System.out.print("Enter your username: ");
				String username = s.nextLine();
				System.out.print("Enter your password: ");
				String password = s.nextLine();
				switch(type) {
				case "Student":
					FileReader fileread1 = new FileReader("student");
				    BufferedReader buffread1 = new BufferedReader(fileread1);
				    while((line=buffread1.readLine())!=null){
				    	words=line.split(",");
				    	if(username.equals(words[0]) && password.equals(words[1])){
				    		System.out.println("Logged in successfully!");
				    		flag=true;break;
				    	}
		            }
				    if(flag==false) System.out.println("Username, Password combination does not exists, please recheck!");
				    else System.out.println("Welcome "+words[0]+" to Vconnect");
				    while(flag==true){
			    			Student std = new Student(words[2],words[0],words[3]);
							System.out.println("Press:\n1. upload document\n2. logout\n3. Apply for university\n4. Generate resume\n5. Give Exam\n6. Visa Application");
							option = s.nextInt();
							switch(option) {
							case 1:
								if(!std.uploadDocuments()){
									System.out.println("Document upload failure!");
								}
								break;
							case 2:
								flag = false;
								System.out.println("Logged out successfully!");
								break;
							case 3:
								System.out.print("Enter the university name to apply: ");
								s.nextLine();
								String uni = s.nextLine();
								University u = std.applyForUniversity(uni);
								if(u == null) {System.out.println("University not found");break;}
					    		AdmissionForm ad = new AdmissionForm();
					    		ad.fillForm(std, u);
					    		break;
							case 4:
								std.generateResume();
								break;
							case 5:
								System.out.print("Enter Subject that u want to give exam: ");
								s.nextLine();
								String sub = s.nextLine();
								Exam e = new Exam(sub);
								e.conductExam(std);
								break;
							case 6:
								System.out.print("Enter Location that u want to go: ");
								s.nextLine();
								String loc = s.nextLine();
								VisaOffice v = new VisaOffice(loc);
								v.recieveApplication(std);
								break;
							default:
								System.out.println("Please enter a valid option");
							}
		            }
				    fileread1.close();
				    buffread1.close();
					break;
				case "Professor":
				    FileReader fileread2 = new FileReader("professor");
				    BufferedReader buffread2 = new BufferedReader(fileread2);
				    while((line=buffread2.readLine())!=null){
				    	words=line.split(",");
				    	if(username.equals(words[0]) && password.equals(words[1])){
				    		System.out.println("Logged in successfully!");
				    		flag=true;break;
				    	}
		            }
				    if(flag==false) System.out.println("Username, Password combination does not exists, please recheck!");
				    else System.out.println("Welcome "+words[0]+" to Vconnect");
				    while(flag==true){
				    	Professor pro = new Professor(words[2],words[0],words[4],words[3]);
				    	System.out.println("Press:\n1. logout\n2. Give webinar");
						option = s.nextInt();
						switch(option) {
							case 1:
								flag = false;
								System.out.println("Logged out successfully!");
								break;
							case 2:
								System.out.print("Enter Date of Webinar: ");
								s.nextLine();
								String date = s.nextLine();
								System.out.print("Enter duration: ");
								float f = s.nextFloat();
								pro.giveWebinar(date,f);
								break;
							default:
								System.out.println("Please enter a valid option!");
						}
				    }
				    fileread2.close();
				    buffread2.close();
				    break;
				case "University":
				    FileReader fileread3 = new FileReader("university");
				    BufferedReader buffread3 = new BufferedReader(fileread3);
				    while((line=buffread3.readLine())!=null){
				    	words=line.split(",");
				    	if(username.equals(words[0]) && password.equals(words[1])){
				    		System.out.println("Logged in successfully!");
				    		flag=true;break;
				    	}
		            }
				    if(flag==false) System.out.println("Username, Password combination does not exists, please recheck!");
				    else System.out.println("Welcome "+words[0]+" to Vconnect");
				    while(flag==true){
				    	System.out.println("Press:\n1. logout");
						option = s.nextInt();
						switch(option) {
							case 1:
								flag = false;
								System.out.println("Logged out successfully!");
								break;
							default:
								System.out.println("Please enter a valid option");
						}
				    }
				    fileread3.close();
				    buffread3.close();
				    break;
				default:
					System.out.println("Please, Enter valid option!!");
				}
			}else if(option==2){
				System.out.println("Enter the given fields:");
				System.out.print("Type of user <Student/Professor/University>: ");
				s.nextLine();
				String type = s.nextLine();
				System.out.print("Enter your full name: ");
				String name = s.nextLine();
				System.out.print("Enter your email address: ");
				String mail = s.nextLine();
				while(!User.checkEmailValidity(mail)) {
					System.out.println("Please enter a valid email!");
					System.out.print("Enter email address: ");
					mail = s.nextLine();
				}
				System.out.print("Enter your password: ");
				String password = s.nextLine();
				System.out.print("Enter your password again: ");
				String temp = s.nextLine();
				while(!password.equals(temp)) {
					System.out.println("Passwords do not match!");
					System.out.print("Enter your password: ");
					password = s.nextLine();
					System.out.print("Enter your password again: ");
					temp = s.nextLine();
				}
				System.out.print("Enter you contact number: ");
				String phone = s.nextLine();
				switch(type) {
				case "Student":
				    FileWriter filewriter = new FileWriter("student",true);
				    BufferedWriter buffwrite = new BufferedWriter(filewriter);
				    buffwrite.write(mail+","+password+","+name+","+phone+"\n");
					User std = new Student(name,mail,phone);
					std.make_profile(mail, password);
					buffwrite.close();
					filewriter.close();
					System.out.println("Student profile successfully created!");
					break;
				case "Professor":
				    FileWriter filewriter2 = new FileWriter("professor",true);
				    BufferedWriter buffwrite2 = new BufferedWriter(filewriter2);
					System.out.print("Enter your subject: ");
					String subject = s.nextLine();
					User prof = new Professor(name,mail,subject,phone);
					prof.make_profile(mail, password);
				    buffwrite2.write(mail+","+password+","+name+","+phone+","+subject+"\n");
					buffwrite2.close();
					filewriter2.close();
					System.out.println("Professor profile created successfully!");
					break;
				case "University":
				    FileWriter filewriter3 = new FileWriter("university",true);
				    BufferedWriter buffwrite3 = new BufferedWriter(filewriter3);
					System.out.print("Enter your location: ");
					String loc = s.nextLine();
					User uni = new University(name,mail,loc,phone);
					uni.make_profile(name, password);
				    buffwrite3.write(mail+","+password+","+name+","+phone+","+loc+"\n");
					buffwrite3.close();
					filewriter3.close();
					System.out.println("University profile created successfully!");
					break;
				default:
					System.out.println("Please Enter a valid option!");
				}
			}
			else if(option==3){
				System.out.println("Enter the given fields:");
				System.out.print("Type of user <Student/Professor/University>: ");
				s.nextLine();
				String type = s.nextLine();
				System.out.print("Enter your username: ");
				String name = s.nextLine();
				String line;
				boolean flag = false;
				String[] words;
				switch(type) {
				case "Student":
				    FileReader fileread = new FileReader("student");
				    BufferedReader buffread = new BufferedReader(fileread);
				    while((line=buffread.readLine())!=null){
				    	words=line.split(",");
				    	if(name.equals(words[0])){
				    		System.out.println("Your Password is: "+words[1]);
				    		flag = true;break;
				    	}
		            }
				    fileread.close();
				    buffread.close();
				    break;
				case "Professor":
				    FileReader fileread2 = new FileReader("professor");
				    BufferedReader buffread2 = new BufferedReader(fileread2);
				    while((line=buffread2.readLine())!=null){
				    	words=line.split(",");
				    	if(name.equals(words[0])){
				    		System.out.println("Your Password is: "+words[1]);
				    		flag=true;break;
				    	}
		            }
				    fileread2.close();
				    buffread2.close();
				    break;
				case "University":
				    FileReader fileread3 = new FileReader("university");
				    BufferedReader buffread3 = new BufferedReader(fileread3);
				    while((line=buffread3.readLine())!=null){
				    	words=line.split(",");
				    	if(name.equals(words[0])){
				    		System.out.println("Your Password is: "+words[1]);
				    		flag=true;break;
				    	}
		            }
				    fileread3.close();
				    buffread3.close();
				    break;
				default:
					System.out.println("Please Enter a valid option!");
				}
				if(flag==false) System.out.println("Username does not exist.\n");
			}else if(option==4) {
				System.out.println("Terminating Session...");
				s.close();
				System.out.println("Session Terminated, Goodbye..");
				break;
			}else{
				System.out.println("Please enter valid option and try again");
			}
		}
	}

}
