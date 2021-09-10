package leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author ex-zhoud002
 * @Date 2021/9/10 14:24
 * @Desc 第一个错误的版本
 * @Ver 1.0
 **/
public class FirstWrongVersion {
    public static void main(String[] args) {
    }


    /**
     * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     * <p>
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * <p>
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：n = 5, bad = 4
     * 输出：4
     * 解释：
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     * 所以，4 是第一个错误的版本。
     * 示例 2：
     * <p>
     * 输入：n = 1, bad = 1
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= bad <= n <= 231 - 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-bad-version
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        //  此处可以不必进行最后一次循环
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                //  当为错误版本时，不一定能将当前位置的版本排除，可能刚好指向了第一个错误版本，排除后将无法找到第一个错误版本
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 标准解答
     *
     * @param n
     * @return
     */
    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }

    /**
     * 为了不报错，实际函数由leetcode提供
     *
     * @param n
     * @return
     */
    private boolean isBadVersion(int n) {
        return n == 3;
    }
}
