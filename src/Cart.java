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
    public void removeFromCart(Literature literature){
        this.cart.remove(literature);
    }
    
    /**
     * Return iteratore of literature that is added to the cart
     * 
     * @return iteratuor of literature arraylist
     */
    public Iterator<Literature> getCartIterator(){
       return this.cart.iterator();
    }
}