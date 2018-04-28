import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents cart that stores literature 
 * that the user adds to his/her cart.
 * 
 * @author Sarmad, Nikita og Kristin
 * @version 2018.04.13
 */
public class Cart {
    ArrayList<Literature> cart;
    
    /**
     * Constructer of class cart.
     */
    public Cart(){
        this.cart = new ArrayList<>();
    }
    
    /**
     * Adds literature to cart
     * 
     * @param literature the literature to add to cart
     */
    public void addToCart(Literature literature){
        this.cart.add(literature);
    }
    
    /**
     * Removes literature from cart
     * 
     * @param literature the literature to remove from cart
     */
    //public void removeFromCart(Literature literature){
    //    this.cart.remove(literature);
    //}
    
    /**
     * Return iteratore of literature that is added to the cart
     * 
     * @return iteratuor of literature arraylist
     */
    public Iterator<Literature> getCartIterator(){
       return this.cart.iterator();
    }
    
        /**
     * Removes all literature that contain a given string in their title from
     * the register
     *
     * @param titleToRemove the title of the literature to remove from the register
     */
    public void removeFromCart(String titleToRemove) {
        Iterator<Literature> it = cart.iterator();
        while (it.hasNext()) {
            Literature t = it.next();
            String title = t.getTitle();
            if (title.contains(titleToRemove)) {
                it.remove();
            }
        }
    }
    
        /**
     * Searches and returns all literature that contain a given string in
     * the title.
     *
     * @param title - the title of the literature to find from the register
     * @return return the found literature that contains the given string
     */
    public Literature getLiteratureByTitle(String title) {
        Literature foundLiterature = null;
        int index = 0;
        while ((null == foundLiterature) && (index < this.cart.size())) {
            Literature p = this.cart.get(index++);
            if (p.getTitle().toLowerCase().contains(title)) {
                foundLiterature = p;
            }
        }
        return foundLiterature;
    }
}