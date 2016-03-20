package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Nandi Ouyang
 * @Date Mar 29, 2015
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * [
 *	    [1],
 *	   [1,1],
 *	  [1,2,1],
 *	 [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class PascalTriangle118 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (numRows == 0)
			return list;

		List<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(1);
		list.add(firstRow);
		if (numRows == 1) {
			return list;
		}

		List<Integer> lastRow = firstRow;
		for (int i = 1; i < numRows; i++) {
			List<Integer> newRow = generateOneRow(i, lastRow);
			list.add(newRow);
			lastRow = newRow;
		}
		return list;
	}

	private List<Integer> generateOneRow(int rowNum, List<Integer> lastRow) {
		List<Integer> newRow = new ArrayList<Integer>();
		newRow.add(1);
		for (int i = 0; i < lastRow.size() - 1; i++) {
			newRow.add(lastRow.get(i) + lastRow.get(i + 1));
		}
		newRow.add(1);
		return newRow;

	}

}
