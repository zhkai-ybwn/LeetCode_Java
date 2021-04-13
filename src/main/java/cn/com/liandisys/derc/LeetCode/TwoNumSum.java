package cn.com.liandisys.derc.LeetCode;

import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * @author zhkai
 * @date 2021年3月23日14:27:28
 */
public class TwoNumSum {
    private final static int NUM_NUMS = 2;
    public static Logger logger = Logger.getLogger(TwoNumSum.class);

    public static void twoNumSumTest() {
        int[] nums = {1, 3, 5, 7, 9, 12, 13, 19, 20};
        int target = 23;
        long start = System.nanoTime();
        int[] result = TwoNumSum.twoNumSum(nums, target);
        logger.info(System.nanoTime() - start + "ns");
        long startMap = System.nanoTime();
        int[] resultMap = TwoNumSum.twoNumSumMap(nums, target);
        logger.info(System.nanoTime() - startMap + "ns");
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 数组中和为目标值的两个整数的数组下标
     */
    public static int[] twoNumSum(int[] nums, int target) {
        int len = nums.length;
        if (len < NUM_NUMS) {
            return new int[0];
        }
        int[] result = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[i] = j;
                }
            }
        }
        return result;
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 数组中和为目标值的两个整数的数组下标
     */
    public static int[] twoNumSumMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(16);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
