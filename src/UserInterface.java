import java.util.Iterator;
import java.util.Scanner;

/**
 * Represents user interface that is responsible for 
 * the communication with the user.
 *
 * @author Sarmad, Nikita and Kristin
 * @version 2018.04.14
 */
public class UserInterface {

    private final Register register;
    private final Cart cart;
    
    /**
     * Constructor of userInterface class.
     */
    public UserInterface() {
        this.register = new Register();
        this.cart = new Cart();
    }
    
    /**
     * Starts the application.
     */
    public void start() {
        boolean finished = false;
        int choice = 0;
        
        printWelcome();
        printMenu();
        while (!finished) {
            Scanner reader = new Scanner(System.in);

            if (reader.hasNextInt()) {
                choice = reader.nextInt();
            } 
            else {
                // Set choice to an invalid value
                choice = 99;
            }
            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    fillLiteratureList();
                    break;

                // print all literature in register
                case 2:
                    viewRegister();
                    break;

                // Delete chosen literature
                case 3:
                    removeLiteratureByTitleInclude();
                    break;

                // Adde literature to register
                case 4:
                    addToRegister();
                    break;
                
                //Add to cart  
                case 5:
                    addLiteratureToCart();
                    break;
                    
                // View cart
                case 6:
                    viewCart();
                    break;                    
                    
                // Quit
                case 7:
                    printQuitMessage();
                    finished = true;
                    break;

                // default
                default:
                    System.out.println("Unknown commend");
                    break;
            }
        }
    }

    /**
     * Prints quit message.
     */
    private void printQuitMessage() {
        System.out.println("Thank you for visiting our register, Bye..");
    }

    /**
     * Removes literature with given tittle from register.
     */
    private void removeLiteratureByTitleInclude() {
        Scanner reader = new Scanner(System.in);

        Iterator<Literature> it = this.register.getLiteraureIterator();
        if (!it.hasNext()) {
            System.out.println("Register is empty! There are no literature to remove.");
        } else {
            String titleIncludes = "";
            System.out.println("Insert the title of the literature to remove:");

            if (reader.hasNext()) {
                titleIncludes = reader.next();
            }
            if (register.getLiteratureByTitle(titleIncludes) != null) {
                System.out.println(register.getLiteratureByTitle(titleIncludes).getTitle() + " Has been removed");
                register.removeByTitleContains(titleIncludes);
            } else {
                System.out.println("Invalid Literature title, ...");
            }
        }
    }
    
   /**
    * prints all avalible literature in the register.
    */
    private void viewRegister(){
        printAllLiteratureInList(this.register.getLiteraureIterator());
    }
    
   /**
    * Lists all avalible literature in the given iterator.
    */
    private void printAllLiteratureInList(Iterator iterator) {
        Iterator<Literature> it = iterator;
        if (!it.hasNext()) {
            System.out.println("Register is empty!");
        }
        while (it.hasNext()) {
            Literature literature = it.next();
            if (literature instanceof Book) {
                Book b = (Book) literature;
                System.out.println("Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n" + 
                                   "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n" + 
                                   "Date of release: " + b.getDateOfRelease() + "\n" +
                                   "Number of pages: " + b.getNumberOfPages() + "\n" + "Version: " + b.getVersion() + "\n" +
                                   "Edition: " + b.getEdition() + "\n");
            }
            else if(literature instanceof Magazine){
                Magazine b = (Magazine) literature;
                System.out.println("Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n" + 
                                   "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n" + 
                                   "Date of release: " + b.getDateOfRelease() + "\n" +
                                   "Number of pages: " + b.getNumberOfPages() + "\n" + 
                                   "Number of releases: " + b.getNumberOfRealeases() + "\n");
            }
            else if(literature instanceof Newspaper){
                Newspaper b = (Newspaper) literature;
                System.out.println("Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n" + 
                                   "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n" + 
                                   "Date of release: " + b.getDateOfRelease() + "\n" +
                                   "Number of pages: " + b.getNumberOfPages() + "\n" + 
                                   "Number of releases: " + b.getNumberOfRealeases() + "\n");
            }
            else if(literature instanceof Booklet){
                Booklet b = (Booklet) literature;
                System.out.println("Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n" + 
                                   "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n" + 
                                   "Date of release: " + b.getDateOfRelease() + "\n" +
                                   "Number of pages: " + b.getNumberOfPages() + "\n");                
            }
        }
    }

    /**
     * Fills the register with predefined literature.
     */
    private void fillLiteratureList() {
        this.register.fillLiteratureRegister();
        System.out.println("Literature register i filled with Literature");
    }

    /**
     * Prints welcome message-
     */
    private void printWelcome() {
        System.out.println("***Welocme to the Literature register!***");
    }

    /**
     * Prints menu choices.
     */
    private void printMenu() {
        System.out.println();
        System.out.println("***Menu***");
        System.out.println("Type 0 to show menu");
        System.out.println("Type 1 to fill register with Literature");
        System.out.println("Type 2 to list all available Literature");
        System.out.println("Type 3 to remove a Literature");
        System.out.println("Type 4 to add a Literature to register");
        System.out.println("Type 5 to add a Literature to cart");
        System.out.println("Type 6 to view cart");
        System.out.println("Type 7 to quit");
    }
    
    /**
     * Prints type to add menu.
     */
    private void printAddOptionsMenu() {
        System.out.print("Choose type of literature you want to add: \n 1.Book \n 2.Newspaper \n 3.Magazin \n 4.Booklet \n");
    }

    /**
     * Adds new literature of chosen type to register.
     */
    private void addToRegister(){
        printAddOptionsMenu();
        Scanner reader = new Scanner(System.in);
        int option = reader.nextInt();
        switch (option) {
            case 1:
                addBookToRegister();
                break;
            case 2:
                addNewspaperToRegister();
                break;
            case 3:
                addMagazineToRegister();
                break;            
            case 4:
                addBookletToRegister();
                break;
            default:
                System.out.println("Unknown commend");
                break;
        }
    }
    
    /**
     * Adds new book to register.
     */
    private void addBookToRegister() {
        String title; String publisher; String category; String language; String dateOfRelease; String version; String edition;int numberOfPages;
        System.out.println("To add a book to the register, you have to enter the title, "
                            + "publisher, catagory, language, date of release, number of pages, version and edition of the book.");
        Scanner reader = new Scanner(System.in);
        
        // Title
        System.out.println("1.Enter the title of the book:");
        title = reader.nextLine();
        
        // Publisher
        System.out.println("2.Enter the publisher of the book:");
        publisher = reader.nextLine();
        
        // Category
        System.out.println("3.Enter the catagory of the book:");
        category = reader.nextLine();
        
        // Language
        System.out.println("4.Enter the language of the book:");
        language = reader.nextLine();

        // Date of release
        System.out.println("5.Enter the Date of release of the book:");
        dateOfRelease = reader.nextLine();
        
        // Version
        System.out.println("6.Enter the version of the book:");
        version = reader.nextLine();
        
        // edition
        System.out.println("7.Enter the edition of the book:");
        edition = reader.nextLine();
        
        // Number of pages
        System.out.println("8.Enter number of pages of the book:");
        numberOfPages = reader.nextInt(); // use nextline and convert string to int.
        
        this.register.addLiterature(new Book(title, publisher, category, language, dateOfRelease, version, edition, numberOfPages));
        System.out.println("Book: " + title + " has been added to register!");
    }
    
        
    /**
     * Add new newspaper to the register.
     */
    private void addNewspaperToRegister(){
        String title; String publisher; int numberOfReleases; String category; String language; String dateOfRelease; int numberOfPages;
        System.out.println("To add a newspaper to the register, you have to enter the number of releases, title, "
                            + "publisher, catagory, language, date of release and number of pages of the newspaper.");
        Scanner reader = new Scanner(System.in);
        
        // Title
        System.out.println("1.Enter the title of the newspaper:");
        title = reader.nextLine();
        
        // Publisher
        System.out.println("2.Enter the publisher of the newspaper:");
        publisher = reader.nextLine();
        
        // Category
        System.out.println("3.Enter the catagory of the newspaper:");
        category = reader.nextLine();
        
        // Language
        System.out.println("4.Enter the language of the newspaper:");
        language = reader.nextLine();

        // Date of release
        System.out.println("5.Enter the Date of release of the newspaper:");
        dateOfRelease = reader.nextLine();
        
        // Number of releases
        System.out.println("6.Enter the number of releases each year of the newspaper:");
        numberOfReleases = reader.nextInt();
        
        // Number of pages
        System.out.println("7.Enter number of pages of the newspaper:");
        numberOfPages = reader.nextInt();
        
        this.register.addLiterature(new Newspaper(numberOfReleases, title, publisher, category, language, dateOfRelease, numberOfPages));
        System.out.println("Newspaper: " + title + " has been added to register!");
    }
    
    /**
     * Adds new magazine to register.
     */
    private void addMagazineToRegister(){
        String title; String publisher; int numberOfReleases; String category; String language; String dateOfRelease; int numberOfPages;
        System.out.println("To add a magazine to the register, you have to enter the number of releases, title, "
                            + "publisher, catagory, language, date of release and number of pages of the magazine.");
        Scanner reader = new Scanner(System.in);
        
        // Title
        System.out.println("1.Enter the title of the magazine:");
        title = reader.nextLine();
        
        // Publisher
        System.out.println("2.Enter the publisher of the magazine:");
        publisher = reader.nextLine();
        
        // Category
        System.out.println("3.Enter the catagory of the magazine:");
        category = reader.nextLine();
        
        // Language
        System.out.println("4.Enter the language of the magazine:");
        language = reader.nextLine();

        // Date of release
        System.out.println("5.Enter the Date of release of the magazine:");
        dateOfRelease = reader.nextLine();
        
        // Number of releases
        System.out.println("6.Enter the number of releases each year of the magazine:");
        numberOfReleases = reader.nextInt();
        
        // Number of pages
        System.out.println("7.Enter number of pages of the magazine:");
        numberOfPages = reader.nextInt();
        
        this.register.addLiterature(new Magazine(numberOfReleases, title, publisher, category, language, dateOfRelease, numberOfPages));
        System.out.println("Magazine: " + title + " has been added to register!");
    }
        
    /**
     * Adds new booklet to register.
     */
    private void addBookletToRegister(){
        String title; String publisher; String category; String language; String dateOfRelease; int numberOfPages;
        System.out.println("To add a booklet to the register, you have to enter the number of releases, title, "
                            + "publisher, catagory, language, date of release and number of pages of the booklet.");
        Scanner reader = new Scanner(System.in);
        
        // Title
        System.out.println("1.Enter the title of the booklet:");
        title = reader.nextLine();
        
        // Publisher
        System.out.println("2.Enter the publisher of the booklet:");
        publisher = reader.nextLine();
        
        // Category
        System.out.println("3.Enter the catagory of the booklet:");
        category = reader.nextLine();
        
        // Language
        System.out.println("4.Enter the language of the booklet:");
        language = reader.nextLine();

        // Date of release
        System.out.println("5.Enter the Date of release of the booklet:");
        dateOfRelease = reader.nextLine();
        
        // Number of pages
        System.out.println("6.Enter number of pages of the booklet:");
        numberOfPages = reader.nextInt();
        
        this.register.addLiterature(new Booklet(title, publisher, category, language, dateOfRelease, numberOfPages));
        System.out.println("Booklet: " + title + " has been added to register!");
    }
    
    /**
     * Adds chosen literature to cart.
     */    
    private void addLiteratureToCart() {
        Scanner reader = new Scanner(System.in);

        Iterator<Literature> it = this.register.getLiteraureIterator();
        if (!it.hasNext()) {
            System.out.println("You cant add any literature to cart because register is empty!");
        } else {
            String titleIncludes = "";
            System.out.println("Insert the title of the literature to add to cart:");

            if (reader.hasNext()) {
                titleIncludes = reader.next();
            }
            if (register.getLiteratureByTitle(titleIncludes) != null) {
                System.out.println(register.getLiteratureByTitle(titleIncludes).getTitle() + " Has been added to cart");
                cart.addToCart(register.getLiteratureByTitle(titleIncludes));
            } else {
                System.out.println("Invalid Literature title, ...");
            }
        }
    }
    
    /**
     * Lists all literature that is added to cart.
     */   
    private void viewCart() {
        printAllLiteratureInList(this.cart.getCartIterator());
    }
}
