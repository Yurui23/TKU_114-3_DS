public class Equipment {
    private String id;
    private String name;
    private boolean isAvailable;

    public Equipment(String id, String name) {
        this.id = id;
        this.name = name;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean borrowEquipment() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean returnEquipment() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "設備代碼: " + id + " | 名稱: " + name + " | 狀態: " + (isAvailable ? "可借用" : "已借出");
    }
}