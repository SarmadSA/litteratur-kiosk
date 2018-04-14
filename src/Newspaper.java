/**
 * Represents a single newspaper, holding information
 * about the title, the publisher, the number of releases each year and the category of the newspaper.
 * 
 * @author Sarmad, Nikita and Kristin
 * @version 2018.04.13
 */
public class Newspaper extends ChronicalLiterature{

    /**
     * Constructor for objects of class Newspaper.
     * 
     * @param numberOfreleases the number of releases of the newspaper each year
     * @param title the title of newspaper
     * @param publisher the publisher of the newspaper
     * @param category the category of the newspaper
     * @param language the language of the newspaper
     * @param dateOfRelease the date of release of the newspaper
     * @param numberOfPages the number of pages of the newspaper
     */
    public Newspaper(int numberOfreleases, String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages) {
        super(numberOfreleases, title, publisher, category, language, dateOfRelease, numberOfPages);
    }
}