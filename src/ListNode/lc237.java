package ListNode;

/**
 * 删除链表中的节点
 * 先替代值，然后替代next指针
 */
public class lc237 {
    public void deleteNode(ListNode node) {
        ListNode node_copy = node.next;
        node.val = node_copy.val;
        node.next = node_copy.next;
    }
}
