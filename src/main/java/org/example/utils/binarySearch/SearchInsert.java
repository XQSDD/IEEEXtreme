package org.example.utils.binarySearch;

/**
 * @author pc
 * @description 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @create 2023/10/27 22:11
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        // 思路：找到第一个 >= target 的元素位置
        int left = 0;
        int right = nums.length - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] >= target) {
            return left;
        } else if (nums[left] < target && target <= nums[right]) {
            return left + 1;
        } else {
            // 目标值比所有值都大
            return right + 1;
        }
    }

    public static void main(String[] args) {

    }
}
