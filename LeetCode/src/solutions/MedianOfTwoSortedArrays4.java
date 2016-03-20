package solutions;

import print.Print;
import math.Math;

/**
 * @Author: Nandi Ouyang
 * @Date : May 1, 2015
 * @Desc :
 */
public class MedianOfTwoSortedArrays4 {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null)
			return -1;
		double returnNum = 0d;
		int maxLength = nums1.length + nums2.length;

		int[] mergeArr = new int[maxLength];

		int num1Index = 0;
		int num2Index = 0;
		int mergeIndex = 0;

		while (true) {

			if (num1Index >= nums1.length) {
				int temp2 = nums2[num2Index];
				mergeArr[mergeIndex] = temp2;
				num2Index++;
			} else if (num2Index >= nums2.length) {
				int temp1 = nums1[num1Index];
				mergeArr[mergeIndex] = temp1;
				num1Index++;
			} else {
				int temp1 = nums1[num1Index];
				int temp2 = nums2[num2Index];

				if (temp1 < temp2) {
					mergeArr[mergeIndex] = temp1;
					num1Index++;
				} else {
					mergeArr[mergeIndex] = temp2;
					num2Index++;
				}
			}

			mergeIndex++;

			if (mergeIndex == mergeArr.length)
				break;

		}

		Print.printArray(mergeArr);

		if (Math.isOdd(maxLength)) {
			returnNum = mergeArr[maxLength / 2];
		} else {
			returnNum = ((double) mergeArr[maxLength / 2] + (double) mergeArr[maxLength / 2 - 1]) / 2;
		}

		return returnNum;
	}

	public static double findMedianSortedArraysWithoutExtraSpace(int[] nums1,
			int[] nums2) {
		if (nums1 == null || nums2 == null)
			return -1;
		double returnNum = 0d;

		int maxLength = nums1.length + nums2.length;
		int num1Index = 0;
		int num2Index = 0;
		int mergeIndex = 0;
		int preNum = -1;
		int postNum = -1;

		while (true) {

			if (num1Index >= nums1.length) {
				preNum = postNum;
				postNum = nums2[num2Index];
				num2Index++;
			} else if (num2Index >= nums2.length) {
				preNum = postNum;
				postNum = nums1[num1Index];
				num1Index++;
			} else {

				if (nums1[num1Index] < nums2[num2Index]) {
					preNum = postNum;
					postNum = nums1[num1Index];
					num1Index++;
				} else {
					preNum = postNum;
					postNum = nums2[num2Index];
					num2Index++;
				}
			}

			mergeIndex++;

			if (mergeIndex == maxLength / 2 + 1)
				break;

		}

		// check if it is odd
		if ((maxLength & 1) == 1) {
			return postNum;

		} else {
			returnNum = ((double) preNum + (double) postNum) / 2;
		}

		return returnNum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = { 1, 5, 6, 6, 10 };
		int[] nums2 = { 2, 5, 7, 8, 13, 14 };

		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out
				.println(findMedianSortedArraysWithoutExtraSpace(nums1, nums2));

		nums1 = new int[] { 1, 5, 6, 9, 10 };
		nums2 = new int[] { 2, 5, 7, 8, 13, 14 };

		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out
				.println(findMedianSortedArraysWithoutExtraSpace(nums1, nums2));

		nums1 = new int[] { 1, 5, 6, 9, 10 };
		nums2 = new int[] { 2, 5, 7, 8, 13 };

		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out
				.println(findMedianSortedArraysWithoutExtraSpace(nums1, nums2));

		nums1 = new int[] { 1, 5, 6, 9, 10 };
		nums2 = new int[] { 11, 12, 13, 14, 15 };

		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out
				.println(findMedianSortedArraysWithoutExtraSpace(nums1, nums2));
	}
}
