package models;

public class Pitcher extends Person {
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
	
	public Pitcher(String name, String team) {
		this.name = name;
		this.team = team;
	}
	@Override
    public String toString() {
       return "player: " + this.name + " team: " + this.team;
    }
}
