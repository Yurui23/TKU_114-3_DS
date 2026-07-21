public class DeliveryTask {
    private String id;
    private String address;

    public DeliveryTask(String id, String address) {
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "任務單號: " + id + " | 配送地址: " + address;
    }
}