package com.alg.reboot.add2num;

/**
 * @author chenhaowen
 * @Description: 使用链表实现加法
 * @date 2020/12/28 下午10:02
 */
public class AddTwoNum {


    /**
     * 两个数相加
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode add(ListNode l1, ListNode l2) {
        // 定义一个哑结点 目的是从第一个值开始直接取后驱就行
        ListNode result = new ListNode(0);
        // 遇10进1
        int ad = 0;
        ListNode tempNode = null;
        while (l1.next != null || l2.next != null) {
            if (null == tempNode) {
                tempNode = result;
            }
            int v1 = l1.next != null ? l1.next.value : 0;
            int v2 = l2.next != null ? l2.next.value : 0;
            int sum = v1 + v2 + ad;
            // 进位数
            ad = sum / 10;
            tempNode.next = new ListNode(sum % 10);
            tempNode = tempNode.next;
            if (null != l1.next) {
                l1 = l1.next;
            }
            if (null != l2.next) {
                l2 = l2.next;
            }
        }
        //最终超出位数
        if (ad > 0) {
            tempNode.next = new ListNode(ad);
        }
        return result;
    }

    /**
     * 打印具体数字
     * @param target
     */
    public static void print(ListNode target) {
        StringBuilder sb = null;
        StringBuilder tempSb = null;
        while (null != target.next) {
            int value = target.next.value;
            sb = new StringBuilder(value + "");
            if (null != tempSb) {
                sb = sb.append(tempSb);
            }
            target = target.next;
            tempSb = sb;
        }
        System.out.println(sb);
    }

    /**
     * build data
     * @param val
     * @return
     */
    public static ListNode buildListNode(int val) {
        String str = String.valueOf(val);
        ListNode node = new ListNode(0);
        ListNode tempNode = node;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            tempNode.next = new ListNode(Integer.parseInt(c+""));
            tempNode = tempNode.next;
        }
        return node;
    }


    /**
     * 测试具体流程
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = buildListNode(342);
        ListNode node2 = buildListNode(465);
        ListNode result = add(node, node2);
        print(result);

    }
}
