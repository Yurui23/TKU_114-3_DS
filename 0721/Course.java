public class Course {
    private String id;
    private String name;
    private int capacity;
    private int currentEnrolled;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
        this.capacity = 30;
        this.currentEnrolled = 0;
    }

    public Course(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity > 0 ? capacity : 30;
        this.currentEnrolled = 0;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentEnrolled() {
        return currentEnrolled;
    }

    public boolean isFull() {
        return currentEnrolled >= capacity;
    }

    public boolean enroll() {
        if (!isFull()) {
            currentEnrolled++;
            return true;
        }
        return false;
    }

    public boolean drop() {
        if (currentEnrolled > 0) {
            currentEnrolled--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "課程代碼: " + id + " | 名稱: " + name + " | 人數: " + currentEnrolled + "/" + capacity;
    }
}