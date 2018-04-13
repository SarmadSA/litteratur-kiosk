public class Literature {
    private String title;
    private String publisher;
    private String category;
    private String language;
    private String dateOfRelease;
    private int numberOfPages;
    
    public Literature(String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages){
        this.title = title;
        this.publisher = publisher;
        this.category = category;
        this.language = language;
        this.dateOfRelease = dateOfRelease;
        this.numberOfPages = numberOfPages;
    }

    protected String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected String getPublisher() {
        return publisher;
    }

    protected void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    protected String getCategory() {
        return category;
    }

    protected void setCategory(String category) {
        this.category = category;
    }

    protected String getLanguage() {
        return language;
    }

    protected void setLanguage(String language) {
        this.language = language;
    }

    protected String getDateOfRelease() {
        return dateOfRelease;
    }

    protected void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    protected int getNumberOfPages() {
        return numberOfPages;
    }

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