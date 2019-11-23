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
					// create the player object
					String playerName = parseName(line);
					String playerTeam = parseTeam(line);
					String playerPOS = parsePOS(line);
					Player player = new Player(playerName, playerTeam, playerPOS);
					League.players.add(player);
					// add the various statistics
					player.g = Integer.parseInt(parseG(line));
					player.ab = Integer.parseInt(parseAB(line));
					player.r = Integer.parseInt(parseR(line));
					player.h = Integer.parseInt(parseH(line));
					player.b2 = Integer.parseInt(parseB2(line));
					player.b3 = Integer.parseInt(parseB3(line));
					player.hr = Integer.parseInt(parseHR(line));
					player.rbi = Integer.parseInt(parseRBI(line));
					player.bb = Integer.parseInt(parseBB(line));
					player.so = Integer.parseInt(parseSO(line));
					player.sb = Integer.parseInt(parseSB(line));
					player.cs = Integer.parseInt(parseCS(line));
					player.avg = Double.parseDouble(parseAVG(line));
					player.obp = Double.parseDouble(parseOBP(line));
					player.slg = Double.parseDouble(parseSLG(line));
					player.ops = Double.parseDouble(parseOPS(line));

				} else if (fileName.equals("stats_pitcher.csv")) {
					// create the pitcher object
					String pitcherName = parseName(line);
					String pitcherTeam = parseTeam(line);
					Pitcher pitcher = new Pitcher(pitcherName, pitcherTeam);
					League.pitchers.add(pitcher);
					// add the various statistics

				} else {
					System.out.println("~~~Error~~~");
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

	public static String parseAB(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[4];

	}

	public static String parseR(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[5];

	}

	public static String parseH(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[6];

	}

	public static String parseB2(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[7];

	}

	public static String parseB3(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[8];

	}

	public static String parseHR(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[9];

	}

	public static String parseRBI(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[10];

	}

	public static String parseBB(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[11];

	}

	public static String parseSO(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[12];

	}

	public static String parseSB(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[13];

	}

	public static String parseCS(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[14];

	}

	public static String parseAVG(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[15];

	}

	public static String parseOBP(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[16];
	}

	public static String parseSLG(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[17];
	}

	public static String parseOPS(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[18];

	}
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
