// Part E: MusicPlayerApplication Class

/*
       Yasser Al Masri - 202407061
       Abbas Othman - 202403093 
       Hasan Abdulhalim - 202400795
       Ali Sohail - 202400516
*/

import java.util.Scanner;

/**
 * The MusicPlayerApplication class provides a menu-driven interface
 * for testing all features of the Music Manager System.
 * 
 * This class handles user interaction, menu navigation, and calls
 * the appropriate methods in the MusicManager class.
 * 
 */
public class MusicPlayerApplication {

       /**
        * Entry point of the Music Player application.
        * Displays the menu, reads user choices, and calls MusicManager methods.
        *
        * @param args command-line arguments (not used)
        */
       public static void main(String[] args) {

              Scanner scanner = new Scanner(System.in);
              MusicManager manager = new MusicManager();

              String[] menuItems = {
                            "Add Song",
                            "Delete Song",
                            "Add User",
                            "Delete User",
                            "Create Playlist",
                            "Add Song to Playlist",
                            "Remove Song from Playlist",
                            "Search Song",
                            "Print All Songs",
                            "Print User Details",
                            "Print Playlist Details",
                            "Exit"
              };

              int choice;

              do {
                     System.out.println("\n====== MUSIC PLAYER MENU ======");
                     for (int i = 0; i < menuItems.length; i++)
                            System.out.println((i + 1) + ". " + menuItems[i]);

                     System.out.print("Enter choice: ");
                     choice = scanner.nextInt();
                     scanner.nextLine();

                     switch (choice) {

                            case 1: // Add Song
                                   Song song = new Song();

                                   System.out.print("Enter Song ID (6 Digits): ");
                                   long songID = scanner.nextLong();
                                   try {
                                          song.setSongID(songID);
                                   } catch (IllegalArgumentException e) {
                                          System.out.println(e.getMessage());
                                          break;
                                   }
                                   scanner.nextLine();

                                   System.out.print("Enter title: ");
                                   String title = scanner.nextLine();
                                   song.setTitle(title);

                                   System.out.print("Enter Artist: ");
                                   String artist = scanner.nextLine();
                                   song.setArtist(artist);

                                   System.out.print("Enter Duration (minutes): ");
                                   double duration = scanner.nextDouble();
                                   try {
                                          song.setDuration(duration);
                                   } catch (IllegalArgumentException e) {
                                          System.out.println(e.getMessage());
                                          break;
                                   }

                                   if (manager.addSong(song))
                                          System.out.println("Song added successfully.");
                                   else
                                          System.out.println("Song already exists or invalid.");
                                   break;

                            case 2: // Delete Song
                                   System.out.print("Enter Song ID: ");
                                   long deleteSongID = scanner.nextLong();
                                   if (deleteSongID < 100000 || deleteSongID > 999999) {
                                          System.out.println("Invalid Song ID.");
                                          break;
                                   }

                                   if (manager.deleteSong(deleteSongID))
                                          System.out.println("Song deleted.");
                                   else
                                          System.out.println("Song not deleted (not found or used in playlists).");
                                   break;

                            case 3: // Add User
                                   User user = new User();

                                   System.out.print("Enter User ID (5 Digits): ");
                                   long userID = scanner.nextLong();
                                   try {
                                          user.setUserID(userID);
                                   } catch (IllegalArgumentException e) {
                                          System.out.println(e.getMessage());
                                          break;
                                   }
                                   scanner.nextLine();

                                   System.out.print("Enter Name: ");
                                   String name = scanner.nextLine();
                                   user.setName(name);

                                   System.out.print("Enter Email: ");
                                   String email = scanner.nextLine();
                                   try {
                                          user.setEmail(email);
                                   } catch (IllegalArgumentException e) {
                                          System.out.println(e.getMessage());
                                          break;
                                   }

                                   System.out.print("Enter subscription type: ");
                                   String type = scanner.nextLine();
                                   user.setSubscriptionType(type);

                                   if (manager.addUser(user))
                                          System.out.println("User added.");
                                   else
                                          System.out.println("User already exists or invalid.");
                                   break;

                            case 4: // Delete User
                                   System.out.print("Enter User ID: ");
                                   long deleteUserID = scanner.nextLong();
                                   if (deleteUserID < 10000 || deleteUserID > 99999) {
                                          System.out.println("Invalid User ID.");
                                          break;
                                   }

                                   if (manager.deleteUser(deleteUserID))
                                          System.out.println("User deleted.");
                                   else
                                          System.out.println("Cannot delete user (not found or owns playlists).");
                                   break;

                            case 5: // Create Playlist
                                   System.out.print("Enter Playlist ID (6 Digits): ");
                                   long playlistID = scanner.nextLong();
                                   if (playlistID < 100000 || playlistID > 999999) {
                                          System.out.println("Invalid Playlist ID.");
                                          break;
                                   }
                                   scanner.nextLine();

                                   System.out.print("Enter Playlist Name: ");
                                   String playlistName = scanner.nextLine();
                                   System.out.print("Enter Owner User ID: ");
                                   long ownerID = scanner.nextLong();
                                   if (ownerID < 10000 || ownerID > 99999) {
                                          System.out.println("Invalid User ID.");
                                          break;
                                   }

                                   Playlist playlist = new Playlist(playlistID, playlistName, ownerID);

                                   if (manager.addPlaylist(playlist))
                                          System.out.println("Playlist created.");
                                   else
                                          System.out.println("Playlist not created (duplicate ID or user missing).");
                                   break;

                            case 6: // Add Song to Playlist
                                   System.out.print("Enter Playlist ID: ");
                                   long playID = scanner.nextLong();
                                   if (playID < 100000 || playID > 999999) {
                                          System.out.println("Invalid Playlist ID.");
                                          break;
                                   }
                                   scanner.nextLine();

                                   System.out.print("Enter Song ID: ");
                                   long sID = scanner.nextLong();
                                   if (sID < 100000 || sID > 999999) {
                                          System.out.println("Invalid Song ID.");
                                          break;
                                   }

                                   Song songObj = manager.searchSong(sID);
                                   if (manager.addSongToPlaylist(playID, songObj))
                                          System.out.println("Song added to playlist.");
                                   else
                                          System.out.println(
                                                        "Cannot add song (playlist not found or song already in playlist).");
                                   break;

                            case 7: // Remove Song from Playlist
                                   System.out.print("Enter Playlist ID: ");
                                   long removePlaylistID = scanner.nextLong();
                                   if (removePlaylistID < 100000 || removePlaylistID > 999999) {
                                          System.out.println("Invalid Playlist ID.");
                                          break;
                                   }
                                   scanner.nextLine();

                                   System.out.print("Enter Song ID: ");
                                   long removeSongID = scanner.nextLong();
                                   if (removeSongID < 100000 || removeSongID > 999999) {
                                          System.out.println("Invalid Song ID.");
                                          break;
                                   }

                                   if (manager.removeSongFromPlaylist(removePlaylistID, removeSongID))
                                          System.out.println("Song removed from playlist.");
                                   else
                                          System.out.println("Cannot remove song (playlist or song not found).");
                                   break;

                            case 8: // Search Song
                                   System.out.print("Enter Song ID: ");
                                   long searchID = scanner.nextLong();
                                   if (searchID < 100000 || searchID > 999999) {
                                          System.out.println("Invalid Song ID.");
                                          break;
                                   }

                                   Song found = manager.searchSong(searchID);

                                   if (found != null)
                                          found.printSongDetails();
                                   else
                                          System.out.println("Song not found.");
                                   break;

                            case 9: // Print All Songs
                                   manager.printAllSongs();
                                   break;

                            case 10: // Print User Details
                                   manager.printUserDetails();
                                   break;

                            case 11: // Print Playlist Details
                                   System.out.print("Enter Playlist ID: ");
                                   long printPlaylistID = scanner.nextLong();
                                   if (printPlaylistID < 100000 || printPlaylistID > 999999) {
                                          System.out.println("Invalid Playlist ID.");
                                          break;
                                   }

                                   manager.printPlaylistDetails(printPlaylistID);
                                   break;

                            case 12: // Exit
                                   System.out.println("Exiting system. Goodbye!");
                                   break;

                            default:
                                   System.out.println("Invalid choice. Try again.");
                                   break;
                     }

              } while (choice != 12);

              scanner.close();
       }
}
