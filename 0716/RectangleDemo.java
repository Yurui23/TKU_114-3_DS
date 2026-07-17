public class RectangleDemo {
    public static void main(String[] args) {
        System.out.println("=== 開始測試矩形類別 ===\n");

        Rectangle r1 = new Rectangle(5.0, 5.0);
        printRectangleDetails("第一個矩形", r1);

        Rectangle r2 = new Rectangle(4.0, 6.0);
        printRectangleDetails("第二個矩形", r2);

        System.out.println("-> 嘗試建立 10.0 x -2.0 的矩形（測試負數防呆）:");
        Rectangle r3 = new Rectangle(10.0, -2.0);
        printRectangleDetails("第三個矩形", r3);

        System.out.println("-> 嘗試把第三個矩形的高度修改為合法的 8.0:");
        r3.setHeight(8.0);
        printRectangleDetails("修改後的第三個矩形", r3);
    }

    public static void printRectangleDetails(String label, Rectangle r) {
        System.out.println("[" + label + "] " + r); 
        System.out.printf("  > 面積: %.2f%n", r.calculateArea());
        System.out.printf("  > 周長: %.2f%n", r.calculatePerimeter());
        System.out.println("  > 是否為正方形: " + (r.isSquare() ? "是" : "否"));
        System.out.println("----------------------------------------");
    }
}