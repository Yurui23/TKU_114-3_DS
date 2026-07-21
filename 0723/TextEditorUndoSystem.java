import java.util.Stack;

public class TextEditorUndoSystem {

    private StringBuilder currentText;
    private Stack<String> historyStack;

    public TextEditorUndoSystem() {
        this.currentText = new StringBuilder();
        this.historyStack = new Stack<>();
    }

    public static void main(String[] args) {
        TextEditorUndoSystem editor = new TextEditorUndoSystem();

        System.out.println("=== 1. 新增文字 'Hello' ===");
        editor.type("Hello");
        editor.show();

        System.out.println("\n=== 2. 新增文字 ' World' ===");
        editor.type(" World");
        editor.show();

        System.out.println("\n=== 3. 新增文字 ' Java' ===");
        editor.type(" Java");
        editor.show();

        System.out.println("\n=== 4. 刪除最後 5 個字元 ===");
        editor.delete(5);
        editor.show();

        System.out.println("\n=== 5. 連續 Undo 第一次 (復原刪除動作) ===");
        editor.undo();
        editor.show();

        System.out.println("\n=== 6. 連續 Undo 第二次 (復原新增 ' Java') ===");
        editor.undo();
        editor.show();

        System.out.println("\n=== 7. 連續 Undo 第三次 (復原新增 ' World') ===");
        editor.undo();
        editor.show();

        System.out.println("\n=== 8. 測試過度 Undo (復原新增 'Hello') ===");
        editor.undo();
        editor.show();

        System.out.println("\n=== 9. 測試無歷史紀錄時 Undo ===");
        editor.undo();
        editor.show();
    }

    public void type(String text) {
        if (text == null || text.isEmpty()) {
            return;
        }
        saveState();
        currentText.append(text);
        System.out.println("輸入文字: \"" + text + "\"");
    }

    public void delete(int count) {
        if (count <= 0 || currentText.length() == 0) {
            return;
        }
        saveState();
        int deleteLength = Math.min(count, currentText.length());
        currentText.delete(currentText.length() - deleteLength, currentText.length());
        System.out.println("刪除最後 " + deleteLength + " 個字元");
    }

    public void undo() {
        if (historyStack.isEmpty()) {
            System.out.println("復原失敗：已無任何歷史紀錄可供 Undo！");
            return;
        }
        String previousText = historyStack.pop();
        currentText = new StringBuilder(previousText);
        System.out.println("成功執行 Undo (復原至上一次狀態)");
    }

    public void show() {
        System.out.println("當前文字內容: \"" + currentText.toString() + "\"");
    }

    private void saveState() {
        historyStack.push(currentText.toString());
    }
}