import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class
 * @author E-Dev
 */
public class Cart {
    ArrayList<Literature> cart;
    
    public Cart(){
        this.cart = new ArrayList<>();
    }
    
    public void addToCart(Literature literature){
        this.cart.add(literature);
    }
    
    public void removeFromCart(Literature literature){
        this.cart.remove(literature);
    }
    
    public Iterator<Literature> getCartIterator(){
       return this.cart.iterator();
    }
}