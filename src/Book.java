/**
 * Represents a book that holds information about the title, the publisher, 
 * the category, the language, date of release, the nuber of pages,
 * the version and the edition of the book.
 * 
 * @author Sarmad, Nikita og Kristin
 * @version 2018.04.13
 */
public class Book extends Literature{
    private boolean isSeries;
    
    /**
     * Constructor for book objects.
     * 
     * @param title title of the book
     * @param publisher publisher of the book
     * @param category catagory of the book
     * @param language language of the book
     * @param dateOfRelease date of release of the book
     * @param version version of the book
     * @param numberOfPages number of pages of the book
     * @param edition edition of the book
     */
    public Book(String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages) {
        super(title, publisher, category, language, dateOfRelease, numberOfPages);
        this.isSeries = false;
    }

    /**
     * Changes/sets the books series state to new state
     * 
     * @param state represents the books series state.
     */
    public void setSeries(boolean state){
        this.isSeries = state;
    }
    
    /**
     * Returns true if book is series, false otherwise.
     * 
     * @return the books series state.
     */
    public boolean isSeries(){
        return this.isSeries;
    }
}
