/**
 * Represents Chronical Literature (literaure that is
 * released constantly).
 * 
 * @author Sarmad, Nikita og Kristin
 * @version 2018.04.13
 */
public class ChronicalLiterature extends Literature {
    //Number of releases of the spesific literature each year.
    private int numberOfreleases;
    
    /**
     * Constructor for objects of class ChronicalLiterature.
     * 
     * @param numberOfreleases number of releases each year of the literature
     * @param title title of the literature
     * @param publisher publisher of the literature
     * @param category catagory of the literature
     * @param language language of the litereature
     * @param dateOfRelease date of release of the literatuere
     * @param numberOfPages number of pages of the literatuere
     */
    public ChronicalLiterature(int numberOfreleases, String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages) {
        super(title, publisher, category, language, dateOfRelease, numberOfPages);
        this.numberOfreleases = numberOfreleases;
    }

    /**
     * Changes/sets the number of releases of chronical literature 
     * that are released each year to a new number.
     * 
     * @param newNumberOfReleases - sets new number of releases
     */
    protected void setNumberOfReleases(int newNumberOfReleases){
        this.numberOfreleases = newNumberOfReleases;
    }
    
    /**
     * Returns the number of releases each year of the chronical literature 
     * 
     * @return - return number of realeses of the newspaper per year
     */
    protected int getNumberOfRealeases() {
        return this.numberOfreleases;
    }
}