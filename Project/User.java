// Part B: User Class

/*
       Yasser Al Masri - 202407061
       Abbas Othman - 202403093 
       Hasan Abdulhalim - 202400795
       Ali Sohail - 202400516
*/

/**
 * The User class represents a user in the Music Player System.
 * Each user has a unique 5-digit ID, a name, an email address,
 * and a subscription type (e.g., Free, Premium).
 */
public class User {
       private long userID; // must be a 5-digit number
       private String name; // User name
       private String email; // must contain "@"
       private String subscriptionType; // Example: Free, Premium

       /**
        * Default constructor.
        * Initializes the user with default values.
        */
       public User() {
              this.userID = 10000;
              this.name = "";
              this.email = "";
              this.subscriptionType = "Free";
       }

       /**
        * Parameterized constructor that initializes all attributes.
        * Ensures that the User ID is 5 digits and the email contains '@'.
        *
        * @param userID           the user's ID (must be 5 digits)
        * @param name             the user's full name
        * @param email            the user's email (must contain '@')
        * @param subscriptionType the user's subscription type
        * @throws IllegalArgumentException if the User ID is not exactly 5 digits or if
        *                                  the email does not contain '@'
        */
       public User(long userID, String name, String email, String subscriptionType) {
              if (userID >= 10000 && userID <= 99999)
                     this.userID = userID;
              else
                     throw new IllegalArgumentException("Invalid User ID (must be a 5-digit number)");

              this.name = name;

              if (email != null && email.contains("@"))
                     this.email = email;
              else
                     throw new IllegalArgumentException("Invalid email (must contain '@')");

              this.subscriptionType = subscriptionType;
       }

       /**
        * Sets the user ID if it is exactly 5 digits.
        * If the User ID is not exactly 5 digits, it throws an IllegalArgumentArgument
        *
        * @param userID the new user ID
        * @throws IllegalArgumentException if the User ID is not exactly 5 digits
        */
       public void setUserID(long userID) {
              if (userID >= 10000 && userID <= 99999)
                     this.userID = userID;
              else
                     throw new IllegalArgumentException("Invalid User ID (must be a 5-digit number)");
       }

       /**
        * Sets the user's name.
        *
        * @param name the new name
        */
       public void setName(String name) {
              this.name = name;
       }

       /**
        * Sets the user's email if it contains '@'.
        * If the email does not contain '@', it throws an IllegalArgumentException
        *
        * @param email the new email
        * @throws IllegalArgumentException if the email does not contain '@'
        */
       public void setEmail(String email) {
              if (email != null && email.contains("@"))
                     this.email = email;
              else
                     throw new IllegalArgumentException("Invalid email (must contain '@')");
       }

       /**
        * Sets the user's subscription type.
        *
        * @param subscriptionType the new subscription type
        */
       public void setSubscriptionType(String subscriptionType) {
              this.subscriptionType = subscriptionType;
       }

       /**
        * Returns the user's ID.
        *
        * @return the user ID
        */
       public long getUserID() {
              return userID;
       }

       /**
        * Returns the user's name.
        *
        * @return the name
        */
       public String getName() {
              return name;
       }

       /**
        * Returns the user's email.
        *
        * @return the email
        */
       public String getEmail() {
              return email;
       }

       /**
        * Returns the user's subscription type.
        *
        * @return the subscription type
        */
       public String getSubscriptionType() {
              return subscriptionType;
       }

       /**
        * Compares this User with another User object based on userID.
        *
        * @param other the object to compare
        * @return true if both users have the same ID, false otherwise
        */
       public boolean equals(User other) {
              return other != null && this.userID == other.userID;
       }

       /**
        * Prints all user details:
        * ID, name, email, and subscription type.
        */
       public void printUserDetails() {
              System.out.println("User Details:");
              System.out.println("User ID: " + userID);
              System.out.println("Name: " + name);
              System.out.println("Email: " + email);
              System.out.println("Subscription Type: " + subscriptionType);
       }
}
