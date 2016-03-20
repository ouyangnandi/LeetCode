package solutions;

import java.util.HashMap;

/**
 * @Author: Nandi Ouyang 
 * @Date Apr 23, 2015
 *
 *          Given an array of integers, find two numbers such that they add up
 *          to a specific target number. The function twoSum should return
 *          indices of the two numbers such that they add up to the target,
 *          where index1 must be less than index2. Please note that your
 *          returned answers (both index1 and index2) are not zero-based. You
 *          may assume that each input would have exactly one solution. Input:
 *          numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TwoSum1 {

	public int[] twoSum(int[] numbers, int target) {

		if (numbers == null || numbers.length < 2)
			return null;

		int[] returnArr = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			int firstNum = numbers[i];
			int secondNum = target - numbers[i];

			if (map.containsKey(secondNum)) {
				returnArr[0] = map.get(secondNum) + 1;
				returnArr[1] = i + 1;
				break;
			}

			map.put(firstNum, i);
		}

		return returnArr;
	}
}
