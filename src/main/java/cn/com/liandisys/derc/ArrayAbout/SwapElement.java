package cn.com.liandisys.derc.ArrayAbout;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhkai
 * @date 2021年3月30日14:09:29
 */
public class SwapElement {
    public static Logger logger = Logger.getLogger(SwapElement.class);

    /**
     * 测试方法
     */
    public static void swapElement() {
        int[] nums = {1, 2, 3, 4};
        long start = System.nanoTime();
        int[] resultOne = SwapElement.swapElementOne(nums, 1, 3);
        logger.info(System.nanoTime() - start + "ns");
        long startTwo = System.nanoTime();
        int[] numsTwo = {1, 2, 3, 4};
        int[] resultTwo = SwapElement.swapElementTwo(numsTwo, 1, 3);
        logger.info(System.nanoTime() - startTwo + "ns");
        long startThree = System.nanoTime();
        int[] numsThree = {1, 2, 3, 4};
        int[] resultThree = SwapElement.swapElementThree(numsThree, 1, 3);
        logger.info(System.nanoTime() - startThree + "ns");
        logger.info(Arrays.toString(resultOne));
        logger.info(Arrays.toString(resultTwo));
        logger.info(Arrays.toString(resultThree));
    }

    /**
     * 将数组下标为i和数组下标为j的两个数组元素进行交换
     *
     * @param nums 待交换数组
     * @param i    需交换下标
     * @param j    需交换下标
     * @return 交换后的数组
     */
    public static int[] swapElementOne(int[] nums, int i, int j) {
        int item = nums[i];
        nums[i] = nums[j];
        nums[j] = item;
        return nums;
    }

    /**
     * 将数组下标为i和数组下标为j的两个数组元素进行交换
     *
     * @param nums 待交换数组
     * @param i    需交换下标
     * @param j    需交换下标
     * @return 交换后的数组
     */
    public static int[] swapElementTwo(int[] nums, int i, int j) {
        List<Integer> item = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.swap(item, i, j);
        int[] result = item.stream().mapToInt(Integer::valueOf).toArray();
        return result;
    }

    /**
     * 将数组下标为i和数组下标为j的两个数组元素进行交换
     *
     * @param nums 待交换数组
     * @param i    需交换下标
     * @param j    需交换下标
     * @return 交换后的数组
     */
    public static int[] swapElementThree(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
        return nums;
    }
}
