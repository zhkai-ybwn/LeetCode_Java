package cn.com.liandisys.derc.LeetCode;

import org.apache.log4j.Logger;

/**
 * @author zhkai
 * @date 2021年3月25日09:44:06
 */
public class RemoveElement {

    public static Logger logger = Logger.getLogger(RemoveElement.class);

    /**
     * 测试方法
     */
    public static void removeElementTest() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int val = 2;
        long start = System.nanoTime();
        RemoveElement.removeElement(nums, val);
        logger.info(System.nanoTime() - start + "ns");
        long startTwo = System.nanoTime();
        RemoveElement.removeElementTwo(nums, val);
        logger.info(System.nanoTime() - startTwo + "ns");
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums 数组
     * @param val  判断值
     * @return 新数组的长度
     */
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int i = 0;
        for (i = 0; i < len; i++) {
            if (nums[i] == val) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
                len--;
            }
        }
        return i;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums 数组
     * @param val  判断值
     * @return 新数组的长度
     */
    public static int removeElementTwo(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) {
                continue;
            }
            nums[i++] = nums[j];
        }
        return i;
    }
}
