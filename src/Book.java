/**
 * Represents a book that holds information about the title, the publisher, 
 * the category, the language, date of release, the nuber of pages,
 * the version and the edition of the book.
 * 
 * @author Sarmad, Nikita og Kristin
 * @version 2018.04.13
 */
public class Book extends Literature{
    private String version;
    private String edition;
    //private boolean isSeries;
    
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
    public Book(String title, String publisher, String category, String language, String dateOfRelease, String version, String edition,int numberOfPages) {
        super(title, publisher, category, language, dateOfRelease, numberOfPages);
        this.version = version;
        this.edition = edition;
    }
    /**
     * Returns the version of the book
     * 
     * @return the version of the book
     */
    public String getVersion() {
        return version;
    }
    
    /**
     * Changes/sets the version of book to a new version
     * 
     * @param version the new version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }
    
    /**
     * Returns the edition of the book
     * 
     * @return return the edition of the book
     */
    public String getEdition() {
        return edition;
    }
    
    /**
     * Changes/sets the edtion of book to a new edition
     * 
     * @param edition the new version to set
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }
    
    @Override
    public String toString(){
        String text = super.toString() + "Versin: " + version + "\n" + "Edition: " + edition + "\n"; 
        return text;
    }
}
