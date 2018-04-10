import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnite test class that tests alle constructors
 * accessor and mutator methods of Newspaper class.
 * 
 * @author Sarmad Saeed Abbas, Nikita sumahers and Kristin Hagen.
 */
public class NewspaperTest {
    
    Newspaper n1;
    
    /**
     * constructor of the newspaper test class.
     */
    public NewspaperTest() {
        
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        n1 = new Newspaper("VG", "publisher", 230, "Sport");
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
        assertEquals("VG",n1.getTitle());
        assertEquals("publisher",n1.getPublisher());
        assertEquals(230,n1.getNumberOfRealeases());
        assertEquals("Sport",n1.getCategory());
    }  
    
    /**
     * Test accessor and mutator methods of the title field (Positive test).
     */
    @Test
    public void positiveTitleTest(){
        n1.setTitle("VG Avis");
        assertEquals("VG Avis", n1.getTitle());
    }
    
    /**
     * Test accessor and mutator methods of the publisher field (Positive test).
     */
    @Test
    public void positivePublisherTest(){
        n1.setPublisher("p1");
        assertEquals("p1", n1.getPublisher());
    }
    
    /**
     * Test accessor and mutator methods of the numberOfReleases field (Positive test).
     */
    @Test
    public void positiveNumberOfRealeasesTest(){
        n1.setNumberOfReleases(100);
        assertEquals(100, n1.getNumberOfRealeases());
    }
    
    /**
     * Test accessor and mutator methods of the category field (Positive test).
     */
    @Test
    public void positiveCategoryTest(){
        n1.setCategory("Nyheter");
        assertEquals("Nyheter", n1.getCategory());
    }
    
    /**
     * Test accessor and mutator methods of the title field (Negative test).
     */
    @Test
    public void negativeTitleTest(){
        n1.setTitle("VG Avis");
        assertFalse(n1.getTitle().equals("VG"));
    }
    
    /**
     * Test accessor and mutator methods of the publisher field (Negative test).
     */
    @Test
    public void negativePublisherTest(){
        n1.setPublisher("p1");
        assertFalse(n1.getPublisher().equals("publisher"));
    }
    
    /**
     * Test accessor and mutator methods of the numberOfReleases field (Negative test).
     */
    @Test
    public void negativeNumberOfReleasesTest(){
        n1.setNumberOfReleases(100);
        assertFalse(n1.getNumberOfRealeases() == 230);
    } 
    
    /**
     * Test accessor and mutator methods of the category field (Negative test).
     */    
    @Test
    public void negativeCategoryTest(){
        n1.setCategory("Teknologi");
        assertFalse(n1.getCategory().equals("Sport"));
    } 
}