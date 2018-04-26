import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JTextArea;

/**
 * Represents user interface that is responsible for 
 * communication with the user.
 *
 * @author Sarmad, Nikita and Kristin
 * @version 2018.04.14
 */
public class UserInterface extends Application{

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
    public void startOld() {
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
                    removeLiteratureByTitle();
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
                
                // search register
                case 7:
                    searchRegister();
                    break; 
                    
                // Set book to series
                case 8:
                    setSeriesState(true);
                    break;
                    
                // Set book to not series
                case 9:
                    setSeriesState(false);
                    break;
                    
                // Quit
                case 10:
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
    private void removeLiteratureByTitle() {
        Scanner reader = new Scanner(System.in);

        Iterator<Literature> it = this.register.getLiteraureIterator();
        if (!it.hasNext()) {
            System.out.println("Register is empty! There are no literature to remove.");
        } 
        else {
            System.out.println("Insert the title of the literature to remove:");
            String titleIncludes = reader.next();
            
            Literature literatureToRemove = register.getLiteratureByTitle(titleIncludes);
            if (literatureToRemove != null) {
                System.out.println(literatureToRemove.getTitle() + " Has been removed");
                register.removeByTitleContains(literatureToRemove.getTitle());
            } 
            else {
                System.out.println("Invalid Literature title, ...");
            }
        }
    }
    
   /**
    * prints all avalible literature in the register.
    */
    private void viewRegister(){
        printAllLiteratureInList(this.register.getLiteraureIterator(), "Register is empty!");
    }
    
    /**
     * Fills the register with predefined literature.
     */
    public void fillLiteratureList() {
        this.register.fillLiteratureRegister();
        System.out.println("Literature register i filled with Literature");
    }

    /**
     * Prints welcome message-
     */
    public void printWelcome() {
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
        System.out.println("Type 7 to search register by title and publisher");
        System.out.println("Type 8 to set a book to series");
        System.out.println("Type 9 to set a book to not series");
        System.out.println("Type 10 to quit");
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
        int attempts = 0;
        boolean sucsess = false;
        do{
            try{
                Scanner intReader = new Scanner(System.in);
                numberOfPages = intReader.nextInt();  
                this.register.addLiterature(new Booklet(title, publisher, category, language, dateOfRelease, numberOfPages));
                System.out.println("Booklet: " + title + " has been added to register!");
                sucsess = true;
            }
            catch(InputMismatchException e){
                if(attempts < 2){
                    System.out.println("Number of pages can not be a string! Please enter a number:");
                }
                attempts++;
            }
        }
        while(!sucsess && attempts < 3);
        
        if(!sucsess){
            System.out.println("Was not able to add a new booklet, please try again later!");
        }
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
     * Searches the register by title and publisher and prints found literature.
     */    
    private void searchRegister() {
        Scanner reader = new Scanner(System.in);

        Iterator<Literature> it = this.register.getLiteraureIterator();
        if (!it.hasNext()) {
            System.out.println("You cant search any literature because register is empty!");
        } 
        else {
            System.out.println("1.Enter the title of the literature to search:");
            String searchTitle = reader.nextLine();
            
            System.out.println("2.Enter the publisher of the literature to search:");
            String searchPublisher = reader.nextLine();
            
            Literature literatureTitle = register.getLiteratureByTitle(searchTitle);
            Literature literaturePublisher = register.getLiteratureByPublisher(searchPublisher);
            
            if (literatureTitle != null && literaturePublisher != null) {
                System.out.println("Found results: \n" + literatureTitle.getTitle() + ", By: " + 
                                   literaturePublisher.getPublisher());
            }
            else {
                System.out.println("No literature found!");
            }
        }
    }
    
    /**
     * Lists all literature that is in cart.
     */   
    private void viewCart() {
        printAllLiteratureInList(this.cart.getCartIterator(), "Cart is empty!");
    }
    
    /**
     * changes a books series state.
     */   
    private void setSeriesState(boolean state){
        Scanner reader = new Scanner(System.in);
        if(register.isEmpty()){
            System.out.println("Register is empty, therfore can't complete this action");
        }
        else{
            System.out.println("Enter the name of the book you want to change the series state of:");
            String bookTitle = reader.nextLine();
            Literature literature = register.getLiteratureByTitle(bookTitle);
            if(literature != null){
               if(literature instanceof Book){
                   register.seLiteratureSeriesState(literature, state);
                   System.out.println("State of: " + literature.getTitle() + ", has been set to: " + state);
               }
               else{
                   System.out.println("The literature you are trying to change series state of is not a book, please search for a book!");
               }
            }
           else{
               System.out.println("Literature not found in register");
           }   
        }
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1000, 600);
        VBox menu = new VBox(8);
        HBox header = new HBox(8);
        int buttonWidth = 150;
        
        Label title = new Label("Literature Register");
        title.setFont(Font.font("", 18));
        title.setTextFill(Color.web("#ffffff"));
      
        Button btn1 = new Button("Auto Fill register");
        Button btn2 = new Button("List all literature");
        Button btn3 = new Button("Add literature");
        Button btn4 = new Button("Remove literature");
        Button btn5 = new Button("Search register");
        Button btn6 = new Button("Series a book");
        Button btn7 = new Button("Unseries a book");
        Button btn8 = new Button("Add to cart");
        Button btn9 = new Button("Remove from cart");
        Button btn10 = new Button("View cart");
        
        //vbox.setPrefWidth(200);
        btn1.setMinWidth(buttonWidth);
        btn2.setMinWidth(buttonWidth);
        btn3.setMinWidth(buttonWidth);
        btn4.setMinWidth(buttonWidth);
        btn5.setMinWidth(buttonWidth);
        btn6.setMinWidth(buttonWidth);
        btn7.setMinWidth(buttonWidth);
        btn8.setMinWidth(buttonWidth);
        btn9.setMinWidth(buttonWidth);
        btn10.setMinWidth(buttonWidth);
        
        String cssLayout = "-fx-background-color: #0e6d91;";
                
        //Page title
        header.setStyle(cssLayout);
        header.getChildren().addAll(title);
        header.setPadding(new Insets(20, 12, 20, 12)); //top, bottom, right, left
        header.setAlignment(Pos.CENTER);
        
        //selection menu
        menu.setStyle("-fx-background-color: #d7dae0;");
        menu.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10);
        menu.setPadding(new Insets(15, 12, 15, 12));
        
        root.setTop(header);
        root.setLeft(menu);
                
        startScene(primaryStage,root,scene,menu,header);
        primaryStage.setTitle("Literatur register");
        primaryStage.show();

        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                autoFillScene(primaryStage,root,scene,menu,header);
                fillLiteratureList();
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listLiteratureScene(primaryStage,root,scene,menu,header);
            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddLiteratureScene(primaryStage,root,scene,menu,header);
            }
        });
        
    }
    
    private void startScene(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header){
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.CENTER);
        
        root.setCenter(mainSene);
                
        Label textLbl2 = new Label("Welcome to the literature register. "
                                   + "\nPlease choose an option from the "
                                   + "\nleft menu to start the application."
                                   + "\n\nApplication created by team 8:\nSarmad Saeed Abbas\nNikita sumahers\nKristin Hagen");
        textLbl2.setTextFill(Color.web("#0076a3"));

        mainSene.getChildren().addAll(textLbl2);
        primaryStage.setScene(scene);
    }
    
    private void AddLiteratureScene(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header){
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12)); //top, bottom, right, left
        mainSene.setAlignment(Pos.CENTER);
        
        root.setCenter(mainSene);
        
        Label textLbl2 = new Label("Scene 2");
        textLbl2.setTextFill(Color.web("#0076a3"));
        
        mainSene.getChildren().addAll(textLbl2);
        primaryStage.setScene(scene);
    }
    
    private void autoFillScene(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header){
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.CENTER);
        
        root.setCenter(mainSene);
        
        Label textLbl2 = new Label("Register has been filled with literature!");
        textLbl2.setTextFill(Color.web("#2da331"));
        
        mainSene.getChildren().addAll(textLbl2);
        primaryStage.setScene(scene);
    }
    
    private void listLiteratureScene(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header){
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.CENTER);
        TextArea t1= new TextArea();
        t1.setPrefHeight(500);
        t1.setPrefWidth(500);
        t1.setEditable(false);
        root.setCenter(mainSene);
        String literatureToPrint = "";
                
        Iterator<Literature> it = register.getLiteraureIterator();
        if (!it.hasNext()) {
            System.out.println("Register is empty");
            Label erroMessage = new Label("Register is empty");
            erroMessage.setTextFill(Color.web("#ff0000"));
            mainSene.getChildren().add(erroMessage);
        }
        while (it.hasNext()) {
            Literature literature = it.next();
            if (literature instanceof Book) {
                Book b = (Book) literature;
                literatureToPrint += "Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n" + 
                                   "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n" + 
                                   "Date of release: " + b.getDateOfRelease() + "\n" +
                                   "Number of pages: " + b.getNumberOfPages() + "\n" + "Version: " + b.getVersion() + "\n" +
                                   "Edition: " + b.getEdition() + "\n\n";
                
            }
            else if(literature instanceof Magazine){
                Magazine b = (Magazine) literature;
                literatureToPrint += "Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n" + 
                                   "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n" + 
                                   "Date of release: " + b.getDateOfRelease() + "\n" +
                                   "Number of pages: " + b.getNumberOfPages() + "\n" + 
                                   "Number of releases: " + b.getNumberOfRealeases() + "\n\n";
            }
            else if(literature instanceof Newspaper){
                Newspaper b = (Newspaper) literature;
                literatureToPrint += "Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n" + 
                                   "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n" + 
                                   "Date of release: " + b.getDateOfRelease() + "\n" +
                                   "Number of pages: " + b.getNumberOfPages() + "\n" + 
                                   "Number of releases: " + b.getNumberOfRealeases() + "\n\n";
            }
            else if(literature instanceof Booklet){
                Booklet b = (Booklet) literature;
                literatureToPrint += "Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n" + 
                                   "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n" + 
                                   "Date of release: " + b.getDateOfRelease() + "\n" +
                                   "Number of pages: " + b.getNumberOfPages() + "\n\n";                
            }
        }
        t1.setText(literatureToPrint);
        mainSene.getChildren().add(t1);
        primaryStage.setScene(scene);
    }
    
    /**
    * Prints all avalible literature in the given iterator.
    * 
    * @param iterator the iterator (that returns/holds a collection) to go through and print.
    * @param emptyCollectionMessage the message to print when there is nothing to print
    */
    private void printAllLiteratureInList(Iterator iterator, String emptyCollectionMessage) {
        Iterator<Literature> it = iterator;
        if (!it.hasNext()) {
            System.out.println(emptyCollectionMessage);
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

}
