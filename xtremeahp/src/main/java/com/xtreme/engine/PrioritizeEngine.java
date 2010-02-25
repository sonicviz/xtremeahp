package com.xtreme.engine;

import java.util.StringTokenizer;

/***
 * Main class which takes up elements to prioritize
 * 
 * @author rjinoy
 * 
 */
public class PrioritizeEngine {

	// Map levels = new HashMap();

	Object[] levels;

	public PrioritizeEngine() {
	}

	public PrioritizeEngine(int levels) {
		prepareLevels(levels);
	}

	public void prepareLevels(int noOfLevels) {
		levels = new Object[noOfLevels];
	}

	public void createNodes(int nodeLevel, String nodes) {
		int size = 0;
		StringTokenizer tokens = new StringTokenizer(nodes, ",");
		size = tokens.countTokens();
		if (nodeLevel == 1) {
			String level[][] = new String[size - 1][size];
			levels[nodeLevel - 1] = level;		//level 0
		} else {
			String[][] temp = (String[][]) levels[0];
			String level[][] = new String[size + 1][temp[0].length + 1];
			levels[nodeLevel - 1] = level;		//level 1
		}
		int count = 0;
		// criteria
		// array
		if (nodeLevel == 1) {
			String[][] temp = (String[][]) levels[0]; // level 1
			while (tokens.hasMoreTokens()) {
				String node = tokens.nextToken();
				temp[0][count] = node; // all 0th rows will have node name
				count++;
			}
		} else {
			String[][] temp = (String[][]) levels[0]; // level 1
			String[][] tempL2 = (String[][]) levels[1];
			// level1 row --> level2 row
			for (int r = 0; r < temp.length; r++) {
				for (int c = 0; c < temp[r].length; c++) {
					if (r == 0) { // level2 header
						System.out.println("r:"+r+":c:"+c);
						tempL2[r][c+1] = temp[r][c];
					}
				}
			}
			count = 1;
			while (tokens.hasMoreTokens()) {
				String node = tokens.nextToken();
				tempL2[count][0] = node; // all 0th col will have node name
				count++;
			}

		}
	}

	public void printArrays() {
		String[][] temp = (String[][]) levels[0];
		System.out.println("--->level1");
		for (int r = 0; r < temp.length; r++) {
			for (int c = 0; c < temp[r].length; c++) {
				System.out.println("[" + r + "," + c + "]" + temp[r][c]);

			}
		}
		temp = (String[][]) levels[1];
		if (temp == null)
			return;
		System.out.println("--->level2");
		for (int r = 0; r < temp.length; r++) {
			for (int c = 0; c <temp[r].length; c++) {
				System.out.println("[" + r + "," + c + "]" + temp[r][c]);

			}
		}

	}

	public void updateNodes() {

	}

	public static void main(String args[]) {
		System.out.println("start");
		PrioritizeEngine eng = new PrioritizeEngine(2);
		System.out.println("init levels:" + eng.levels);
		eng.createNodes(1, "reliability,speed,comfort");
		// eng.updateNodes(1,"reliability,speed,comfort");
		eng.createNodes(2, "ford,benz,toyota,honda");
		eng.printArrays();
	}
}
