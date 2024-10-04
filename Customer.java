package mediaRentalManager;

import java.util.ArrayList;

public class Customer implements Comparable <Customer> {

	private ArrayList<String> rented = new ArrayList<String>();
	private ArrayList<String> queued = new ArrayList<String>();
	
	private String name;
	private String address;
	private String plan;
	private int max;
	
	
	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		this.max = 2;
	}
	public ArrayList<String> getRented(){
		return rented;
	}
	
	public ArrayList<String> getQueued(){
		return queued;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlan() {
		return plan;
	}
	public void setPLan(String plan) {
		this.plan = plan;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public void addToQueue(String title) {
		queued.add(title);
	}
	public void removeFromQueue(String title) {
		queued.remove(title);
	}
	public void addToRented(String title) {
		rented.remove(title);
	}
	public void remmoveFromRented(String title) {
		rented.remove(title);
	}
	public int compareTo(Customer original) {
		return this.getName().compareTo(original.getName());
	}
	
}
