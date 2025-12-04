// Part D MusicManager Class

/*
       Yasser Al Masri - 202407061
       Abbas Othman - 202403093 
       Hasan Abdulhalim - 202400795
       Ali Sohail - 202400516
*/

import java.util.LinkedList;
import java.util.Iterator;

/**
 * The MusicManager class manages users, songs, and playlists
 * in the Music Player System. It provides methods to add, delete,
 * search, and print details for all entities.
 */
public class MusicManager {

       private LinkedList<User> users;
       private LinkedList<Song> songs;
       private LinkedList<Playlist> playlists;

       /**
        * Default constructor.
        * Initializes the user, song, and playlist lists.
        */
       public MusicManager() {
              this.users = new LinkedList<>();
              this.songs = new LinkedList<>();
              this.playlists = new LinkedList<>();
       }

       /**
        * Adds a new song to the system if the song ID does not already exist.
        *
        * @param newSong the Song object to be added
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
        * Deletes a song from the system by its ID.
        * The song cannot be deleted if it is used in any playlist.
        *
        * @param songID the ID of the song to delete
        * @return true if the song was deleted, false if not found or used in playlists
        */
       public boolean deleteSong(long songID) {

              for (int i = 0; i < playlists.size(); i++) {
                     Playlist playlist = playlists.get(i);

                     LinkedList<Song> playlistSongs = playlist.getSongs();
                     for (int j = 0; j < playlistSongs.size(); j++) {
                            Song song = playlistSongs.get(j);
                            if (song.getSongID() == songID)
                                   return false;
                     }
              }

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
        * Adds a new user to the system if the user ID does not already exist.
        *
        * @param newUser the User object to be added
        * @return true if the user was added, false if null or already exists
        */
       public boolean addUser(User newUser) {
              if (newUser == null)
                     return false;

              if (this.users.contains(newUser))
                     return false;

              this.users.add(newUser);
              return true;
       }

       /**
        * Deletes a user from the system by ID.
        * The user cannot be deleted if they own any playlist.
        *
        * @param userID the ID of the user to delete
        * @return true if the user was deleted, false if not found or owns playlists
        */
       public boolean deleteUser(long userID) {

              for (int i = 0; i < playlists.size(); i++) {
                     Playlist playlist = playlists.get(i);
                     if (playlist.getUserID() == userID)
                            return false;
              }

              Iterator<User> iter = users.iterator();
              while (iter.hasNext()) {
                     User user = iter.next();
                     if (user.getUserID() == userID) {
                            iter.remove();
                            return true;
                     }
              }

              return false;
       }

       /**
        * Adds a new Playlist to the system.
        * Fails if the Playlist ID already exists, or the owner user does not exist.
        *
        * @param newPlaylist the Playlist to add
        * @return true if the playlist was added, false if null, already exists, or
        *         owner not found
        */
       public boolean addPlaylist(Playlist newPlaylist) {
              if (newPlaylist == null)
                     return false;

              long playlistID = newPlaylist.getPlaylistID();
              long ownerID = newPlaylist.getUserID();

              for (int i = 0; i < playlists.size(); i++) {
                     Playlist playlist = playlists.get(i);
                     if (playlist.getPlaylistID() == playlistID)
                            return false;
              }

              for (int i = 0; i < users.size(); i++) {
                     User user = users.get(i);
                     if (user.getUserID() == ownerID) {
                            playlists.add(newPlaylist);
                            return true;
                     }
              }

              return false;
       }

       /**
        * Adds a song to a specific Playlist.
        *
        * @param playlistID the ID of the playlist
        * @param newSong    the song to add
        * @return true if the song was added, false if playlist not found or song is
        *         null
        */
       public boolean addSongToPlaylist(long playlistID, Song newSong) {
              if (newSong == null)
                     return false;

              Playlist playlist = searchPlaylist(playlistID);
              if (playlist == null)
                     return false;

              return playlist.addSong(newSong);
       }

       /**
        * Removes a song from a specific Playlist.
        *
        * @param playlistID the ID of the playlist
        * @param songID     the ID of the song to remove
        * @return true if the song was removed, false if playlist not found or song not
        *         in playlist
        */
       public boolean removeSongFromPlaylist(long playlistID, long songID) {
              Playlist playlist = searchPlaylist(playlistID);
              if (playlist == null)
                     return false;

              return playlist.removeSong(songID);
       }

       /**
        * Searches for a song by its ID.
        *
        * @param songID the ID of the song to search for
        * @return the Song object if found, otherwise null
        */
       public Song searchSong(long songID) {

              for (int i = 0; i < songs.size(); i++) {
                     Song song = songs.get(i);
                     if (song.getSongID() == songID)
                            return song;
              }

              return null;
       }

       /**
        * Searches for a playlist by its ID.
        *
        * @param playlistID the ID of the playlist to search for
        * @return the Playlist object if found, otherwise null
        */
       public Playlist searchPlaylist(long playlistID) {

              for (int i = 0; i < playlists.size(); i++) {
                     Playlist playlist = playlists.get(i);
                     if (playlist.getPlaylistID() == playlistID)
                            return playlist;
              }

              return null;
       }

       /**
        * Prints details of all users in the system.
        * If there are no users, an appropriate message is displayed.
        */
       public void printUserDetails() {
              if (users.isEmpty())
                     System.out.println("No users in the system.");

              else
                     for (int i = 0; i < users.size(); i++) {
                            User user = users.get(i);
                            user.printUserDetails();
                            System.out.println("----------------------------");
                     }
       }

       /**
        * Prints details of all songs in the system.
        * If there are no songs, an appropriate message is displayed.
        */
       public void printAllSongs() {
              if (songs.isEmpty())
                     System.out.println("No songs in the system.");
              else
                     for (int i = 0; i < songs.size(); i++) {
                            Song song = songs.get(i);
                            song.printSongDetails();
                            System.out.println("----------------------------");
                     }
       }

       /**
        * Prints the details of a specific playlist and its songs.
        * If the playlist ID is not found, an appropriate message is displayed.
        *
        * @param playlistID the ID of the playlist to print
        */
       public void printPlaylistDetails(long playlistID) {
              Playlist playlist = searchPlaylist(playlistID);
              if (playlist == null)
                     System.out.println("Playlist with ID " + playlistID + " not found.");
              else
                     playlist.printPlaylistDetails();
       }

       /**
        * Checks if the system has no users, no songs, and no playlists.
        *
        * @return true if all lists are empty, false otherwise
        */
       public boolean isEmpty() {
              return users.isEmpty() && songs.isEmpty() && playlists.isEmpty();
       }

       /**
        * Prints the number of users, songs, and playlists in the system.
        */
       public void listSizes() {
              System.out.println("Number of users: " + users.size());
              System.out.println("Number of songs: " + songs.size());
              System.out.println("Number of playlists: " + playlists.size());
       }
}
