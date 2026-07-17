public class ProductDemo {
    public static void main(String[] args) {
        System.out.println("=== 開始測試商品類別 ===\n");

        System.out.println("-> 1. 建立正常商品：");
        Product p1 = new Product("Switch 遊戲片", 1800, 8);
        System.out.println(p1);
        System.out.println("--------------------------------------------------");

        System.out.println("-> 2. 測試建構子防呆輸入 (名稱留白、價格是負數、庫存是負數)：");
        Product p2 = new Product("  ", -200, -5);
        System.out.println(p2);
        System.out.println("--------------------------------------------------");

        System.out.println("-> 3. 測試修改價格與進出貨功能：");
        p1.setPrice(1650);
        System.out.println("修改價格後 -> " + p1);

        p1.sell(3);
        p1.restock(5);
        p1.sell(20);
        System.out.println("--------------------------------------------------");

        System.out.println("-> 4. 測試低庫存警告：");
        Product p3 = new Product("電競滑鼠", 1200, 6);
        System.out.println(p3.getName() + " 目前是否低庫存？ " + (p3.isLowStock() ? "是，快補貨！" : "否，還充足。"));

        System.out.println("-> 賣出 4 個滑鼠...");
        p3.sell(4);
        System.out.println(p3.getName() + " 目前是否低庫存？ " + (p3.isLowStock() ? "是，快補貨！" : "否，還充足。"));
        System.out.println("--------------------------------------------------");
    }
}