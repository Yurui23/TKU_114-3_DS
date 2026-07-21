import java.util.Stack;

public class BrowserUndoSystem {

    private Stack<String> history;

    public BrowserUndoSystem() {
        this.history = new Stack<>();
    }

    public static void main(String[] args) {
        BrowserUndoSystem browser = new BrowserUndoSystem();

        System.out.println("=== 測試 1: 初始狀態查看目前頁面 ===");
        browser.currentPage();

        System.out.println("\n=== 測試 2: 嘗試返回上一頁 (空堆疊) ===");
        browser.back();

        System.out.println("\n=== 測試 3: 開啟新頁面 (Google) ===");
        browser.visit("https://www.google.com");
        browser.currentPage();

        System.out.println("\n=== 測試 4: 開啟新頁面 (YouTube) ===");
        browser.visit("https://www.youtube.com");
        browser.currentPage();

        System.out.println("\n=== 測試 5: 開啟新頁面 (GitHub) ===");
        browser.visit("https://www.github.com");
        browser.currentPage();

        System.out.println("\n=== 測試 6: 返回上一頁 (從 GitHub 返回 YouTube) ===");
        browser.back();
        browser.currentPage();

        System.out.println("\n=== 測試 7: 返回上一頁 (從 YouTube 返回 Google) ===");
        browser.back();
        browser.currentPage();

        System.out.println("\n=== 測試 8: 開啟新頁面 (Wikipedia) ===");
        browser.visit("https://www.wikipedia.org");
        browser.currentPage();
    }

    public void visit(String url) {
        if (url == null || url.trim().isEmpty()) {
            System.out.println("錯誤：網址不可為空白！");
            return;
        }
        history.push(url.trim());
        System.out.println("已前往新頁面: " + url.trim());
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("操作失敗：沒有上一頁可以返回！");
            return;
        }
        String poppedUrl = history.pop();
        System.out.println("已離開頁面: " + poppedUrl);
    }

    public void currentPage() {
        if (history.isEmpty()) {
            System.out.println("目前頁面: [空白頁 / 未開啟任何網頁]");
        } else {
            System.out.println("目前頁面: " + history.peek());
        }
    }
}