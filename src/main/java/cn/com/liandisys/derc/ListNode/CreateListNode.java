package cn.com.liandisys.derc.ListNode;

/**
 * @author zhkai
 */
public class CreateListNode {
    public static ListNode createListNode(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return null;
        }
        // 创建首节点
        ListNode nodeSta = new ListNode(nums[0]);
        // 声明一个变量用来在移动过程中
        ListNode nextNode;
        // 指向首节点
        nextNode = nodeSta;
        // 创建链表
        for (int i = 1; i < len; i++) {
            // 生成新的节点
            ListNode node = new ListNode(nums[i]);
            // 把新的节点连接起来
            nextNode.next = node;
            // 当前节点往后移动
            nextNode = nextNode.next;
        }
        // 当for循环完成之后，nextNode指向最后一个节点
        nextNode = nodeSta;
        return nextNode;
    }
}
