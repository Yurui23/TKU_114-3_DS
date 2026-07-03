public class ProfileCard {
    
    public static void main(String[] args) {

        // 宣告字串（String）變數，用來儲存個人資料
        String name = "Amy";                          
        String department = "Information Management"; 
        String favoriteCourse = "Programming";         

        // 使用 System.out.println() 將內容列印到螢幕上，並在結尾自動換行
        System.out.println("=== Profile ==="); 
        
        // 使用「+」符號將標題文字與變數內容串接（合併）在一起印出
        System.out.println("Name: " + name);                   
        System.out.println("Department: " + department);       
        System.out.println("Favorite Course: " + favoriteCourse); 
    }
}