package models;

public class LeagueMember {
	
	public String name; // (A, B, C, D)
	public Team team;
	public int recruits;
	
	public LeagueMember(String name) {
		this.name = name;
		this.team = new Team();
		recruits = 0;
	}
}
