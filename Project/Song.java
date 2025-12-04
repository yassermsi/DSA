// Part A: Song Class

/*
       Yasser Al Masri - 202407061
       Abbas Othman - 202403093 
       Hasan Abdulhalim - 202400795
       Ali Sohail - 202400516
*/

/**
 * The Song class represents a song in the music system.
 * Each song has a unique 6-digit ID, a title, an artist, and a duration in
 * minutes.
 */
public class Song {
       private long songID; // must be a 6-digit number
       private String title; // title of the Song
       private String artist; // artist of the Song
       private double duration; // in minutes (must be between 0 and 60)

       /**
        * Default constructor without parameters.
        * Initializes the song with default values.
        */
       public Song() {
              this.songID = 100000;
              this.title = "";
              this.artist = "";
              this.duration = 0.0;
       }

       /**
        * Constructs a Song object with the specified values.
        * If the song ID is not exactly 6 digits, it throws an IllegalArgumentException
        * If the duration is not between 0 and 60 (inclusive), it throws an
        * IllegalArgumentException.
        *
        * @param songID   the song's ID
        * @param title    the song's title
        * @param artist   the song's artist
        * @param duration the song's duration in minutes
        * @throws IllegalArgumentException if the song is not exactly 6 digits or if
        *                                  the duration is not between 0 and 60
        */
       public Song(long songID, String title, String artist, double duration) {
              if (songID < 100000 || songID > 999999)
                     throw new IllegalArgumentException("Invalid Song ID (must be a 6-digit number)");
              else
                     this.songID = songID;

              this.title = title;
              this.artist = artist;

              if (duration < 0.0 || duration > 60.0)
                     throw new IllegalArgumentException("Invalid duration (must be between 0 and 60)");
              else
                     this.duration = duration;
       }

       /**
        * Returns the song ID.
        *
        * @return the song ID
        */
       public long getSongID() {
              return songID;
       }

       /**
        * Returns the song title.
        *
        * @return the title of the song
        */
       public String getTitle() {
              return title;
       }

       /**
        * Returns the song artist.
        *
        * @return the artist of the song
        */
       public String getArtist() {
              return artist;
       }

       /**
        * Returns the song duration in minutes.
        *
        * @return the duration of the song
        */
       public double getDuration() {
              return duration;
       }

       /**
        * Sets the song ID if it is exactly 6 digits long.
        * If not, it throws an IllegalArgumentException.
        *
        * @param songID the new value of songID
        * @throws IllegalArgumentException if the songID is not exactly 6 digits
        */
       public void setSongID(long songID) {
              if (songID < 100000 || songID > 999999)
                     throw new IllegalArgumentException("Invalid Song ID (must be a 6-digit number)");
              else
                     this.songID = songID;
       }

       /**
        * Sets the song title.
        *
        * @param title the new title of the song
        */
       public void setTitle(String title) {
              this.title = title;
       }

       /**
        * Sets the song artist.
        *
        * @param artist the new artist of the song
        */
       public void setArtist(String artist) {
              this.artist = artist;
       }

       /**
        * Sets the song duration if it is between 0 and 60 (inclusive).
        * Otherwise, the duration is set to 0.0.
        *
        * @param duration the new duration in minutes
        */
       public void setDuration(double duration) {
              if (duration < 0.0 || duration > 60.0)
                     throw new IllegalArgumentException("Invalid duration (must be between 0 and 60)");
              else
                     this.duration = duration;
       }

       /**
        * Compares this song to another Song object based on song ID.
        *
        * @param other the song to be compared with
        * @return true if both songs have the same ID, false otherwise
        */
       public boolean equals(Song other) {
              // We are using boolean statements to return true or flase (logical operators)
              return other != null && this.songID == other.songID;
       }

       /**
        * Displays all the song's details:
        * ID, title, artist, and duration.
        */
       public void printSongDetails() {
              System.out.println("Song ID: " + songID);
              System.out.println("Title: " + title);
              System.out.println("Artist: " + artist);
              System.out.println("Duration: " + duration);
       }
}
