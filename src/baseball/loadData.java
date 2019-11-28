package baseball;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import models.League;
import models.Pitcher;
import models.Player;

public class loadData {

	public static League openFile(String fileName) {
		// create league
		League league = new League();
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(fileName));
			// read line by line
			while ((line = br.readLine()) != null) {
				if (fileName.equals("stats.csv")) {

					// create the player objects
					String playerName = parseName(line);
					String playerTeam = parseTeam(line);
					String playerPOS = parsePOS(line);
					Player player = new Player(playerName, playerTeam, playerPOS);

//					Player player = new Player(playerName, playerTeam, playerPOS);
//					League.players.add(player);
					// add the various statistics
					player.g = Integer.parseInt(parseG(line));
					player.ab = Integer.parseInt(parseAB(line));
					player.r = Integer.parseInt(parseR(line));
					player.h = Integer.parseInt(parseH(line));
					// b1????
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
					// add the players to the league
					league.players.add(player);
				} else if (fileName.equals("stats_pitcher.csv")) {
					// create the pitcher objects
					String pitcherName = parseName(line);
					String pitcherTeam = parseTeam(line);
					Pitcher pitcher = new Pitcher(pitcherName, pitcherTeam);
					// add pitchers to the league
					league.pitchers.add(pitcher);
					// add the various statistics
					pitcher.w = Integer.parseInt(parseWins(line));
					pitcher.l = Integer.parseInt(parseLosses(line));
					pitcher.era = Double.parseDouble(parseERA(line));
					pitcher.g = Integer.parseInt(parseG_pitcher(line));
					pitcher.gs = Integer.parseInt(parseGS(line));
					pitcher.sv = Integer.parseInt(parseSV(line));
					pitcher.svo = Integer.parseInt(parseSVO(line));
					pitcher.ip = Double.parseDouble(parseIP(line));
					pitcher.h = Integer.parseInt(parseH_pitcher(line));
					pitcher.r = Integer.parseInt(parseR_pitcher(line));
					pitcher.er = Integer.parseInt(parseER(line));
					pitcher.hr = Integer.parseInt(parseHR_pitcher(line));
					pitcher.bb = Integer.parseInt(parseBB_pitcher(line));
					pitcher.so = Integer.parseInt(parseSO_pitcher(line));
					pitcher.avg = Double.parseDouble(parseAVG_pitcher(line));
					pitcher.whip = Double.parseDouble(parseWHIP(line));

				} else {
					System.out.println("~~~Error~~~");
				}
			}
			return league;
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
		return null;

	}

	public static String parseWHIP(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[17];
	}

	public static String parseAVG_pitcher(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[16];
	}

	public static String parseSO_pitcher(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[15];
	}

	public static String parseBB_pitcher(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[14];
	}

	public static String parseHR_pitcher(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[13];
	}

	public static String parseER(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[12];
	}

	public static String parseR_pitcher(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[11];
	}

	public static String parseH_pitcher(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[10];
	}

	public static String parseIP(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[9];
	}

	public static String parseSVO(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[8];
	}

	public static String parseSV(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[7];
	}

	public static String parseGS(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[6];
	}

	public static String parseG_pitcher(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[5];
	}

	public static String parseERA(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[4];
	}

	public static String parseLosses(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[3];
	}

	public static String parseWins(String line) {
		String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens[2];
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
}
