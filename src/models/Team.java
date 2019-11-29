package models;

import java.util.ArrayList;

public class Team {
	public Player c; // catcher
	public Player b1; // first base
	public Player b2; // second base
	public Player b3; // third base
	public Player ss; // short stop
	public Player lf; // left field
	public Player cf; // Center field
	public Player rf; // right field
	public Pitcher p1; // pitcher 1
	public Pitcher p2; // pitcher 2
	public Pitcher p3; // pitcher 3
	public Pitcher p4; // pitcher 4
	public Pitcher p5; // pitcher 5
	
	
	public boolean addPlayer(Player player) {
		switch (player.pos.toLowerCase()) {
		case "c":
			c = player;
			return true;
		case "b1":
			b1 = player;
			return true;
		case "b2":
			b2 = player;
			return true;
		case "b3":
			b3 = player;
			return true;
		case "ss":
			ss = player;
			return true;
		case "lf":
			lf = player;
			return true;
		case "cf":
			cf = player;
			return true;
		case "rf":
			rf = player;
			return true;
		}
		return false;
	}
	
	public boolean addPitcher(Pitcher pitcher) {

		if (p1 == null) {
			p1 = pitcher;
			return true;
		} else if (p2 == null) {
			p2 = pitcher;
			return true;
		} else if (p3 == null) {
			p3 = pitcher;
			return true;
		} else if (p4 == null) {
			p4 = pitcher;
			return true;
		} else if (p5 == null) {
			p5 = pitcher;
			return true;
		}
		return false;
	}
	
	
	public Boolean isPositionFilled(String position) {
		switch (position.toLowerCase()) {
		case "c":
			return c != null;
		case "b1":
			return b1 != null;
		case "b2":
			return b2 != null;
		case "b3":
			return b3 != null;
		case "ss":
			return ss != null;
		case "ls":
			return lf != null;
		case "cf":
			return cf != null;
		case "rf":
			return rf != null;
		case "p":
			return p1 != null && p2 != null && p3 != null && p4 != null && p5 != null;
		default:
			return false;
		}
	}
	
	public String[] getOpenPositions() {
		ArrayList<String> required = new ArrayList<>();
		if (c == null)
			required.add("c");
		if (b1 == null)
			required.add("b1");
		if (b2 == null)
			required.add("b2");
		if (b3 == null)
			required.add("b3");
		if (ss == null)
			required.add("ss");
		if (lf == null)
			required.add("lf");
		if (cf == null)
			required.add("cf");
		if (rf == null)
			required.add("rf");
		if (p1 == null || p2 == null || p3 == null || p4 == null || p5 == null)
			required.add("p");
		String[] toReturn = new String[required.size()];
		return required.toArray(toReturn);
	}
}
