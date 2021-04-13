package cn.com.liandisys.derc.LeetCode;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @author zhkai
 * @date 2021年3月31日10:07:10
 */
public class RunningSum {
    public static Logger logger = Logger.getLogger(RunningSum.class);

    /**
     * 测试方法
     */
    public static void runningSumTest() {
        int[] nums = {1, 2, 3, 4};
        long start = System.nanoTime();
        int[] result = RunningSum.runningSum(nums);
        logger.info(System.nanoTime() - start + "ns");
        logger.info(Arrays.toString(result));
        long startTwo = System.nanoTime();
        int[] resultTwo = RunningSum.runningSumTwo(nums);
        logger.info(System.nanoTime() - startTwo);
        logger.info(Arrays.toString(resultTwo) + "ns");
        long startThree = System.nanoTime();
        int[] resultThree = RunningSum.runningSumThree(nums);
        logger.info(System.nanoTime() - startThree);
        logger.info(Arrays.toString(resultThree));
    }

    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和
     *
     * @param nums 数组
     * @return nums 的动态和
     */
    public static int[] runningSum(int[] nums) {
        int numsLen = nums.length;
        if (numsLen == 0) {
            return null;
        }
        int[] result = new int[numsLen];
        for (int i = 0; i < numsLen; i++) {
            for (int j = 0; j <= i; j++) {
                result[i] += nums[j];
            }
        }
        return result;
    }

    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和
     *
     * @param nums 数组
     * @return nums 的动态和
     */
    public static int[] runningSumTwo(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和
     *
     * @param nums 数组
     * @return nums 的动态和
     */
    public static int[] runningSumThree(int[] nums) {
        int numsLen = nums.length;
        int[] result = new int[numsLen];
        result[0] = nums[0];
        for (int i = 1; i < numsLen; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
