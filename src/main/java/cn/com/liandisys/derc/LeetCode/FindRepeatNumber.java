package cn.com.liandisys.derc.LeetCode;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhkai
 * @date 2021年4月8日10:14:33
 */
public class FindRepeatNumber {
    public static Logger logger = Logger.getLogger(FindRepeatNumber.class);

    /**
     * 测试方法
     */
    public static void findRepeatNumberTest() {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        long start = System.nanoTime();
        int result = FindRepeatNumber.findRepeatNumber(nums);
        logger.info(System.nanoTime() - start + "ns");
        logger.info(result);

        long startTwo = System.nanoTime();
        int resultTwo = FindRepeatNumber.findRepeatNumberTwo(nums);
        logger.info(System.nanoTime() - startTwo);
        logger.info(resultTwo);

        long startThree = System.nanoTime();
        int resultThree = FindRepeatNumber.findRepeatNumberThree(nums);
        logger.info(System.nanoTime() - startThree);
        logger.info(resultThree);

        long startFour = System.nanoTime();
        int resultFour = FindRepeatNumber.findRepeatNumberFour(nums);
        logger.info(System.nanoTime() - startFour);
        logger.info(resultFour);

        long startFive = System.nanoTime();
        int resultFive = FindRepeatNumber.findRepeatNumberFive(nums);
        logger.info(System.nanoTime() - startFive);
        logger.info(resultFive);
    }


    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0~n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     *
     * @param nums 数组
     * @return 任意一个重复的数字
     */
    public static int findRepeatNumber(int[] nums) {
        int result = -1;
        int numsLen = nums.length;
        for (int i = 0; i < numsLen; i++) {
            for (int j = 0; j < numsLen; j++) {
                if (i != j && nums[i] == nums[j]) {
                    result = nums[i];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0~n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     *
     * @param nums 数组
     * @return 任意一个重复的数字
     */
    public static int findRepeatNumberTwo(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0~n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     *
     * @param nums 数组
     * @return 任意一个重复的数字
     */
    public static int findRepeatNumberThree(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0~n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     *
     * @param nums 数组
     * @return 任意一个重复的数字
     */
    public static int findRepeatNumberFour(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0~n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     *
     * @param nums 数组
     * @return 任意一个重复的数字
     */
    public static int findRepeatNumberFive(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[nums[i]]++;
            if (temp[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }
}
