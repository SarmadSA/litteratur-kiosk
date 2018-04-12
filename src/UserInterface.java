import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Represents user interface
 *
 * @author Nikita Sumahers, Sarmad Abbas and Kristin Hagen
 * @version 2018-03-09
 */
public class UserInterface {

    private Register register;

    public UserInterface() {
        this.register = new Register();
    }

    public void start() {
        boolean finished = false;

        int choice = 0;

        printWelcome();
        printMenu();
        while (!finished) {
            Scanner reader = new Scanner(System.in);

            if (reader.hasNextInt()) {
                choice = reader.nextInt();
            } else {
                // Set choice to an invalid value
                choice = 99;
            }

            // Fill newspaper with predefined newspapers
            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    fillLiteratureList();
                    break;

                // Get all registered newspapers displayed
                case 2:
                    listAllLiterature();
                    break;

                // List all avalible books
                case 3:
                    listAllOfType("Book");
                    break;

                // List all avalible books
                case 4:
                    listAllOfType("Newspaper");
                    break;

                // List all avalible books
                case 5:
                    listAllOfType("Magazine");
                    break;

                // List all avalible books
                case 6:
                    listAllOfType("Booklet");
                    break;

                // Delete chosen newspaper
                case 7:
                    removeLiteratureByTitleInclude();
                    break;

                // Adde to literature to register
                case 8:
                    addToRegister();
                    break;

                // Quit
                case 9:
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
     * Quit message
     */
    private void printQuitMessage() {
        System.out.println("Thank you for visiting our register, Bye..");
    }

    /**
     * removes newspapwer if given word is in a title of newspaper
     */
    private void removeLiteratureByTitleInclude() {

        int choice = 0;
        Scanner reader = new Scanner(System.in);

        Iterator<Literature> it = this.register.getIterator();
        if (!it.hasNext()) {
            System.out.println("Register is empty!");
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
                choice = 3;
            }
        }
    }

    /**
     * Prints all newspapers registered in the register
     */
    private void listAllLiterature() {
        Iterator<Literature> it = this.register.getIterator();
        if (!it.hasNext()) {
            System.out.println("Register is empty!");
        }
        while (it.hasNext()) {
            Literature literature = it.next();
            System.out.print(literature);
            System.out.println();
        }
    }

    private void listAllOfType(String type) {
        int numberOfObjectsFound = 0;
        Iterator<Literature> it = this.register.getIterator();
        while (it.hasNext()) {
            Literature literature = it.next();
            if (type.equals("Book") && literature instanceof Book) {
                System.out.println(literature);
                numberOfObjectsFound++;
            }
            else if(type.equals("Magazine") && literature instanceof Magazine){
                System.out.println(literature);
                numberOfObjectsFound++;                
            }
            else if(type.equals("Newspaper") && literature instanceof Newspaper){
                System.out.println(literature);
                numberOfObjectsFound++;                
            }
            else if(type.equals("Booklet") && literature instanceof Booklet){
                System.out.println(literature);
                numberOfObjectsFound++;                
            }
        }
        if (numberOfObjectsFound == 0) {
            System.out.println("None found!");
        }
    }

    /**
     * Fills the register with predefined literature
     */
    private void fillLiteratureList() {
        this.register.fillLiteratureRegister();
        System.out.println("Literature register i filled with Literature");
    }

    /**
     * Print welcome message
     */
    private void printWelcome() {
        System.out.println("***Welocme to the Literature register!***");
    }

    /**
     * Print menu choices
     */
    private void printMenu() {
        System.out.println();
        System.out.println("***Menu***");
        System.out.println("Type 0 to show menu");
        System.out.println("Type 1 to fill register with Literature");
        System.out.println("Type 2 to list all available Literature");
        System.out.println("Type 3 to list all available books");
        System.out.println("Type 4 to list all available Newspaper");
        System.out.println("Type 5 to list all available Magazines");
        System.out.println("Type 6 to list all available Booklets");
        System.out.println("Type 7 to remove a Literature");
        System.out.println("Type 8 to add a Literature to register");
        System.out.println("Type 9 to quit");
    }

    private void printAddOptionsMenu() {
        System.out.print("Choose type of literature you want to add: \n 1.Book \n 2.Newspaper \n 3.Magazin \n 4.Booklet \n");
    }

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
    
//    private void addLiteraturet(){
//        HashMap<String, String> parameter = new HashMap<>();
//        parameter.put("title", "1.Enter the title of the booklet:");
//        parameter.put("publisher", "2.Enter the publisher of the booklet:");
//        parameter.put("category", "3.Enter the catagory of the booklet:");
//        parameter.put("language", "4.Enter the language of the booklet:");
//        parameter.put("date", "5.Enter the Date of release of the booklet:");
//        parameter.put("number of pages", "6.Enter number of pages of the booklet:");
//        
//        String title; String publisher; int numberOfReleases; String category; String language; String dateOfRelease; int numberOfPages;
//        String parameters[] = {};
//        String parametersText[] = {"1.Enter the title of the booklet:",
//                            "2.Enter the publisher of the booklet:",
//                            "3.Enter the catagory of the booklet:",
//                            "4.Enter the language of the booklet:",
//                            "5.Enter the Date of release of the booklet:",
//                            "6.Enter number of pages of the booklet:"};
//        Scanner reader = new Scanner(System.in);
//        for(String text: parametersText){
//            int i = 0;
//            System.out.println(text);
//            parameters[i] = reader.nextLine();
//            i++;
//        }
//        this.register.addLiterature(new Booklet(parameters[0] , parameters[1], parameters[2], parameters[3], parameters[4], 10/*numberOfPages*/));
//        System.out.println("Booklet: " + parameters[0] + " has been added to register!");
//    }
//    
//    private void listAllType() {
//        ArrayList<Book> books = new ArrayList<>();
//        ArrayList<Magazine> Magazines = new ArrayList<>();
//        ArrayList<Newspaper> Newspaper = new ArrayList<>();
//        ArrayList<Booklet> booklets = new ArrayList<>();
//        Iterator<Literature> it = this.register.getIterator();
//        while (it.hasNext()) {
//            Literature literature = it.next();
//            if (literature instanceof Book) {
//                books.add((Book) literature);
//            }
//            if (literature instanceof Magazine) {
//                Magazines.add((Magazine) literature);
//            }
//            if (literature instanceof Newspaper) {
//                Newspaper.add((Newspaper) literature);
//            }
//            if (literature instanceof Booklet) {
//                booklets.add((Booklet) literature);
//            }
//        }
//    } 
//        private void listAllBooks() {
//        int numberOfBooksFound = 0;
//        Iterator<Literature> it = this.register.getIterator();
//        while (it.hasNext()) {
//            Literature literature = it.next();
//            if (literature instanceof Book) {
//                System.out.print(literature);
//                System.out.println();
//                numberOfBooksFound++;
//            }
//        }
//        if (numberOfBooksFound == 0) {
//            System.out.println("No Books found!");
//        }
//    }
//
//    private void listAllNewspaper() {
//        int numberOfNewspaperFound = 0;
//        Iterator<Literature> it = this.register.getIterator();
//        while (it.hasNext()) {
//            Literature literature = it.next();
//            if (literature instanceof Newspaper) {
//                System.out.print(literature);
//                System.out.println();
//                numberOfNewspaperFound++;
//            }
//        }
//        if (numberOfNewspaperFound == 0) {
//            System.out.println("No Newspaper found!");
//        }
//    }
//
//    private void listAllMagazines() {
//        int numberOfMagazineFound = 0;
//        Iterator<Literature> it = this.register.getIterator();
//        while (it.hasNext()) {
//            Literature literature = it.next();
//            if (literature instanceof Magazine) {
//                System.out.print(literature);
//                System.out.println();
//                numberOfMagazineFound++;
//            }
//        }
//        if (numberOfMagazineFound == 0) {
//            System.out.println("No Magazine found!");
//        }
//    }
//
//    private void listAllBooklets() {
//        int numberOfBookletsFound = 0;
//        Iterator<Literature> it = this.register.getIterator();
//        while (it.hasNext()) {
//            Literature literature = it.next();
//            if (literature instanceof Booklet) {
//                System.out.print(literature);
//                System.out.println();
//                numberOfBookletsFound++;
//            }
//        }
//        if (numberOfBookletsFound == 0) {
//            System.out.println("No Booklet found!");
//        }
//    }
}
