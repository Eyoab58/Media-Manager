package mediaRentalManager;

public class Media implements Comparable<Media> {

	private int numOfCopies;
	private String title;
	
	public Media(String title, int numOfCopies) {
		this.title = title;
		this.numOfCopies = numOfCopies;
	}
	public Media() {
		this("noTitle", 0);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumOfCopies() {
		return numOfCopies;
	}
	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}
	public int compareTo(Media original) {
		return this.getTitle().compareTo(original.getTitle());
	}
}
