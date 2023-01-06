//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Art Gallery - P09 Art Gallery 
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
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * This class models the Artwork Gallery implemented as a binary search tree. The search criteria
 * include the year of creation of the artwork, the name of the artwork and its cost.
 * 
 * @author Sreya Sarathy
 *
 */
public class ArtGallery {
  // Complete the TODO tags in this source file
  private BSTNode<Artwork> root; // root node of the artwork catalog BST
  private int size; // size of the artwork catalog tree  
  /**
   * Checks whether this binary search tree (BST) is empty
   * 
   * @return true if this ArtworkGallery is empty, false otherwise
   */ 
  public boolean isEmpty() {
    return this.root == null;
  }
  /**
   * Returns the number of artwork pieces stored in this BST.
   * 
   * @return the size of this ArtworkGallery
   */
  public int size() {
    return size;
  }
  /**
   * Checks whether this ArtworkGallery contains a Artwork given its name, year, and cost.
   * 
   * @param name name of the Artwork to search
   * @param year year of creation of the Artwork to search
   * @param cost cost of the Artwork to search
   * @return true if there is a match with this Artwork in this BST, and false otherwise
   */
  public boolean lookup(String name, int year, double cost) {
	  //in this way, we can create a new artwork with the given name and year and default cost and use it 
	  // in the search operation 
    Artwork select = new Artwork(name, year, cost);
    return lookupHelper(select, this.root);
  }
  /**
   * Recursive helper method to search whether there is a match with a given Artwork in the subtree
   * rooted at current
   * @param target  a reference to a Artwork we are searching for a match in the BST rooted at
   *                current.
   * @param current "root" of the subtree we are checking whether it contains a match to target.
   * @return true if match found and false otherwise
   */
  protected static boolean lookupHelper(Artwork target, BSTNode<Artwork> current) {
	  if (current == null) 
	    	return false; 
	    Artwork x = current.getData();
	    if(target.equals(x)) return true;
	    if(target.compareTo(x) < 0) return lookupHelper(target, current.getLeft());
	    else{
	      return lookupHelper(target, current.getRight());
	    }
	  }
  /**
   * Adds a new artwork piece to this ArtworkGallery
   * 
   * @param newArtwork a new Artwork to add to this BST (gallery of artworks).
   * @return true if the newArtwork was successfully added to this gallery, and returns false if
   *         there is a match with this Artwork already stored in gallery.
   * @throws NullPointerException if newArtwork is null
   */  
  public boolean addArtwork(Artwork newArtwork) {
	    if (newArtwork == null) {
	      throw new NullPointerException("Error: newArtwork is null!!");
	    }
	    if (this.isEmpty()) {
	      this.root = new BSTNode<Artwork>(newArtwork);
	      this.size = 1;
	      return true;
	    } else if (addArtworkHelper(newArtwork, this.root)) {
	      this.size += 1;
	      return true;
	    } else {
	      return false;
	    }
	  }
  /**
   * Recursive helper method to add a new Artwork to an ArtworkGallery rooted at current.
   * 
   * @param current    The "root" of the subtree we are inserting new Artwork into.
   * @param newArtwork The Artwork to be added to a BST rooted at current.
   * @return true if the newArtwork was successfully added to this ArtworkGallery, false if a match
   *         with newArtwork is already present in the subtree rooted at current.
   */ 
  protected static boolean addArtworkHelper(Artwork newArtwork, BSTNode<Artwork> current){
    Artwork current1 = current.getData();
    if(newArtwork.equals(current1) && newArtwork.equals(current1))
    	return false;
    BSTNode<Artwork> newestNode;
    if(newArtwork.compareTo(current1) > 0){
      if(current.getRight() == null){
        newestNode = new BSTNode<Artwork>(newArtwork);
        current.setRight(newestNode);
        return true;
      }
      return addArtworkHelper(newArtwork, current.getRight());
    }else{
      if(current.getLeft() == null)
      {
        newestNode = new BSTNode<Artwork>(newArtwork);
        current.setLeft(newestNode);
        return true;
      }
      return addArtworkHelper(newArtwork, current.getLeft()); 
    }
  }
  /**
   * Gets the recent best Artwork in this BST (meaning the largest artwork in this gallery)
   * 
   * @return the best (largest) Artwork (the most recent, highest cost artwork) in this
   *         ArtworkGallery, and null if this tree is empty.
   */
  public Artwork getBestArtwork() {
    if(this.isEmpty()) 
    	return null; 
    BSTNode <Artwork> farRightNode = this.root; 
    while(farRightNode.getRight() != null){
      BSTNode <Artwork> newestNode = farRightNode.getRight();
      farRightNode = newestNode;
    }
    return farRightNode.getData(); 
  }
  /**
   * Returns a String representation of all the artwork stored within this BST in the increasing
   * order of year, separated by a newline "\n". For instance
   * 
   * "[(Name: Stars, Artist1) (Year: 1988) (Cost: $300.0)]" + "\n" + "[(Name: Sky, Artist1) (Year:
   * 2003) (Cost: $550.0)]" + "\n"
   * 
   * @return a String representation of all the artwork stored within this BST sorted in an
   *         increasing order with respect to the result of Artwork.compareTo() method (year, cost,
   *         name). Returns an empty string "" if this BST is empty.
   */

  @Override
  public String toString() {
    return toStringHelper(root).trim();
  }
  /**
   * Recursive helper method which returns a String representation of the BST rooted at current. An
   * example of the String representation of the contents of a ArtworkGallery is provided in the
   * description of the above toString() method.
   * 
   * @param current reference to the current Artwork within this BST (root of a subtree)
   * @return a String representation of all the artworks stored in the sub-tree rooted at current in
   *         increasing order with respect to the result of Artwork.compareTo() method (year, cost,
   *         name). Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Artwork> current){
    if(current == null) 
    	return "";
    String result1 = "";
    result1 = result1 + toStringHelper(current.getLeft());
    result1 += "[(Name: " + current.getData().getName() + ") (Year: " + 
            current.getData().getYear() + ") (Cost: $" + current.getData().getCost() + ")]" + "\n";
    result1 = result1 + toStringHelper(current.getRight());
    return result1;
  }

  /**
   * Computes and returns the height of this BST, counting the number of NODES from root to the
   * deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(this.root);
  }
  /**
   * Recursive helper method that computes the height of the subtree rooted at current counting the
   * number of nodes and NOT the number of edges from current to the deepest leaf
   * 
   * @param current pointer to the current BSTNode within a ArtworkGallery (root of a subtree)
   * @return height of the subtree rooted at current
   */
  protected static int heightHelper(BSTNode<Artwork> current) {
    if(current == null) 
    	return 0;
    int branchTreeOnTheLeft = heightHelper(current.getLeft()) + 1;
    int branchTreeOnTheRight = heightHelper(current.getRight()) + 1;
    return Math.max(branchTreeOnTheRight, branchTreeOnTheLeft);
  }
  /**
   * Search for all artwork objects created on a given year and have a maximum cost value.
   * 
   * @param year creation year of artwork
   * @param cost the maximum cost we would like to search for a artwork
   * @return a list of all the artwork objects whose year equals our lookup year key and maximum
   *         cost. If no artwork satisfies the lookup query, this method returns an empty arraylist
   */
  public ArrayList<Artwork> lookupAll(int year, double cost){
    return lookupAllHelper(year, cost, this.root);
  }
  /**
   * Recursive helper method to lookup the list of artworks given their year of creation and a
   * maximum value of cost
   * 
   * @param year    the year we would like to search for a artwork
   * @param cost    the maximum cost we would like to search for a artwork
   * @param current "root" of the subtree we are looking for a match to find within it.
   * @return a list of all the artwork objects whose year equals our lookup year key and maximum
   *         cost stored in the subtree rooted at current. If no artwork satisfies the lookup query,
   *         this method returns an empty arraylist
   */
  protected static ArrayList<Artwork> lookupAllHelper(int year, double cost, BSTNode<Artwork> current) {
    ArrayList<Artwork> catalogOfArt = new ArrayList<Artwork>();
    if(current == null) return catalogOfArt;
    if(lookUpConditionsHelper(year, cost, current))
    {
      if(lookUpConditionsHelper(year, cost, current.getLeft()) && (current.getLeft() != null))
        catalogOfArt.addAll(lookupAllHelper(year, cost, current.getLeft()));
      catalogOfArt.add(current.getData());
      if(lookUpConditionsHelper(year, cost, current.getRight()) && (current.getRight() != null))
        catalogOfArt.addAll(lookupAllHelper(year, cost, current.getRight()));
      else if(current.getData().getYear() > year) 
    	  catalogOfArt.addAll(lookupAllHelper(year, cost, current.getLeft()));
      else if(current.getData().getYear() < year) 
    	  catalogOfArt.addAll(lookupAllHelper(year, cost, current.getRight()));  
    } 
    return catalogOfArt;
  }
  private static boolean lookUpConditionsHelper(int year, double cost, BSTNode<Artwork> current){
   if(((current.getData().getYear() == year) 
		   && (current.getData().getCost() < cost)) 
		   || (Math.abs(current.getData().getCost() - cost) < 0.001)) 
	   return true;
   else 
	   return false;
  }
  /**
   * Buy an artwork with the specified name, year and cost. In terms of BST operation, this is
   * equivalent to finding the specific node and deleting it from the tree
   * 
   * @param name name of the artwork, artist
   * @param year creation year of artwork
   * @throws a NoSuchElementException with a descriptive error message if there is no Artwork found
   *           with the buying criteria
   */ 
  public void buyArtwork(String name, int year, double cost) {
    Artwork buyArtwork = new Artwork(name, year, cost);
    root = buyArtworkHelper(buyArtwork, root);
    size--;
  } 
  /**
   * Recursive helper method to buy artwork given the name, year and cost. In terms of BST
   * operation, this is equivalent to finding the specific node and deleting it from the tree
   * 
   * @param target  a reference to a Artwork we are searching to remove in the BST rooted at
   *                current.
   * @param current "root" of the subtree we are checking whether it contains a match to target.
   * @return the new "root" of the subtree we are checking after trying to remove target
   * @throws a NoSuchElementException with a descriptive error message if there is no Artwork found
   *           with the buying criteria in the BST rooted at current
   */
  protected static BSTNode<Artwork> buyArtworkHelper(Artwork target, BSTNode<Artwork> current) 
		  throws NoSuchElementException{
// Recurse on the left or right subtree with respect to the comparison result
// Make sure to use the output of the recursive call to appropriately set the left or the
// right child of current accordingly
// if match with target found, three cases should be considered. Feel free to organize the order
// of these cases at your choice.
// current may be a leaf (has no children), set current to null.
// current may have only one child, set current to that child (whether left or right child)
// current may have two children,
// Replace current with a new BSTNode whose data field value is the successor of target in the
// tree, and having the same left and right children as current. Notice carefully that you
// cannot
// set the data of a BSTNode.
// The successor is the smallest element at the right subtree of current
// Then, remove the successor from the right subtree. The successor must have up to one child.
// Make sure to return current (the new root to this subtree) at the end of each case or at
// the end of the method.

	  if (current == null) {
	      throw new NoSuchElementException("Error: The artwork does not exist!!");
	    }
	    Artwork recentArtwork = current.getData();
	    if (recentArtwork.compareTo(target) > 0) {
	      current.setLeft(buyArtworkHelper(target, current.getLeft()));
	    } else if (recentArtwork.compareTo(target) < 0) {
	      current.setRight(buyArtworkHelper(target, current.getRight()));
	    } else {
	      BSTNode<Artwork> nodeOnTheLeft = current.getLeft();
	      BSTNode<Artwork> nodeOnTheRight = current.getRight();
	      // recent can also be a leaf. there is a possibility 
	      if (nodeOnTheLeft == null 
	    		  && nodeOnTheRight == null) {
	        return null;
	      } else if (nodeOnTheLeft != null 
	    		  && nodeOnTheRight != null) {
	        Artwork after = getSuccessor(current);
	        return new BSTNode<Artwork>(after, null, buyArtworkHelper(after, nodeOnTheRight));
	      }
	      current = nodeOnTheLeft != null ? nodeOnTheLeft : nodeOnTheRight;
	    }
	    return current;  
	  
  }
  
	  
	  
  /**
   * Helper method to find the successor of a node while performing a delete operation (buyArtwork)
   * The successor is defined as the smallest key in the right subtree. We assume by default that
   * node is not null
   * 
   * @param node node whose successor is to be found in the tree
   * @return return the key of the successor node
   */

  protected static Artwork getSuccessor(BSTNode<Artwork> node){
	  BSTNode<Artwork> successor1 = node.getRight();
	  while (successor1.getLeft() != null){
      BSTNode<Artwork> successorLeft = successor1.getLeft();
      successor1 = successorLeft; 
    } 
    return successor1.getData();  
  }
  public static void main(String[] args) {
  }
}