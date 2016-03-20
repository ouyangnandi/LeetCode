package solutions;

import java.util.HashMap;

/**
 * @Author: Nandi Ouyang
 * @Date : Apr 26, 2015
 * @Desc : Given a string, find the length of the longest substring without
 *       repeating characters. For example, the longest substring without
 *       repeating letters for "abcabcbb" is "abc", which the length is 3. For
 *       "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubStringWithoutRepeating3 {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty())
			return 0;
		HashMap<Character, Integer> indexMap = new HashMap<Character, Integer>();
		char[] chars = s.toCharArray();

		int maxLength = 1;
		int slowIndex = 0;

		for (int i = 0; i < s.length(); i++) {

			Integer startIndex = indexMap.get(chars[i]);

			if (startIndex == null || startIndex < slowIndex) {
				indexMap.put(chars[i], i);

				int tempLength = i + 1 - slowIndex;

				if (tempLength > maxLength)
					maxLength = tempLength;

			} else {
				slowIndex = indexMap.get(chars[i]) + 1;
				indexMap.put(chars[i], i);
			}
		}

		return maxLength;
	}
}
