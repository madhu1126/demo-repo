package pojo;

public class PostApiPOJO {

	private String title;
	private String author;

	public PostApiPOJO(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "PostApiPOJO [title=" + this.title + ", author=" + this.author + "]";
	}

	/*
	 * public String returnString() { String name = "Madhu"; String lastname = "LN";
	 * 
	 * return "Madhu Data:" +name+ " " +lastname; //return str; }
	 */

}
