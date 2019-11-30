package models;

public class Player extends Person {
	public String pos;
	public int g;
	public int ab;
	public int r;
	public int h;
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

	public static String getHeaderRow() {
		return String.format(
				"%-15s %-5s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-6s %-6s %-6s %-6s %-6s%n",
				"Player", "Team", "Pos", "G", "AB", "R", "H", "2B", "3B", "HR", "RBI", "BB", "SO", "SB", "CS",
				"AVG", "OBP", "SLG", "OPS", "RANK");
	}

	@Override
	public String toString() {
		return String.format(
				"%-15s %-5s %-4s %-4d %-4d %-4d %-4d %-4d %-4d %-4d %-4d %-4d %-4d %-4d %-4d %-6.3f %-6.3f %-6.3f %-6.3f %-6.3f",
				name, team, pos, g, ab, r, h, b2, b3, hr, rbi, bb, so, sb, cs, avg, obp, slg, ops, rank);
	}
}
