// Yasser Almasri 202407061

package LinkedLists;

public class MusicPlayer_202407061 {
       private class SongNode {
              private String title;
              private String artist;
              private SongNode next;
              public SongNode(String title, String artist) {
                     this.title = title;
                     this.artist = artist;
                     next = null;
              }
       }

       private SongNode head;
       private int size;

       public MusicPlayer_202407061() {
              head = null;
              size = 0;
       }

       public boolean isEmpty() {
              return size == 0;
       }

       public void addSong(String title, String artist) {
              SongNode newNode = new SongNode(title, artist);
              if (head == null)
                     head = newNode;
              else {
                     SongNode cur = head;
                     while (cur.next != null)
                            cur = cur.next;
                     cur.next = newNode;
              }
              size++;
       }

       public void removeSong(String title) {
              if (head == null)
                     return;
              if (head.title.equals(title)) {
                     head = head.next;
                     size--;
                     return;
              }
              else {
                     SongNode prev = head;
                     SongNode cur = head.next;
                     while (cur != null) {
                            if (cur.title.equals(title)) {
                                   prev.next = cur.next;
                                   size--;
                                   return;
                            }
                            prev = cur;
                            cur = cur.next;
                     }
              }
       }

       public String searchSong(String title) {
              if (head == null)
                     return null;
              SongNode cur = head;
              while (cur != null) {
                     if (cur.title.equals(title))
                            return cur.artist;
                     cur = cur.next;
              }
              return null;
       }

       public String get(int index) {
              if (index < 0 || index >= size)
                     return null;
              SongNode cur = head;
              for (int i = 0; i < index && cur != null; i++)
                     cur = cur.next;
              return cur.title;
       }

       public boolean compare(MusicPlayer_202407061 otherList) {
              if (this.size != otherList.size)
                     return false;
              SongNode temp1 = head;
              SongNode temp2 = otherList.head;
              while (temp1 != null && temp2 != null) {
                     if (!temp1.title.equals(temp2.title) || !temp1.artist.equals(temp2.artist))
                            return false;
                     temp1 = temp1.next;
                     temp2 = temp2.next;
              }
              return true;
       }

       public int indexOf(String title) {
              SongNode cur = head;
              int index = 0;
              while (cur != null) {
                     if (cur.title.equals(title))
                            return index;
                     cur = cur.next;
                     index++;
              }
              return -1;
       }

       public boolean contains(String title) {
              return indexOf(title) != -1;
       }

       public void clear() {
              head = null;
              size = 0;
       }

       public int size() {
              return size;
       }

       public void displayMusicPlaylist() {
              if (head == null) {
                     System.out.println("Playlist is empty.");
                     return;
              }
              SongNode cur = head;
              while (cur != null) {
                     System.out.print(cur.title);
                     if (cur.next != null)
                            System.out.print(" -> ");
                     cur = cur.next;
              }
              System.out.println(" -> null");
       }
}
