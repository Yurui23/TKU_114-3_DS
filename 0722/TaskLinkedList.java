public class TaskLinkedList {

    private TaskNode head;

    public TaskNode findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        TaskNode current = head;
        while (current != null) {
            if (current.getId().equalsIgnoreCase(id.trim())) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean addFirst(String id, String description) {
        if (!validateInput(id, description)) {
            return false;
        }

        TaskNode newNode = new TaskNode(id.trim(), description.trim());
        newNode.next = head;
        head = newNode;
        System.out.println("成功插隊加入【緊急工作】：" + newNode);
        return true;
    }

    public boolean addLast(String id, String description) {
        if (!validateInput(id, description)) {
            return false;
        }

        TaskNode newNode = new TaskNode(id.trim(), description.trim());
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        System.out.println("成功加入【一般工作】：" + newNode);
        return true;
    }

    private boolean validateInput(String id, String description) {
        if (id == null || id.trim().isEmpty() || description == null || description.trim().isEmpty()) {
            System.out.println("錯誤：工作代碼與說明皆不可為空白！");
            return false;
        }

        if (findById(id) != null) {
            System.out.println("錯誤：工作代碼已存在，不可重複新增！");
            return false;
        }

        return true;
    }

    public boolean markAsCompleted(String id) {
        TaskNode task = findById(id);
        if (task == null) {
            System.out.println("操作失敗：找不到該代碼的工作項目！");
            return false;
        }

        if (task.isCompleted()) {
            System.out.println("提示：該工作項目先前已經標記為完成！");
            return false;
        }

        task.setCompleted(true);
        System.out.println("成功將工作標記為完成：" + task);
        return true;
    }

    public boolean removeById(String id) {
        if (head == null) {
            System.out.println("刪除失敗：工作清單目前為空！");
            return false;
        }

        if (id == null || id.trim().isEmpty()) {
            System.out.println("錯誤：請輸入有效的工作代碼！");
            return false;
        }

        String targetId = id.trim();

        if (head.getId().equalsIgnoreCase(targetId)) {
            System.out.println("成功刪除工作：" + head);
            head = head.next;
            return true;
        }

        TaskNode current = head;
        while (current.next != null && !current.next.getId().equalsIgnoreCase(targetId)) {
            current = current.next;
        }

        if (current.next != null) {
            System.out.println("成功刪除工作：" + current.next);
            current.next = current.next.next;
            return true;
        } else {
            System.out.println("刪除失敗：找不到代碼為 " + targetId + " 的工作項目！");
            return false;
        }
    }

    public void displayUncompletedTasks() {
        System.out.println("\n--- 未完成工作清單 ---");
        if (head == null) {
            System.out.println("工作清單目前為空。");
            return;
        }

        boolean hasUncompleted = false;
        TaskNode current = head;
        while (current != null) {
            if (!current.isCompleted()) {
                System.out.println(current);
                hasUncompleted = true;
            }
            current = current.next;
        }

        if (!hasUncompleted) {
            System.out.println("太棒了！所有工作項目均已完成！");
        }
    }

    public void displayAllTasks() {
        System.out.println("\n--- 完整工作清單 ---");
        if (head == null) {
            System.out.println("工作清單目前為空。");
            return;
        }

        TaskNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void printTaskStatistics() {
        int total = 0;
        int uncompleted = 0;

        TaskNode current = head;
        while (current != null) {
            total++;
            if (!current.isCompleted()) {
                uncompleted++;
            }
            current = current.next;
        }

        System.out.println("\n=== 工作數量統計 ===");
        System.out.println("工作總數 : " + total + " 項");
        System.out.println("未完成數 : " + uncompleted + " 項");
        System.out.println("已完成數 : " + (total - uncompleted) + " 項");
    }
}