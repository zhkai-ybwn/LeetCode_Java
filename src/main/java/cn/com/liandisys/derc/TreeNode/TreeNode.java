package cn.com.liandisys.derc.TreeNode;

import lombok.Data;

/**
 * @author zhkai
 */
@Data
public class TreeNode {
    /**
     * 左节点（儿子）
     */

    private TreeNode leftTreeNode;
    /**
     * 右节点（儿子）
     */
    private TreeNode rightNode;
    /**
     * 数据
     */
    private int value;

    public TreeNode(int value) {
        this.value = value;
    }
}
