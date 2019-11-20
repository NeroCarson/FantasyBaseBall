package baseball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class loadData {
	
	public static void openFile(String fileName) {
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(fileName));
			// read line by line 
			while ((line = br.readLine()) != null) {
				System.out.println( cvsToArrayList(line));
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
	
	// converts csv to array list using split
	public static ArrayList<Object> cvsToArrayList(String line) {
		ArrayList<Object> list = new ArrayList<Object>();
		if (line != null) {
			String[] tempArr = line.split(",");
			for (int i = 0; i < tempArr.length; i++) {
				if (!(tempArr[i] == null) || !(tempArr[i].length() == 0)) {
					list.add(tempArr[i].trim());
				}
			}
		}
		return list;
	}

	// create empty rosters 
	public static void createRosters() {
		
	 }
		 
	}
