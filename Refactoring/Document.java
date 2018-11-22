import java.util.Date;

public abstract class Document {
	
	private Date date;
	private String title;
	private String author;
	protected PublishingLocation location;
	
	
	public Document(Date date, String title, String author, String city, String state, String postCode) {
		location = new PublishingLocation(city, state, postCode);
		this.date = date;
		this.title = title;
		this.author = author;
	}

	public int compareDates(Document date){
		return this.date.compareTo(date.getDate());
	}
	
	public boolean sameAuthor(Document author){
		return this.author.equals(author.getAuthor());
	}
	
	public int compareWithGeneralDate(Date date){
		return this.date.compareTo(date);
	}
	
	
	
	public Date getDate() {
		return date;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
}
