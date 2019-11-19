package baseball;


import java.util.List;

public class Main {

	public static void main(String[] args) {
		loadData.openFile("stats.csv");
		System.out.println();
		loadData.openFile("stats_pitcher.csv");

	}

	public class player {
		String Name;
		String Team;
		String Pos;
		int G;
		int AB;
		int R;
		int H;
		int firstBase;
		int secondBase;
		int thirdBase;
		int HR;
		int RBI;
		int BB;
		int SO;
		int SB;
		int CS;
		double AVG;
		double OBP;
		double SLG;
		double OPS;
		double Rank;
		boolean Selected;

	}

	public class pitcher {
		// Pitcher
		String name;
		String Team;
		int W;
		int L;
		double ERA;
		int G;
		int GS;
		int SV;
		int SVO;
		double IP;
		int H;
		int R;
		int ER;
		int HR;
		int BB;
		int SO;
		double AVG;
		double WHIP;
		double Rank;
		boolean Selected;

	}

	public class Team {
		// Team
		player C; // catcher
		player firstB; // first base
		player secondB; // second base
		player thirdB; // thirdbase
		player SS; // short stop
		player LF; // left field
		player CF; // Center field
		player RF; // right field
		pitcher P1; // pitcher 1
		pitcher P2; // pitcher 2
		pitcher P3; // pitcher 3
		pitcher P4; // pitcher 4
		pitcher P5; // pitcher 5

	}

	public class LeagueMember {
		String Name; // (A, B, C, D)
		Team Team;
	}

	public class League {
		// League
		LeagueMember memberA;
		LeagueMember memberB;
		LeagueMember memberC;
		LeagueMember memberD;

		List<player> players;
		List<pitcher> pitchers;

	}

}
