/**
 * Represents a single newspaper, holding information
 * about the title, the publisher, the number of releases each year and the category of the newspaper.
 * @author Nikita Sumahers, Sarmad Abbas and Kristin Hagen
 * @version 2018-02-12
 */
public class Newspaper extends ChronicalLiterature{

    /**
     * First Constructor for objects of class Newspaper.
     * 
     * @param title - represents title of newspaper
     * @param publisher - represents newspaper publisher name
     * @param numberOfReleases - number of realeses of newspaper per year
     * @param category - name of the category for newspaper
     */
    public Newspaper(int numberOfreleases, String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages) {
        super(numberOfreleases, title, publisher, category, language, dateOfRelease, numberOfPages);
    }
}