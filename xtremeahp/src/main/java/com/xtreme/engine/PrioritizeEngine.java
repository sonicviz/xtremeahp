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
			String level[][] = new String[size][2];
			levels[nodeLevel - 1] = level;
		} else {
			String[][] temp = (String[][]) levels[0];
			String level[][] = new String[temp.length + 1][size + 1];
			levels[nodeLevel - 1] = level;
		}
		int count = 0;
		String[][] temp = (String[][]) levels[nodeLevel - 1];
		while (tokens.hasMoreTokens()) {
			String node = tokens.nextToken();
			temp[count][0] = node;
			count++;
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
		System.out.println("--->level2");
		for (int r = 0; r < temp.length; r++) {
			for (int c = 0; c < temp[r].length; c++) {
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
		eng.createNodes(2, "ford,benz,toyota,honda");
		eng.printArrays();
	}
}
