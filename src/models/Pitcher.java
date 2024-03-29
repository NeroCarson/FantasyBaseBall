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
	
	public static String getShortHeaderRow() {
		return String.format("%-15s %-5s %-4s %-6s%n", "Player", "Team", "Pos", "RANK");
	}
	
	public String toShortString() {
		return String.format("%-15s %-5s %-4s %-6.3f", name, team, "P", rank);
	}

	public static String getHeaderRow() {
		return String.format(
				"%-15s %-5s %-4s %-4s %-6s %-4s %-4s %-4s %-4s %-6s %-4s %-4s %-4s %-4s %-4s %-6s %-6s %-6s%n",
				"Player", "Team", "W", "L", "ERA", "G", "GS", "SV", "SVO", "IP", "H", "ER", "HR", "BB", "SO", "AVG",
				"WHIP", "RANK");
	}
	
	@Override
	public String toString() {
		return String.format("%-15s %-5s %-4d %-4d %-6.2f %-4d %-4d %-4d %-4d %-6.1f %-4d %-4d %-4d %-4d %-4d %-6.3f %-6.3f %-6.3f",
				name, team, w, l, era, g, gs, sv, svo, ip, h, er, hr, bb, so, avg, whip, rank);
	}
}
