//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Art Gallery Tester - P09 Art Gallery 
// Course: CS 300 Spring 2022
//
// Author: Sreya Sarathy 
// Email: sarathy2@wisc.edu 
// Lecturer: Prof Mouna Kacem
//
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * ArtworkGallery.
 * 
 * @author sreya sarathy 
 *
 */

public class ArtGalleryTester {

  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Artwork class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
	
	public static boolean testArtworkCompareToEquals() {
	    Artwork artTester1 = new Artwork("MonaLisa", 2003, 1000000.52);
	    Artwork artTester1Equals = new Artwork("MonaLisa", 2003, 1000000.52);
	    if (artTester1.compareTo(artTester1Equals) != 0) {
	      System.out.println("Error:compareTo() method is incorrect!!");
	      return false;
	    }
	    Artwork artTester2 = new Artwork("Fake Name", 2002, 1.0);
	    if (artTester1.compareTo(artTester2) == 0) {
	      System.out.println("Error:compareTo() method is incorrect!!");
	      return false;
	    }
	    Artwork artTester3 = new Artwork("OrangeSky", 2003, 1000000.52);
	    if (artTester3.compareTo(artTester1) < 0) {
	      System.out.println("Error:compareTo() method is incorrect!!");
	      return false;
	    }
	    Artwork artTester4 = new Artwork("MagicPainting", 2003, 75);
	    Artwork artTester5 = new Artwork("MagicPainting", 2003, 25);
	    if (artTester5.compareTo(artTester4) > 0) {
	      System.out.println("Error:compareTo() method is incorrect!!");
	      return false;
	    }
	    if (!artTester1.equals(artTester1Equals)) {
	      System.out.println("Error:equals() method is not incorrect!!");
	      return false;
	    }
	    if (artTester1.equals(artTester3)) {
	      System.out.println("Error:equals() method is not incorrect!!");
	      return false;
	    }
	    return true; // if all methods works as intended, return true
	  }

  /**
   * Checks the correctness of the implementation of both addArtwork() and toString() methods
   * implemented in the ArtworkGallery class. This unit test considers at least the following
   * scenarios. (1) Create a new empty ArtworkGallery, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one artwork and then
   * check that the addArtwork() method call returns true, the tree is not empty, its size is 1, and
   * the .toString() called on the tree returns the expected output. (3) Try adding another artwork
   * which is smaller that the artwork at the root, (4) Try adding a third artwork which is greater
   * than the one at the root, (5) Try adding at least two further artwork such that one must be
   * added at the left subtree, and the other at the right subtree. For all the above scenarios, and
   * more, double check each time that size() method returns the expected value, the add method call
   * returns true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * artwork with respect to year, cost, and then name. (6) Try adding a artwork already stored in
   * the tree. Make sure that the addArtwork() method call returned false, and that the size of the
   * tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  
  public static boolean testAddArtworkToStringSize() {
// (1) Create a new empty ArtworkGallery, and check that its size is 0, it is empty,
// and that its string representation is an empty string "".
	  ArtGallery testEntireGallery = new ArtGallery(); 
	  if (!testEntireGallery.isEmpty()) {
		  System.out.println("Error: isEmpty() method is incorrect!");
		  return false;
	  }
	  if (testEntireGallery.size() != 0) {
		  System.out.println("Error: size() method is incorrect!!");
		  return false; 
	  } 
	  if (!testEntireGallery.toString().equals("")) { 
		  System.out.println("Error: equals() method is incorrect!");
		  return false; 
	  } 
	  //(2) try adding one artwork and then
	  //* check that the addArtwork() method call returns true, the tree is not empty, its size is 1, and
	  // * the .toString() called on the tree returns the expected output. 
	  
	  String name = "MonaLisa"; 
	  int year = 2003; 
	  double cost = 10.0; 
	  Artwork artTest = new Artwork(name,year,cost); 
	  if (!testEntireGallery.addArtwork(artTest)) { 
		  System.out.println("Error: addArtwork() method is incorrect!");
		  return false; 
	  } 
	  if (testEntireGallery.isEmpty()) { 
		  System.out.println("Error: isEmpty() or addArtwork() method is incorrect!");
		  return false; 
	  }
	  if (testEntireGallery.size() != 1) {
		  System.out.println("Error: size() method is incorrect!");
	      return false;
	    }
	  testEntireGallery.addArtwork(new Artwork("Circle", year - 1, cost - 1));
	    testEntireGallery.addArtwork(new Artwork("Square", year + 1, cost + 1));
	    testEntireGallery.addArtwork(new Artwork("Triangle", year - 2, cost - 2));
	    testEntireGallery.addArtwork(new Artwork("Rectangle", year + 2, cost + 2));
	    if (!testEntireGallery.toString()
	        .equals("[(Name: Triangle) (Year: 2001) (Cost: $8.0)]\n"
	        		+ "[(Name: Circle) (Year: 2002) (Cost: $9.0)]\n"
	        		+ "[(Name: MonaLisa) (Year: 2003) (Cost: $10.0)]\n"
	        		+ "[(Name: Square) (Year: 2004) (Cost: $11.0)]\n"
	        		+ "[(Name: Rectangle) (Year: 2005) (Cost: $12.0)]")){
	    	
	      System.out.println("Error: toString() method is incorrect!");
	      return false;
	    }
	    if (testEntireGallery.size() != 5) {
	      System.out.println("Error: size() method is incorrect!");
	      return false;
	    }
	    return true; // if all methods works as intended, return true
	  }

  /**
   * This method checks mainly for the correctness of the ArtworkGallery.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ArtworkGallery. Then, check
   * that calling the lookup() method on an empty ArtworkGallery returns false. (2) Consider a
   * ArtworkGallery of height 3 which lookup at least 5 artwork. Then, try to call lookup() method
   * to search for the artwork having a match at the root of the tree. (3) Then, search for a
   * artwork at the right and left subtrees at different levels considering successful and
   * unsuccessful search operations. Make sure that the lookup() method returns the expected output
   * for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  
  public static boolean testLookup() {
	    ArtGallery testEntireGallery = new ArtGallery();
	    testEntireGallery.addArtwork(new Artwork("MonaLisa", 2003, 10.0));
	    testEntireGallery.addArtwork(new Artwork("Circle", 2002, 9.0));
	    testEntireGallery.addArtwork(new Artwork("Square", 2004, 11.0));
	    testEntireGallery.addArtwork(new Artwork("Triangle", 2001, 8.0));
	    testEntireGallery.addArtwork(new Artwork("Rectangle", 2005, 12.0));
	    if (!testEntireGallery.lookup("MonaLisa", 2003, 10.0)) {
	      System.out.println("Error:lookup() method is incorrect!!");
	      return false;
	    }
	    if (!testEntireGallery.lookup("Rectangle", 2005, 12.0)) {
	      System.out.println("Error:lookup() method is incorrect!!");
	      return false;
	    }
	    return true; // Default return statement added to resolve compiler errors
	  
  } 

  /**
   * Checks for the correctness of ArtworkGallery.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty artwork tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ArtworkGallery with the following structure for instance, is 4. 
   *               (*) 
   *              /  \ 
   *            (*)  (*) 
   *             \   / \ 
   *            (*) (*) (*) 
   *                    / 
   *                   (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  
  public static boolean testHeight() {
	    ArtGallery testEntireGallery = new ArtGallery();
	    if (testEntireGallery.height() != 0) {
	      System.out.println("Error:height() method is incorrect!!");
	      return false;
	    }

	    testEntireGallery.addArtwork(new Artwork("MonaLisa", 2003, 10.0));
	    if (testEntireGallery.height() != 1) {
	      System.out.println("Error: height() method is incorrect!!");
	      return false;
	    }
	    testEntireGallery.addArtwork(new Artwork("MonaLisaVersion2", 2002, 11.0));
	    testEntireGallery.addArtwork(new Artwork("MonaLisaVersion3", 2001, 9.0));
	    testEntireGallery.addArtwork(new Artwork("MonaLisaVersion4", 2000, 8.0));

	    if (testEntireGallery.height() != 4) {
	      System.out.println("Error: height() method is incorrect!!");
	      return false;
	    }

	    return true; // Default return statement added to resolve compiler errors
	  }
  	
  /**
   * Checks for the correctness of ArtworkGallery.getBestArtwork() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  
  public static boolean testGetBestArtwork() {
	    ArtGallery testEntireGallery = new ArtGallery();
	    Artwork tester1 = new Artwork("MonaLisaVersion2", 2002, 11.0);
	    Artwork tester2 = new Artwork("MonaLisaVersion2", 2004, 15.0);
	    testEntireGallery.addArtwork(tester1);
	    testEntireGallery.addArtwork(tester2);
	    if (testEntireGallery.getBestArtwork() != tester2) {
	      System.out.println("Error: getBestArtwork() method is incorrect!!");
	      return false;
	    }
	    return true; // Default return statement added to resolve compiler errors
	  }
	  

  /**
   * Checks for the correctness of ArtworkGallery.lookupAll() method. This test must consider at
   * least 3 test scenarios. (1) Ensures that the ArtworkGallery.lookupAll() method returns an
   * empty arraylist when called on an empty tree. (2) Ensures that the
   * ArtworkGallery.lookupAll() method returns an array list which contains all the artwork satisfying
   * the search criteria of year and cost, when called on a non empty artwork tree with one match,
   * and two matches and more. Vary your search criteria such that the lookupAll() method must check
   * in left and right subtrees. (3) Ensures that the ArtworkGallery.lookupAll() method returns an
   * empty arraylist when called on a non-empty artwork tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  
  public static boolean testLookupAll() {
	    ArtGallery testEntireGallery = new ArtGallery();
	    ArrayList<Artwork> arrayListTester = new ArrayList<>();
	    ArrayList<Artwork> lookupAllTest = new ArrayList<>();
	    if (arrayListTester == testEntireGallery.lookupAll(2003, 12.0)) {
	      System.out.println("Error: lookupAll() method is incorrect!!");
	      return false;
	    }
	    Artwork givenTester = new Artwork("Given", 2000, 10.0);
	    Artwork secondArtTester = new Artwork("SecondArtTester", 2001, 11.0);
	    Artwork thirdArtTester = new Artwork("ThirdArtTester", 2002, 12.0);
	    testEntireGallery.addArtwork(givenTester);
	    testEntireGallery.addArtwork(secondArtTester);
	    testEntireGallery.addArtwork(thirdArtTester);
	    lookupAllTest.add(givenTester);
	    lookupAllTest.add(secondArtTester);
	    lookupAllTest.add(thirdArtTester);
	    if (testEntireGallery.lookupAll(2003, 12.0) == lookupAllTest) {
	      System.out.println("Error:lookupAll() method is incorrect!!");
	      return false;
	    }
	    return true; // Default return statement added to resolve compiler errors
	  }
  
  /**
   * Checks for the correctness of ArtworkGallery.buyArtwork() method. This test must consider at
   * least 3 test scenarios. (1) Buying artwork that is at leaf node (2) Buying artwork at non-leaf
   * node (3) ensures that the ArtworkGallery.buyArtwork() method throws a NoSuchElementException
   * when called on an artwork that is not present in the BST
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testBuyArtwork() {
	    try {
	      ArtGallery testEntireGallery = new ArtGallery();

	      Artwork[] testingArt = new Artwork[] {new Artwork("ArtTest1", 1870, 120),
	          new Artwork("ArtTest2", 1867, 20), new Artwork("ArtTest3", 1869, 1230),
	          new Artwork("ArtTest4", 1875, 12021), new Artwork("ArtTest5", 1872, 1260)};

	      for (Artwork artToBeAdded : testingArt) {
	        testEntireGallery.addArtwork(artToBeAdded);
	      }

	      testEntireGallery.buyArtwork("ArtTest2", 1867, 20);
	      String expected =
	          "[(Name: ArtTest3) (Year: 1869) (Cost: $1230.0)]\n[(Name: ArtTest1) (Year: 1870) (Cost: $120.0)]\n"
	          + "[(Name: ArtTest5) (Year: 1872) (Cost: $1260.0)]\n"
	          + "[(Name: ArtTest4) (Year: 1875) (Cost: $12021.0)]";
	      if (!testEntireGallery.toString().equals(expected)) {
	        return false;
	      }


	    } catch (Exception e) {
	      return false;
	    }


	    // 2.
	    ArtGallery testEntireGallery = new ArtGallery();

	    Artwork[] testingArt = new Artwork[] {new Artwork("ArtTests", 1870, 120),
	        new Artwork("ArtTests", 1867, 20), new Artwork("ArtTests", 1869, 1230),
	        new Artwork("ArtTests", 1875, 12021), new Artwork("ArtTests", 1872, 1260)};

	    for (Artwork artToBeAdded : testingArt) {
	      testEntireGallery.addArtwork(artToBeAdded);
	    }
	    testEntireGallery.buyArtwork("ArtTests", 1870, 120.0);

	    if (testEntireGallery.size() != 4) {
	      System.out.println("Error: buyArtwork() method is not correct!");
	      return false;
	    }

	    // 3.
	    boolean exception1 = false;
	    try {
	      testEntireGallery.buyArtwork("testing case", 1111, 823);
	    } catch (NoSuchElementException e) {
	      exception1 = true;
	    }

	    return exception1; // Default return statement added to resolve compiler errors

	  }
  /**
   * Returns false if any of the tester methods defined in this tester class fails.
   * 
   * @return false if any of the tester methods defined in this tester class fails, and true if all
   *         tests pass
   */
  
  public static boolean runAllTests() {
	  return testArtworkCompareToEquals() && testAddArtworkToStringSize() && testLookup() && 
			  testHeight() && testGetBestArtwork() && testLookupAll() && testBuyArtwork(); 
  } 

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  
  public static void main(String[] args) {
	    System.out.println("testArtworkCompareToEquals(): " + testArtworkCompareToEquals()); 
		System.out.println("testAddArtworkToStringSize(): " + testAddArtworkToStringSize());
	    System.out.println("testLookup(): " + testLookup());
	    System.out.println("testHeight(): " + testHeight());
	    System.out.println("testGetBestArtwork(): " + testGetBestArtwork());
	    System.out.println("testLookupAll(): " + testLookupAll());
	    System.out.println("testBuyArtwork(): " + testBuyArtwork());
	    System.out.println("runAllTests(): " + runAllTests());
	  }
	}
  
  
  
 

