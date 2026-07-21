import java.util.Scanner;

public class PlaylistSystem {

    private static PlaylistLinkedList playlist = new PlaylistLinkedList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = getIntInput(scanner);

            if (choice == 5) {
                System.out.println("感謝使用播放清單系統，再見！");
                break;
            }

            handleChoice(choice, scanner);
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== 音樂播放清單管理系統 ===");
        System.out.println("1. 新增歌曲至播放清單尾端");
        System.out.println("2. 依代碼搜尋歌曲");
        System.out.println("3. 依代碼刪除歌曲");
        System.out.println("4. 印出完整播放清單順序");
        System.out.println("5. 離開系統");
        System.out.print("請選擇操作 (1-5): ");
    }

    private static int getIntInput(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void handleChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                addSong(scanner);
                break;
            case 2:
                searchSong(scanner);
                break;
            case 3:
                deleteSong(scanner);
                break;
            case 4:
                playlist.displayPlaylist();
                break;
            default:
                System.out.println("無效的選擇，請輸入 1 到 5 之間的數字！");
        }
    }

    private static void addSong(Scanner scanner) {
        System.out.print("請輸入歌曲代碼: ");
        String id = scanner.nextLine();

        System.out.print("請輸入歌曲名稱: ");
        String title = scanner.nextLine();

        playlist.addLast(id, title);
    }

    private static void searchSong(Scanner scanner) {
        System.out.print("請輸入要搜尋的歌曲代碼: ");
        String id = scanner.nextLine();

        PlaylistNode node = playlist.findById(id);
        if (node != null) {
            System.out.println("找到歌曲：" + node);
        } else {
            System.out.println("找不到該代碼的歌曲！");
        }
    }

    private static void deleteSong(Scanner scanner) {
        System.out.print("請輸入要刪除的歌曲代碼: ");
        String id = scanner.nextLine();

        playlist.removeById(id);
    }
}