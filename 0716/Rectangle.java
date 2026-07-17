public class Rectangle {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    // Getter
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            System.out.println("錯誤：寬度必須大於 0！(設定失敗，保持原數值)");
        }
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("錯誤：高度必須大於 0！(設定失敗，保持原數值)");
        }
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return (width + height) * 2;
    }

    public boolean isSquare() {
        return width == height;
    }

    @Override
    public String toString() {
        return "矩形資訊 [寬: " + width + ", 高: " + height + "]";
    }
}