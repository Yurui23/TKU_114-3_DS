public class Product {
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "未命名商品";
            System.out.println("警告：商品名稱不可空白！已預設為 '未命名商品'。");
        } else {
            this.name = name.trim();
        }

        if (price > 0) {
            this.price = price;
        } else {
            this.price = 1;
            System.out.println("警告：商品價格必須大於 0！已強制設定為 1 元。");
        }

        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
            System.out.println("警告：庫存數量不得小於 0！已強制設定為 0。");
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("錯誤：修改價格失敗！新價格必須大於 0 元。");
        }
    }

    public void restock(int amount) {
        if (amount > 0) {
            this.stock += amount;
            System.out.println("補貨成功！" + name + " 補了 " + amount + " 個，目前庫存: " + stock);
        } else {
            System.out.println("錯誤：補貨數量必須大於 0！");
        }
    }

    public boolean sell(int amount) {
        if (amount <= 0) {
            System.out.println("錯誤：銷售數量必須大於 0！");
            return false;
        }
        if (amount > this.stock) {
            System.out.println("錯誤：庫存不足，" + name + " 剩餘 " + stock + " 個，無法賣出 " + amount + " 個。");
            return false;
        }
        this.stock -= amount;
        System.out.println("銷售成功！" + name + " 賣出 " + amount + " 個，剩餘庫存: " + stock);
        return true;
    }

    public boolean isLowStock() {
        return this.stock < 5;
    }

    public int getInventoryValue() {
        return this.price * this.stock;
    }

    @Override
    public String toString() {
        return "商品資訊 [" + name + "] | 單價: " + price + " 元 | 庫存: " + stock + " 個 | 庫存總值: " + getInventoryValue() + " 元";
    }
}