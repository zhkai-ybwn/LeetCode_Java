package cn.com.liandisys.derc.LeetCode;

import org.apache.log4j.Logger;

/**
 * @author zhkai
 * @date 2021年4月9日10:25:08
 */
public class FindNumberInTwoDimenArray {
    public static Logger logger = Logger.getLogger(FindNumberInTwoDimenArray.class);

    /**
     * 测试方法
     */
    public static void findNumberInTwoDimenArrayTest() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        long start = System.nanoTime();
        boolean result = findNumberInTwoDimenArray(matrix, target);
        logger.info(System.nanoTime() - start);
        logger.info(result);

        long startTwo = System.nanoTime();
        boolean resultTwo = findNumberInTwoDimenArrayTwo(matrix, target);
        logger.info(System.nanoTime() - startTwo);
        logger.info(resultTwo);
    }


    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param matrix 二维数组
     * @param target 整数
     * @return 二维数组中是否含有该整数
     */
    public static boolean findNumberInTwoDimenArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param matrix 二维数组
     * @param target 整数
     * @return 二维数组中是否含有该整数
     */
    public static boolean findNumberInTwoDimenArrayTwo(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
