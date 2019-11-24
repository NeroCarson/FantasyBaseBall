package models;

public class Player extends Person {
	public String pos;
	public int g;
	public int ab;
	public int r;
	public int h;
	public int b1;
	public int b2;
	public int b3;
	public int hr;
	public int rbi;
	public int bb;
	public int so;
	public int sb;
	public int cs;
	public double avg;
	public double obp;
	public double slg;
	public double ops;
	
	public Player(String name, String team, String pos) {
		this.name = name;
		this.team = team;
		this.pos = pos;
	}
	@Override
    public String toString() {
       return "player: " + this.name + " team: " + this.team + " pos: " + this.pos;
    }
}
