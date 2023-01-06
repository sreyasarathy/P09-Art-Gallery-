//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Artwork - P09 Art Gallery
// Course: CS 300 Spring 2022
//
// Author: Sreya Sarathy 
// Email: sarathy2@wisc.edu
// Lecturer: Prof Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models an artwork piece
 * 
 * @author Sreya Sarathy
 *
 */

public class Artwork implements Comparable<Artwork> {
  private String name; // name of the artwork piece, artist
  private int year; // year in which the artwork was created
  private double cost; // cost of the artwork

  /**
   * Creates a new art piece with given attributes
   * 
   * @param name name of the artwork piece, artist
   * @param year year of creation of this artwork piece
   * @param cost the cost of this artwork piece in dollars
   * @throws an IllegalArgumentException if year is less than 1000, if cost is negative or zero or
   *            if name is null or an empty string
   */
  
  public Artwork(String name, int year, double cost) {
    // check the validity of the input parameters
	   if (year < 1000)
      throw new IllegalArgumentException("Invalid year of creation. Too old.");
    if (cost <= 0.0)
      throw new IllegalArgumentException("Invalid cost. The cost must be positive");
    if (name == null || name.isBlank())
      throw new IllegalArgumentException("Invalid artwork name");
    // assign the artwork attributes
    this.year = year;
    this.cost = cost;
    this.name = name;
  }
  /**
   * Gets the cost of this artwork
   * 
   * @return the cost of artwork
   */
  
  public double getCost() {  
    return cost;
  }
  /**
   * Gets the year when this artwork was created
   *
   * @return the year of creation of this artwork
   */
  public int getYear() {
    return year;
  }
  /**
   * Gets the name of the artwork piece, artist
   * 
   * @return the name of the artwork piece, artist
   */
  public String getName() {
    return name;
  }
  /**
   * Compares two artwork pieces for ordering with respect to their years, costs, and names
   * 
   * @return 0 if otherArtwork has the same year of creation, same name, and same cost as this
   *         artwork; an integer less then 0 if this artwork is older than the otherArtwork, or if
   *         they were created in the same year but this artwork is less expensive than the
   *         otherArtwork, or if they have the same year and the same cost and this artwork has a
   *         lower lexical order name than otherArtwork name; String comparisons are case-sensitive.
   *         otherwise returns an integer greater than 0.
   * @author sreya sarathy 

   * 
   */
  @Override
  public int compareTo(Artwork otherArtwork) {
    if (this.name.equals(otherArtwork.name) && this.year == otherArtwork.year
        && this.cost == otherArtwork.cost) {
      return 0;
    }
    if (this.cost == otherArtwork.cost && this.year == otherArtwork.year	
            && this.name.compareTo(otherArtwork.name) < 0) {
          return -1;
    } 
    if (this.year == otherArtwork.year && this.cost < otherArtwork.cost) {
      return -1;
    }
    if (this.year < otherArtwork.year) {
        return -1;
      }
    return 1;
  }
  /**
   * Checks whether this artwork equals to another object passed as input
   * 
   * @param obj other object to compare
   * @return true if obj refers to an Artwork object with the same name and year of creation
   * @author Sreya Sarathy
   */
  @Override
  public boolean equals(Object obj) {
	    if (obj.getClass().getSimpleName().equals("Artwork") && this.name.equals(((Artwork) obj).name)	
	        && this.year == ((Artwork) obj).year) {
	      return true;
	    }
	    return false; // Default return statement added to resolve compiler errors
	  }
  /**
   * Returns a String representation of the artwork attributes
   * 
   * @return the artwork as a String in the format
   */
  public String toString() {
    return "[(Name: " + name + ") (Year: " + year + ") (Cost: $" + cost + ")]";
  }
}