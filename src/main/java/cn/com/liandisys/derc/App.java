package cn.com.liandisys.derc;

import cn.com.liandisys.derc.ArrayAbout.SwapElement;
import cn.com.liandisys.derc.IoDiff.Bio;
import cn.com.liandisys.derc.IoDiff.Nio;
import cn.com.liandisys.derc.LeetCode.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author zhkai
 * @date 2021年3月22日11:23:08
 */
public class App {
    public static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        findRepeatNumberTest();
    }

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

    public static void firstMissingPositiveTest() {
        int[] nums = {1, 3, 6, 7, 9};
        long start = System.nanoTime();
        int result = FirstMissingPositive.firstMissingPositive(nums);
        logger.info(System.nanoTime() - start + "ns");
        long startTwo = System.nanoTime();
        int resultTwo = FirstMissingPositive.firstMissingPositiveTwo(nums);
        logger.info(System.nanoTime() - startTwo + "ns");
    }

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

    public static void maxWealthTest() {
        int[][] accounts = {{1, 2, 3}, {1, 4, 5}, {1, 4, 7}};
        long start = System.nanoTime();
        int result = MaximumWealth.maxWealth(accounts);
        logger.info(System.nanoTime() - start + "ns");
        logger.info(result);
        long startTwo = System.nanoTime();
        int resultTwo = MaximumWealth.maxWealthTwo(accounts);
        logger.info(System.nanoTime() - startTwo + "ns");
        logger.info(resultTwo);
    }

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
}
