public class BuildLinkedList {

    public static void main(String[] args) {
        IntNode node1 = new IntNode(10);
        IntNode node2 = new IntNode(20);
        IntNode node3 = new IntNode(30);
        IntNode node4 = new IntNode(40);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        IntNode head = node1;

        printList(head);
        System.out.println("總節點數 : " + countNodes(head));
        System.out.println("數值總和 : " + sumNodes(head));
    }

    public static void printList(IntNode head) {
        if (head == null) {
            System.out.println("鏈結串列為空。");
            return;
        }

        System.out.print("鏈結串列內容 : ");
        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static int countNodes(IntNode head) {
        int count = 0;
        IntNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static int sumNodes(IntNode head) {
        int sum = 0;
        IntNode current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
}