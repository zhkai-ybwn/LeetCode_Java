package cn.com.liandisys.derc.LeetCode;

import cn.com.liandisys.derc.ListNode.CreateListNode;
import cn.com.liandisys.derc.ListNode.ListNode;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * @author zhkai
 * @date 2021年4月14日09:44:24
 */
public class ReversePrint {
    public static Logger logger = Logger.getLogger(ReversePrint.class);

    /**
     * 测试方法
     */
    public static void reversePrintTest() {
        int[] nums = {0, 2, 3, 1};
        ListNode nextNode = CreateListNode.createListNode(nums);
        long start = System.nanoTime();
        int[] result = reversePrint(nextNode);
        logger.info(System.nanoTime() - start);
        logger.info(Arrays.toString(result));

        long startTwo = System.nanoTime();
        int[] resultTwo = reversePrintTwo(nextNode);
        logger.info(System.nanoTime() - startTwo);
        logger.info(Arrays.toString(resultTwo));
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * @param head 链表头结点
     * @return 从尾到头反过来返回每个节点的值（用数组返回）
     */
    public static int[] reversePrint(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(size - i - 1).val;
        }
        return result;
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * @param head 链表头结点
     * @return 从尾到头反过来返回每个节点的值（用数组返回）
     */
    public static int[] reversePrintTwo(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
