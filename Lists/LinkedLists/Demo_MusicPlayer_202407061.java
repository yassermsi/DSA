// Yasser Almasri 202407061

package LinkedLists;

public class Demo_MusicPlayer_202407061 {
       public static void main(String[] args) {
              MusicPlayer_202407061 list1 = new MusicPlayer_202407061();
              System.out.println("Is List empty? " + list1.isEmpty());
              list1.addSong("Starboy", "The Weeknd");
              list1.addSong("Goosebumps", "Travis Scott");
              list1.addSong("Dreamin", "PND");
              list1.addSong("No Pole", "Don Toliver");
              list1.addSong("Ransom", "Lil Tecca");
              list1.removeSong("Dreamin");
              System.out.println("Artist of 'No Pole': " + list1.searchSong("No Pole"));
              System.out.println("Song at index 1: " + list1.get(1));
              System.out.println("Index of 'Ransom': " + list1.indexOf("Ransom"));
              System.out.println("Does 'Moonlight' exist? " + list1.contains("Moonlight"));
              System.out.println("List Size: " + list1.size());
              list1.displayMusicPlaylist();
              list1.clear();
              MusicPlayer_202407061 list2 = new MusicPlayer_202407061();
              System.out.println("Is List 1 equal to List 2? " + list1.compare(list2));
       }
}
