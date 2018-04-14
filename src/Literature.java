/**
 * Represents a literature type and holds information about that literature including
 * the title, the publisher, the category, the language,
 * date of release and the number of pages of the literature.
 * 
 * @author Sarmad, Nikita og Kristin
 * @version 2018.04.13
 */
public class Literature {
    private String title;
    private String publisher;
    private String category;
    private String language;
    private String dateOfRelease;
    private int numberOfPages;
    
    /**
     * Constructor for literature object.
     * 
     * @param title title of the literaure
     * @param publisher publisher of the literaure
     * @param category catagory of the literaure
     * @param language language of the literaure
     * @param dateOfRelease date of release of the literaure
     * @param numberOfPages number of pages of the literaure
     */
    public Literature(String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages){
        this.title = title;
        this.publisher = publisher;
        this.category = category;
        this.language = language;
        this.dateOfRelease = dateOfRelease;
        this.numberOfPages = numberOfPages;
    }
    
    /**
     * Returns the title of the literature
     * 
     * @return return the title of the literature
     */
    protected String getTitle() {
        return title;
    }
    
    /**
     * Changes/sets the title of literature to a new title
     * 
     * @param title the new title of the literature ot set
     */
    protected void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Returns the publisher of the literature
     * 
     * @return return the publisher of the literature
     */    
    protected String getPublisher() {
        return publisher;
    }
    
    /**
     * Changes/sets the publisher of literature to a new title
     * 
     * @param publisher the new publisher of the literature ot set
     */
    protected void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    /**
     * Returns the category of the literature
     * 
     * @return return the category of the literature
     */
    protected String getCategory() {
        return category;
    }
    
    /**
     * Changes/sets the category of literature to a new title
     * 
     * @param category the new category of the literature ot set
     */
    protected void setCategory(String category) {
        this.category = category;
    }
    
    /**
     * Returns the language of the literature
     * 
     * @return return the language of the literature
     */
    protected String getLanguage() {
        return language;
    }

    /**
     * Changes/sets the language of literature to a new title
     * 
     * @param title the new language of the literature ot set
     */    
    protected void setLanguage(String language) {
        this.language = language;
    }
    
    /**
     * Returns the date of release of the literature
     * 
     * @return return the date of release of the literature
     */
    protected String getDateOfRelease() {
        return dateOfRelease;
    }

    /**
     * Changes/sets the date of release of literature to a new title
     * 
     * @param dateOfRelease the new date of release of the literature ot set
     */    
    protected void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
    
    /**
     * Returns the number of pages of the literature
     * 
     * @return return the number of pages of the literature
     */
    protected int getNumberOfPages() {
        return numberOfPages;
    }
    
    /**
     * Changes/sets the number of pages of literature to a new title
     * 
     * @param numberOfPages the new number of pages of the literature ot set
     */
    protected void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
    @Override
    public String toString(){
        String text = "Title: " + title + "\n" + "Publisher: " + publisher + "\n" + 
                      "Category: " + category + "\n" + "Language: " + language + "\n" + 
                      "Date of release: " + dateOfRelease + "\n" + "Number of pages: " + numberOfPages + "\n";
        return text;
    }
}