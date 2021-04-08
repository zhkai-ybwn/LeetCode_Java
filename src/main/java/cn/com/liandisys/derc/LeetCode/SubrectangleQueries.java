package cn.com.liandisys.derc.LeetCode;

/**
 * @author zhkai
 * @date 2021年4月7日09:37:05
 */
public class SubrectangleQueries {
    private int[][] rect = null;

    public SubrectangleQueries(int[][] rectangle) {
        this.rect = rectangle;
    }

    /**
     * 用 newValue 更新以(row1,col1)为左上角且以(row2,col2)为右下角的子矩形。
     *
     * @param row1     子矩形左上角行坐标
     * @param col1     子矩形左上角列坐标
     * @param row2     子矩形右下角行坐标
     * @param col2     子矩形右下角列坐标
     * @param newValue 子矩形新值
     */
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if (rect != null) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    rect[i][j] = newValue;
                }
            }
        }
    }

    /**
     * 返回矩形中坐标(row,col)的当前值。
     *
     * @param row 行坐标
     * @param col 列坐标
     * @return 当前值
     */
    public int getValue(int row, int col) {
        if (rect != null) {
            return rect[row][col];
        }
        return -1;
    }
}
