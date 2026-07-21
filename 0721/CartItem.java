public class CartItem {
    private String id;
    private String name;
    private int price;
    private int quantity;

    public CartItem(String id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public void addQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
    }

    public int getSubtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "商品代碼: " + id + " | 名稱: " + name + " | 單價: " + price + " 元 | 數量: " + quantity + " | 小計: " + getSubtotal() + " 元";
    }
}