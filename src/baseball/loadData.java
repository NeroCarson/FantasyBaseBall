package baseball;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import models.League;
import models.Pitcher;
import models.Player;

public class loadData {

	public static void openFile(String fileName) {
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(fileName));
			// read line by line
			while ((line = br.readLine()) != null) {
				if (fileName.equals("stats.csv")) {
					// CREATE PLAYER OBJECT
					String playerName = parseName(line);
					String playerTeam = parseTeam(line);
					String playerPOS = parsePOS(line);
					Player player = new Player(playerName, playerTeam, playerPOS);
					League.players.add(player);
					// ADD STATS
					player.g = Integer.parseInt(parseG(line));
					System.out.println(player.g);
				} else if (fileName.equals("stats_pitcher.csv")) {
					// CREATE PITCHER OBJECT
					String pitcherName = parseName(line);
					String pitcherTeam = parseTeam(line);
					Pitcher pitcher = new Pitcher(pitcherName, pitcherTeam);
					League.pitchers.add(pitcher);
					// ADD STATS
				} else {
					System.out.println("err");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static String parseName(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[0];
	}

	public static String parseTeam(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[1];
	}

	public static String parsePOS(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[2];
	}

	public static String parseG(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[3];
		
	}

	

//	public static int parseAB(String line) {
//		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//		return tokens[2];
//
//	}
//
//	public static int parseR(String line) {
//		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//		return tokens[2];
//
//	}
//
//	public static int parseH(String line) {
//		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//		return tokens[2];
//
//	}
//
//	public static int parseB2(String line) {
//		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//		return tokens[2];
//
//	}
//
//	public static int parseB3(String line) {
//		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//		return tokens[2];
//
//	}
//
//	public static int parseHR(String line) {
//		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//		return tokens[2];
//
//	}
//
//	public static int parseRBI(String line) {
//		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//		return tokens[2];
//
//	}
//
//	public static int parseBB(String line) {
//		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//		return tokens[2];
//
//	}
//
//	public static int parseSO(String line) {
//		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//		return tokens[2];
//
//	}
//
//	public static int parseSB(String line) {
//		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//		return tokens[2];
//
//	}
//
//	public static int parseCS(String line) {
//
//	}
//
//	public static double parseAVG(String line) {
//
//	}
//
//	public static double parseOBP(String line) {
//
//	}
//
//	public static double parseSLG(String line) {
//
//	}
//
//	public static double parseOPS(String line) {
//
//	}
	// // converts csv to array list using split
//	public static ArrayList<String> cvsToArrayList(String line) {
//		if (line != null) {
//			String[] tempArr = line.split("/n");
//			for (int i = 0; i < tempArr.length; i++) {
//				if (!(tempArr[i] == null) || !(tempArr[i].length() == 0)) {
//					list.add(tempArr[i].trim());
//				}
//			}
//		}
//		return list;
//	}

//	public static void printList() {
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println(list.get(0));
//	}
//	//MUST CREATE PLAYER OBJECTS
//	
//	public static void createPlayers() {
//		
//		String name = list.get(0).split(" ");
//		
//	
//		Player(name, team, pos);
//		
//	}

}

