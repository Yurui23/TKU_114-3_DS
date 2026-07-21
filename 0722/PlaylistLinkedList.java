public class PlaylistLinkedList {

    private PlaylistNode head;

    public PlaylistNode findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        PlaylistNode current = head;
        while (current != null) {
            if (current.getId().equalsIgnoreCase(id.trim())) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean addLast(String id, String title) {
        if (id == null || id.trim().isEmpty() || title == null || title.trim().isEmpty()) {
            System.out.println("錯誤：歌曲代碼與歌名皆不可為空白！");
            return false;
        }

        if (findById(id) != null) {
            System.out.println("錯誤：歌曲代碼已存在，不可重複新增！");
            return false;
        }

        PlaylistNode newNode = new PlaylistNode(id.trim(), title.trim());

        if (head == null) {
            head = newNode;
        } else {
            PlaylistNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        System.out.println("成功加入播放清單：" + newNode);
        return true;
    }

    public boolean removeById(String id) {
        if (head == null) {
            System.out.println("刪除失敗：播放清單目前為空！");
            return false;
        }

        if (id == null || id.trim().isEmpty()) {
            System.out.println("錯誤：請輸入有效的歌曲代碼！");
            return false;
        }

        String targetId = id.trim();

        if (head.getId().equalsIgnoreCase(targetId)) {
            System.out.println("成功移除第一首歌曲：" + head);
            head = head.next;
            return true;
        }

        PlaylistNode current = head;
        while (current.next != null && !current.next.getId().equalsIgnoreCase(targetId)) {
            current = current.next;
        }

        if (current.next != null) {
            System.out.println("成功移除歌曲：" + current.next);
            current.next = current.next.next;
            return true;
        } else {
            System.out.println("刪除失敗：找不到代碼為 " + targetId + " 的歌曲！");
            return false;
        }
    }

    public void displayPlaylist() {
        System.out.println("\n--- 當前播放清單順序 ---");
        if (head == null) {
            System.out.println("播放清單為空，快新增一些好聽的歌吧！");
            return;
        }

        PlaylistNode current = head;
        int track = 1;
        while (current != null) {
            System.out.println(track + ". " + current);
            current = current.next;
            track++;
        }
    }
}