public class CourseInfo {

    public static void main(String[] args) {

        // 1. 宣告變數並賦予適當的初始值
        String courseName = "Programming"; 
        int credits = 3;                  
        int hours = 3;                     
        boolean required = true;           

        // 2. 輸出完整課程資訊
        System.out.println("=== Course Information ===");
        System.out.println("Course Name: " + courseName);
        System.out.println("Credits: " + credits);
        System.out.println("Hours: " + hours);
        
        System.out.println("Is Required: " + required); 
    }
}