package cn.com.liandisys.derc.LeetCode;

import org.apache.log4j.Logger;

/**
 * @author zhkai
 * @date 2021年4月13日11:35:50
 */
public class ReplaceSpace {
    public static Logger logger = Logger.getLogger(ReplaceSpace.class);

    /**
     * 测试方法
     */
    public static void replaceSpaceTest(){
        String s = "We are happy.";
        long start = System.nanoTime();
        String result = replaceSpace(s);
        logger.info(result);
        logger.info(System.nanoTime() - start + "ns");
        long startTwo = System.nanoTime();
        String resultTwo = replaceSpaceTwo(s);
        logger.info(resultTwo);
        logger.info(System.nanoTime() - startTwo);
    }

    /**
     * 把字符串 s 中的每个空格替换成"%20"。
     *
     * @param s 原字符串
     * @return 替换后字符串
     */
    public static String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    /**
     * 把字符串 s 中的每个空格替换成"%20"。
     *
     * @param s 原字符串
     * @return 替换后字符串
     */
    public static String replaceSpaceTwo(String s) {
        int sLen = s.length();
        char[] sArray = new char[sLen * 3];
        int size = 0;
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sArray[size++] = '%';
                sArray[size++] = '2';
                sArray[size++] = '0';
            } else {
                sArray[size++] = c;
            }
        }
        String newStr = new String(sArray, 0, size);
        return newStr;
    }
}
