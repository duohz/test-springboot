package leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc 二分查找
 * @Author zhoud
 * @Date 2021/9/9 20:57
 **/
@Slf4j
public class EFCZ704 {

    public static void main(String[] args) {
        int nums[] = {-1, 0, 3, 5, 9, 12};
        int target = 2;

        log.info("response:" + new EFCZ704().search2(nums, target));
        log.info("response:" + new EFCZ704().search(nums, target));

        boolean res = ((5 - 1) / 2 + 1) == (5 / 2 + 1 / 2);
        log.info("(a-b)/2+b==a/2+b/2?");
    }

    /**
     * 错误1
     * 直接相加后做除法可能会出现left和right紧邻的情况，会死循环
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int count = 0;
        while (left <= right) {
            count++;
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                System.out.println("总共循环次数：" + count);
                return mid;
            } else if (target > nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return -1;
    }

    /**
     * 修复错误1
     * <p>
     * 错误2
     * left<right-1作为循环条件的入口，会遗漏[1]和[1,2]的情况
     *
     * @param nums
     * @param target
     * @return
     */
    public int search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int count = 0;
        while (left < right - 1) {
            count++;
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                System.out.println("总共循环次数：" + count);
                return mid;
            } else if (target > nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return -1;
    }

    /**
     * 修复错误2
     * <p>
     * 错误3
     * mid=(left+right)/2 取中位数会有偏差 如果两个都不能整除，会导致最后的结果+1，漏掉一个数
     *
     * @param nums
     * @param target
     * @return
     */
    public int search4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) {
            if (target == nums[0]) {
                return 0;
            } else {
                return -1;
            }
        }

        if (nums.length == 2) {
            if (target == nums[0]) {
                return 0;
            } else if (target == nums[1]) {
                return 1;
            } else {
                return -1;
            }
        }

        int count = 0;
        while (left < right - 1) {
            count++;
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                System.out.println("总共循环次数：" + count);
                return mid;
            } else if (target > nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return -1;
    }

    /**
     * 修复错误3
     *
     * @param nums
     * @param target
     * @return
     */
    public int search5(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int count = 0;
        while (left <= right) {
            count++;
            int mid = left / 2 + right / 2;
            if (target == nums[mid]) {
                System.out.println("总共循环次数：" + count);
                return mid;
            } else if (target > nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return -1;
    }

    /**
     * 标准解答
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            //  中位数计算，要考虑Integer的进位问题
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                //  缩小无效计算范围
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
