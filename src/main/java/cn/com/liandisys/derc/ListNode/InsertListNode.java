package cn.com.liandisys.derc.ListNode;

/**
 * @author zhkai
 */
public class InsertListNode {
    public static void insertListNode(int val, int num) {
        int[] nums = {1, 2, 3};
        // 创建链表
        ListNode node = CreateListNode.createListNode(nums);
        while (node != null) {
            if (node.val == val) {
                // 生成新的节点
                ListNode newNode = new ListNode(num);
                // 先保存下一个节点
                ListNode nextNode = node.next;
                // 插入新节点
                node.next = nextNode;
                // 新节点的下一个节点指向之前保存的节点
                newNode.next = nextNode;
            }
            node = node.next;
        }
        // 循环完成后node指向最后一个节点
    }
}
