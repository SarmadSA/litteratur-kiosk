public class ChronicalLiterature extends Literature {
    private int numberOfreleases;

    public ChronicalLiterature(int numberOfreleases, String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages) {
        super(title, publisher, category, language, dateOfRelease, numberOfPages);
        this.numberOfreleases = numberOfreleases;
    }

    /**
     * Changes/sets the number of releases that are released each 
     * year to a new number.
     * 
     * @param newNumberOfReleases - sets new number of releases
     */
    protected void setNumberOfReleases(int newNumberOfReleases){
        this.numberOfreleases = newNumberOfReleases;
    }
    
    /**
     *Returns the number of releases of the newspaper each year
     * 
     * @return - return number of realeses of the newspaper per year
     */
    protected int getNumberOfRealeases() {
        return this.numberOfreleases;
    }
    
    @Override
    public String toString(){
        String text = super.toString() + "Number of releases: " + numberOfreleases + "\n"; 
        return text;
    }
}
