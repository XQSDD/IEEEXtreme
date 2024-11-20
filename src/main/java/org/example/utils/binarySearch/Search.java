package org.example.utils.binarySearch;

/**
 * @author pc
 * @description 二分查找
 * 给定一个  n  个元素有序的（升序）整型数组  nums 和一个目标值  target  ，写一个函数搜索  nums  中的 target，如果目标值存在返回下标，否则返回 -1。
 * @create 2023/10/27 22:10
 */
public class Search {
    // 二分搜索最常用模板
    public int search(int[] nums, int target) {
        // 1、初始化left、right
        int left = 0;
        int right = nums.length - 1;
        // 2、处理for循环
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            // 3、比较nums[mid]和target值
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // 4、最后剩下两个元素，手动判断
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int index = search.search(nums, target);
        System.out.println(index);
    }
}
