/**
 * Represents a booklet that holds information about the title, the publisher, 
 * the category, the language, date of release, and the nuber of pages of the booklet.
 * 
 * @author Sarmad, Nikita og Kristin
 * @version 2018.04.13
 */
public class Booklet extends Literature{
    /**
     * Constructor for booklet objects.
     * 
     * @param title title of the booklet
     * @param publisher publisher of the booklet
     * @param category catagory of the booklet
     * @param language language of the booklet
     * @param dateOfRelease date of release of the booklet
     * @param numberOfPages number of pages of the booklet
     */
    public Booklet(String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages) {
        super(title, publisher, category, language, dateOfRelease, numberOfPages);
    }
}
