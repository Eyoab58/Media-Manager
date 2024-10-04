package mediaRentalManager;

public class Album extends Media{
	private String artist;
	private String listOfSongs;

	
	public Album(String title, int numOfCopies, String artist, String listOfSongs) {
		this.artist = artist;
		this.listOfSongs = listOfSongs;
	}
	public Album() {
		super("noTitle", 0);
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getListOfSongs() {
		return listOfSongs;
	}
	public void setListOfSongs(String listOfSongs) {
		this.listOfSongs = listOfSongs;
	}
	
}
