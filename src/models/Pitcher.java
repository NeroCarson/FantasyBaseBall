package models;

public class Pitcher {
	
	public String name;
	public String team;
	public int w;
	public int l;
	public double era;
	public int g;
	public int gs;
	public int sv;
	public int svo;
	public double ip;
	public int h;
	public int r;
	public int er;
	public int hr;
	public int bb;
	public int so;
	public double avg;
	public double whip;
	public double rank;
	public boolean selected;
	
	public Pitcher(String name, String team) {
		this.name = name;
		this.team = team;
	}
}
