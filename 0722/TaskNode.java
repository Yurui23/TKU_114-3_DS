public class TaskNode {
    private String id;
    private String description;
    private boolean isCompleted;
    public TaskNode next;

    public TaskNode(String id, String description) {
        this.id = id;
        this.description = description;
        this.isCompleted = false;
        this.next = null;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "工作代碼: " + id + " | 說明: " + description + " | 狀態: " + (isCompleted ? "已完成" : "未完成");
    }
}