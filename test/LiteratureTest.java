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
public class LiteratureTest {
    Literature l1;
    
    public LiteratureTest(){
        
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        l1 = new Literature("Java for complete idiots", "Pearson", "Programming", "EN", "12.11.18", 76);
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
     * Test the initial constructor values (positive test).
     */
    @Test
    public void positiveConstructorTest(){
        assertEquals("Java for complete idiots",l1.getTitle());
        assertEquals("Pearson",l1.getPublisher());
        assertEquals("Programming",l1.getCategory());
        assertEquals(76,l1.getNumberOfPages());
    }
    
    /**
     * Test accessor and mutator methods of the title field (Positive test).
     */
    @Test
    public void positiveTitleTest(){
        l1.setTitle("Java objects");
        assertEquals("Java objects", l1.getTitle());
    }
    
    /**
     * Test accessor and mutator methods of the publisher field (Positive test).
     */
    @Test
    public void positivePublisherTest(){
        l1.setPublisher("p1");
        assertEquals("p1", l1.getPublisher());
    }
}
