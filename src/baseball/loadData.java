package baseball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class loadData {

	public static ArrayList<String> list = new ArrayList<String>();

	public static void openFile(String fileName) {
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(fileName));
			// read line by line
			while ((line = br.readLine()) != null) {
				cvsToArrayList(line);
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
	public static ArrayList<String> cvsToArrayList(String line) {
		if (line != null) {
			String[] tempArr = line.split("/n");
			for (int i = 0; i < tempArr.length; i++) {
				if (!(tempArr[i] == null) || !(tempArr[i].length() == 0)) {
					list.add(tempArr[i].trim());
				}
			}
		}
		return list;
	}

	public static void printList() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
