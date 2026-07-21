public class LinkedListReverse {

    public static void main(String[] args) {
        System.out.println("=== 1. 測試空串列反轉 ===");
        IntNode emptyHead = null;
        System.out.print("原串列 : ");
        printList(emptyHead);
        emptyHead = reverse(emptyHead);
        System.out.print("反轉後 : ");
        printList(emptyHead);

        System.out.println("\n=== 2. 測試單一節點反轉 ===");
        IntNode singleHead = new IntNode(100);
        System.out.print("原串列 : ");
        printList(singleHead);
        singleHead = reverse(singleHead);
        System.out.print("反轉後 : ");
        printList(singleHead);

        System.out.println("\n=== 3. 測試多節點反轉 ===");
        IntNode multiHead = buildSampleList();
        System.out.print("原串列 : ");
        printList(multiHead);
        multiHead = reverse(multiHead);
        System.out.print("反轉後 : ");
        printList(multiHead);
    }

    public static IntNode reverse(IntNode head) {
        IntNode prev = null;
        IntNode current = head;
        IntNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void printList(IntNode head) {
        if (head == null) {
            System.out.println("串列為空");
            return;
        }

        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    private static IntNode buildSampleList() {
        IntNode n1 = new IntNode(10);
        IntNode n2 = new IntNode(20);
        IntNode n3 = new IntNode(30);
        IntNode n4 = new IntNode(40);
        IntNode n5 = new IntNode(50);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }
}