package cn.com.liandisys.derc.LeetCode;

import java.util.Arrays;

/**
 * @author zhkai
 * @date 2021年4月6日11:28:27
 */
public class MaximumWealth {
    /**
     * 给你一个 m * n 的整数网格 accounts，其中 account[i][j]是第 i 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的资产总量。
     *
     * @param accounts 整数网格
     * @return 最富有客户的资产总量
     */
    public static int maxWealth(int[][] accounts) {
        int accountsLen = accounts.length;
        int sum = 0;
        int result = 0;
        for (int i = 0; i < accountsLen; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            result = Math.max(result, sum);
            sum = 0;
        }
        return result;
    }

    /**
     * 给你一个 m * n 的整数网格 accounts，其中 account[i][j]是第 i 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的资产总量。
     *
     * @param accounts 整数网格
     * @return 最富有客户的资产总量
     */
    public static int maxWealthTwo(int[][] accounts) {
        return Arrays.stream(accounts).map(ints -> Arrays.stream(ints).sum()).max(Integer::compareTo).get();
    }
}
