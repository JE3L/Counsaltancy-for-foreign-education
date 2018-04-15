//we have not implemented the full functionality of the blog, we have only created the wireframe
public class Blog {
	
	String title;
	User author;
	String content;
	float rating;
	int ratingCount;
	
	public void writeBlog(String t, User a, String c){
		this.title = t;
		this.author = a;
		this.content = c;
	}
	
	public boolean postBlog(){
		return true;
	}
	
	public boolean sendForApproval(){
		return true;
	}

	
	public void getReview(User u, String review){
		
	}
	
	public void getRating(User u, float rating){
		this.rating = ((this.rating*ratingCount)+rating)/(ratingCount+1);
		ratingCount++;
	}

}
