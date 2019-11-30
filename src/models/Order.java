package models;

public class Order {
	String title = "null";
	int position = 20;
	
	public void setTitle(String name) {
		this.title = name;
	}
	public String getTitle() {
		return this.title;
	}
	public void setPos(int selected) {
		this.position = selected;
	}
	public int getPos() {
		return this.position;
	}
}
