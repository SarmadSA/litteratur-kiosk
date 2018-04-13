public class Book extends Literature{
    private String version;
    private String edition;
    //private boolean series;

    public Book(String title, String publisher, String category, String language, String dateOfRelease, String version, String edition,int numberOfPages) {
        super(title, publisher, category, language, dateOfRelease, numberOfPages);
        this.version = version;
        this.edition = edition;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
    @Override
    public String toString(){
        String text = super.toString() + "Versin: " + version + "\n" + "Edition: " + edition + "\n"; 
        return text;
    }
}
