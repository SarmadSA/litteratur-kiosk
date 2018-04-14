import java.util.Iterator;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnite test class that tests alle constructors
 * accessor and mutator methods of Literature class.
 * 
 * @author Sarmad Saeed Abbas, Nikita sumahers and Kristin Hagen.
 */
public class CartTest {
    Cart c1;
    
    public CartTest(){
        
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        c1 = new Cart();
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
        
    }
    
    /**
     * Test addToCart method (positive test).
     */
    @Test
    public void positiveAddToCartTest(){
        c1.addToCart(new Newspaper(12,"VG", "publisher", "Sport", "EN", "23.03.11", 23));
        Iterator<Literature> it = c1.getCartIterator();
        assertEquals(true,it.hasNext());
    }
    
    /**
     * Test addToCart method (Negative test).
     */
    @Test
    public void negativeAddToCartTest(){
        c1.addToCart(new Newspaper(12,"VG", "publisher", "Sport", "EN", "23.03.11", 23));
        Iterator<Literature> it = c1.getCartIterator();
        assertEquals(true,!it.hasNext());
    }
}
