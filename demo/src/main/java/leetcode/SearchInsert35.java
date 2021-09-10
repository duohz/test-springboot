package com.example.rpctest.leetcode;

/**
 * @Author ex-zhoud002
 * @Date 2021/9/10 17:38
 * @Desc
 * @Ver 1.0
 **/
public class SearchInsert35 {
    public static void main(String[] args) {
        int nums[] = {1};
        int target = 0;
        System.out.println(new SearchInsert35().searchInsert(nums, target));
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: nums = [1,3,5,6], target = 0
     * 输出: 0
     * 示例 5:
     * <p>
     * 输入: nums = [1], target = 0
     * 输出: 0
     *  
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 为无重复元素的升序排列数组
     * -104 <= target <= 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];

            if (num == target) {
                return mid;
            } else if (target < num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
