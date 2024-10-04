package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;

import javax.print.attribute.standard.Media;

public class MediaRentalManager implements MediaRentalManagerInt {
	ArrayList<Customer> allCustomer = new ArrayList<Customer>();
	ArrayList<Media> allMedia = new ArrayList<Media>();
	
	
	public void addCustomer(String name, String address, String plan) {
		if((!plan.equals("LIMITED")) || !plan.equals("UNLIMITED")) {
			
		}
		allCustomer.add(new Customer(name, address, plan));
		
	}
	
	
	
	
	public void addMovie(String title, int copiesAvailable, String rating) {
	if((!rating.equals("PG")) || (!rating.equals("R")) || (!rating.equals("NR"))){	
	}
		allMedia.add(new Movie(title, copiesAvailable, rating))	;
	}
	
	
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		allMedia.add(new Album(title, copiesAvailable, artist, songs));
	}
	
	
	
	public void setLimitedPlanLimit(int value) {
		for(Customer customer : allCustomer) {
			customer.setMax(value);
		}
	}
	
	
	
	public String getAllCustomersInfo() {
		String customerInfo = "***** Customer ' Information *****\n";
		
		Collections.sort(allCustomer);
		for(Customer customer : allCustomer) {
			customerInfo += "Name: " + customer.getName() + ", Address: " + customer.getAddress() +
					", Plan: " + customer.getPlan() +"\n" +  "Rented: " + customer.getRented() + "\n"
					+ "Queue: " + customer.getQueued() + "\n";
		}
		return customerInfo;
	}
	public String getAllMediaInfo() {
		String mediaInfo = "***** Media Information *****\n";
		ArrayList<String> newArray = new ArrayList<String>();
		
		for(Media a : media) {
			newArray.add(a.toString());
		}
		
		Collections.sort(newArray);
		
		for(String b : newArray) {
			mediaInfo += b + "\n";
		}
		return mediaInfo;
	}
	public boolean addToQueue(String customerName, String mediaTitle) {
		for(Customer customer : allCustomer) {
			if(customer.getName().equals(customerName)) {
				for(String media : customer.getQueued()) {
					if(media.equals(mediaTitle)) {
						return false;
					}
				}
				customer.addToQueue(mediaTitle);
			}
		}
		return true;
	}
	
	public boolean removeFromQueue(String customerName, String mediaTitle) {
		if(customerName == null || mediaTitle == null) {
			return false;
		}
		for(Customer customer : allCustomer) {
			if(customer.getName().equals(customerName)) {
				for(String media : customer.getQueued()) {
					if(media.equals(mediaTitle)) {
						customer.removeFromQueue(mediaTitle);
					}
				}
			}
		}
		return false;
	}
	public String processRequests() {
		Collections.sort(allCustomer);
		String answer = "";
		for(Customer customer : allCustomer) {
			if(customer.getPlan().equals("Limited")) {
				for(Media media : allMedia) {
					if(media.getNumOfCopies() != 0 && customer.getQueued().contains(media.getTitle()) 
							&& customer.getRented().size() != customer.getMax()) {
						media.setNumOfCopies(media.getNumOfCopies()-1);
						customer.removeFromQueue(media.getTitle());
						customer.addToRented(media.getTitle());
						answer += "Sending " + media.getTitle() + " to "
								+ customer.getName() + "\n";	
					}
				}
			}else {
				for(Media media : allMedia) {
					if (media.getNumOfCopies() != 0 && customer.getQueued().contains(media.getTitle())) {


						media.setNumOfCopies(media.getNumOfCopies()-1);
						customer.removeFromQueue(media.getTitle());
						customer.addToRented(media.getTitle());
						answer += "Sending " + media.getTitle() + " to "
								+ customer.getName() + "\n";	
					}
				}
			}
		}
		return answer;
	}
	public boolean returnMedia(String customerName, String mediaTitle) {
		for(Customer customer : allCustomer) {
			if(customer.getName().equals(customerName)) {
				for(Media media : allMedia) {
					if(media.getTitle().equals(mediaTitle)) {
						customer.removeFromRented(mediaTitle);
						media.setNumOfCopies(media.getNumOfCopies()+1);		
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs){
		
		ArrayList<String> copy = new ArrayList<String>();
		Collections.sort(allMedia);
		
		for(Media media : allMedia) {
			
			if(media.getTitle().equals(title)) {
				copy.add(media.getTitle());
				break;
			}
		}
		if(rating != null) {
			if(media instanceof Movie && ((Movie)media).getRating().equals(rating)) {
				copy.add(media.getTitle());
			}
		}
		if(artist != null) {
			if(media instanceof Album && ((Album) media).getArtist().equals(artist)) {
				copy.add(media.getTitle());
				break;	
			}
		}
		if(songs != null) {
			if(media instanceof Album) {
				int value = ((Album)media.getListOfSongs().indexOf(songs));
				if(value != 0) {
					copy.add(media.getTitle());
					break;
				}
			}
		}
		if(title == null && rating == null && artist == null && songs == null) {
			copy.add(media.getTitle());
		}
	}
	return copy;
	

}
