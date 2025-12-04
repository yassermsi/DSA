//part C: Playlist Class

/*
       Yasser Al Masri - 202407061
       Abbas Othman - 202403093 
       Hasan Abdulhalim - 202400795
       Ali Sohail - 202400516
*/

import java.util.LinkedList;
import java.util.Iterator;

/**
 * The Playlist class represents a playlist in the Music Player System.
 * Each playlist is owned by a specific user and contains a list of Song
 * objects.
 *
 */
public class Playlist {
       private long playlistID; // must be a 6-digit number
       private String playlistName; // Playlist name
       private long userID; // User ID
       private LinkedList<Song> songs; // List of songs in the playlist

       /**
        * Constructs a new Playlist object with the given ID, name, and owner user ID.
        * If the Playlist ID is not exactly 6 digits, it throws an
        * IllegalArgumentException
        * If the User ID is not exactly 5 digits, it throws an IllegalArgumentException
        * 
        * @param playlistID   the Playlist ID (must be exactly 6 digits)
        * @param playlistName the name of the Playlist
        * @param userID       the ID of the user who owns this Playlist
        * @throws IllegalArgumentException if the Playlist ID is not exactly 6 digits
        *                                  or the User ID is * * not exactly 5 digits
        */
       public Playlist(long playlistID, String playlistName, long userID) {
              if (playlistID < 100000 || playlistID > 999999)
                     throw new IllegalArgumentException("Invalid Playlist ID (must be a 6-digit number)");
              else
                     this.playlistID = playlistID;
              this.playlistName = playlistName;

              if (userID >= 10000 && userID <= 99999)
                     this.userID = userID;
              else
                     throw new IllegalArgumentException("Invalid User ID (must be a 5-digit number)");

              this.songs = new LinkedList<>();
       }

       /**
        * Returns the unique ID of the playlist.
        *
        * @return the playlist ID
        */
       public long getPlaylistID() {
              return playlistID;
       }

       /**
        * Returns the name of the playlist.
        *
        * @return the playlist name
        */
       public String getPlaylistName() {
              return playlistName;
       }

       /**
        * Returns the ID of the user who owns this playlist.
        *
        * @return the user ID
        */
       public long getUserID() {
              return userID;
       }

       /**
        * Returns the list of songs in the playlist.
        *
        * @return a LinkedList of Song objects
        */
       public LinkedList<Song> getSongs() {
              return songs;
       }

       /**
        * Adds a new song to the playlist.
        * The song is added only if it does not already exist in the playlist.
        *
        * @param newSong the Song object to add
        * @return true if the song was added, false if null or already exists
        */
       public boolean addSong(Song newSong) {
              if (newSong == null)
                     return false;

              if (this.songs.contains(newSong))
                     return false;

              this.songs.add(newSong);
              return true;
       }

       /**
        * Removes a song from the playlist by its ID.
        *
        * @param songID the ID of the song to remove
        * @return true if the song was removed, false if not found
        */
       public boolean removeSong(long songID) {
              Iterator<Song> iter = songs.iterator();
              while (iter.hasNext()) {
                     Song song = iter.next();
                     if (song.getSongID() == songID) {
                            iter.remove();
                            return true;
                     }
              }
              return false;
       }

       /**
        * Prints all details of the playlist including:
        * - Playlist ID
        * - Playlist Name
        * - User ID
        * - List of songs in the playlist
        */
       public void printPlaylistDetails() {
              System.out.println("Playlist ID: " + this.playlistID);
              System.out.println("Playlist Name: " + this.playlistName);
              System.out.println("User ID: " + this.userID);
              System.out.println("Songs:");
              for (int i = 0; i < songs.size(); i++) {
                     Song song = songs.get(i);
                     song.printSongDetails();
              }
       }
}
