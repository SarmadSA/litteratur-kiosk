/**
 * Represents a magazine, holding information about the title, 
 * the publisher, the number of releases each year and the category of the newspaper.
 * 
 * @author Sarmad, Nikita and Kristin
 * @version 2018.04.13
 */
public class Magazine extends ChronicalLiterature{

    /**
     * Constructor for objects of class Magazine.
     * 
     * @param numberOfreleases the number of releases of the magazine each year
     * @param title the title of magazine
     * @param publisher the publisher of the magazine
     * @param category the category of the magazine
     * @param language the language of the magazine
     * @param dateOfRelease the date of release of the magazine
     * @param numberOfPages the number of pages of the magazine
     */
    public Magazine(int numberOfreleases, String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages) {
        super(numberOfreleases, title, publisher, category, language, dateOfRelease, numberOfPages);
    }
}
