package cn.com.liandisys.derc.LeetCode;

import org.apache.log4j.Logger;

/**
 * @author zhkai
 * @date 2021年3月29日13:51:23
 */
public class FirstMissingPositive {

    public static Logger logger = Logger.getLogger(FirstMissingPositive.class);

    /**
     * 测试方法
     */
    public static void firstMissingPositiveTest() {
        int[] nums = {1, 3, 6, 7, 9};
        long start = System.nanoTime();
        int result = FirstMissingPositive.firstMissingPositive(nums);
        logger.info(System.nanoTime() - start + "ns");
        long startTwo = System.nanoTime();
        int resultTwo = FirstMissingPositive.firstMissingPositiveTwo(nums);
        logger.info(System.nanoTime() - startTwo + "ns");
    }

    /**
     * 给你一个未排序的整数数组 nums，请你找出其中没有出现的最小的正整数
     *
     * @param nums 未排序的整数数组 nums
     * @return 没有出现的最小的正整数
     */
    public static int firstMissingPositive(int[] nums) {
        int numsLen = nums.length;
        if (numsLen == 0) {
            return 1;
        }
        int[] res = new int[numsLen + 1];
        int resLen = res.length;
        for (int x : nums) {
            if (x > 0 && x < resLen) {
                res[x] = x;
            }
        }
        for (int i = 1; i < resLen; i++) {
            if (i != res[i]) {
                return i;
            }
        }
        return resLen;
    }

    /**
     * 给你一个未排序的整数数组 nums，请你找出其中没有出现的最小的正整数
     *
     * @param nums 未排序的整数数组 nums
     * @return 没有出现的最小的正整数
     */
    public static int firstMissingPositiveTwo(int[] nums) {
        int numsLen = nums.length;
        if (numsLen == 0) {
            return 1;
        }
        for (int i = 0; i < numsLen; i++) {
            while (nums[i] > 0 && nums[i] < numsLen + 1 && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < numsLen; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return numsLen + 1;
    }

    /**
     * 交换数组元素位置
     *
     * @param nums 未排序的整数数组 nums
     * @param i    需交换元素数组index
     * @param j    与需交换元素进行交换的数组index
     */
    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[j] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
