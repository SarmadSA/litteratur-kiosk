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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Represents graphical user interface that is responsible for
 * communication with the user.
 *
 * @author Sarmad, Nikita and Kristin
 * @version 2018.05.01
 */
public class UserInterface extends Application {

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
     * Start the application, and careates the start scene
     * that includes the selection menu and the header.
     * 
     * @param primaryStage the primary stage.
     */
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1200, 750);
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

        //selection menu (menu to the left)
        menu.setStyle("-fx-background-color: #d7dae0;");
        menu.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10);
        menu.setPadding(new Insets(15, 12, 15, 12));

        root.setTop(header);
        root.setLeft(menu);

        startScene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Literatur register");
        primaryStage.show();

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                autoFillScene(root);
                fillLiteratureList();
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listLiteratureScene(root, register.getLiteraureIterator(), "Register is empty");
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addNewLiteratureScene(root);
            }
        });
        
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
           public void handle(ActionEvent event) {
                removeLiteratureScene(root);
           }
        });
          
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                searchLiteratureScene(root);
            }
        });
                  
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setSeriesScene(root,true);
            }
        });
        
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setSeriesScene(root,false);
            }
        });
        
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addToCartScene(root);
            }
        });
        
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                removeFromCartScene(root);
            }
        });

        btn10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listLiteratureScene(root, cart.getCartIterator(), "Cart is empty");
            }
        });

    }

    /**
     * Fills the register with predefined literature.
     */
    private void fillLiteratureList() {
        this.register.fillLiteratureRegister();
    }
    
    /**
     * Adds new book to register.
     * 
     * @param title - title of book
     * @param publisher - publisher of book
     * @param category - category of book
     * @param language - language of book
     * @param dateOfRelese - release date of book
     * @param numberOfPages - number of pages of book
     */
    private void addBookToRegister(String title, String publisher, String category, String language, String dateOfRelese, int numberOfPages){
        this.register.addLiterature(new Book(title, publisher, category, language, dateOfRelese, numberOfPages));
    }

    /**
     * Adds new newspaper to the register.
     * 
     * @param title - title of newspaper
     * @param publisher - publisher of newspaper
     * @param category - category of newspaper
     * @param language - language of newspaper
     * @param dateOfRelease - release date of newspaper
     * @param numberOfPages - number of pages of newspaper
     * @param numberOfReleases - number of releases each yeaer of the newspaper
     */
    private void addNewspaperToRegister(String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages, int numberOfReleases) {
        this.register.addLiterature(new Newspaper(numberOfReleases, title, publisher, category, language, dateOfRelease, numberOfPages));
    }

    /**
     * Adds new magazine to register.
     * 
     * @param title - title of magazine
     * @param publisher - publisher of magazine
     * @param category - category of megazine 
     * @param language - language of megazine
     * @param dateOfRelease - release date of megazine
     * @param numberOfPages - number of pages of magazine
     * @param numberOfReleases - number of releases each yeaer of the magazine
     */
    private void addMagazineToRegister(String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages, int numberOfReleases) {
        this.register.addLiterature(new Magazine(numberOfReleases, title, publisher, category, language, dateOfRelease, numberOfPages));
    }
    
    /**
     * Adds new booklet to register.
     * 
     * @param title - title of booklet
     * @param publisher - publisher of booklet
     * @param category - category of booklet
     * @param language - language of booklet
     * @param dateOfRelese - release date of booklet
     * @param numberOfPages - number of pages of booklet
     */
    private void addBookletToRegister(String title, String publisher, String category, String language, String dateOfRelese, int numberOfPages) {
        this.register.addLiterature(new Booklet(title, publisher, category, language, dateOfRelese, numberOfPages));
    }

    /**
     * Changes a books series state to a new state.
     * 
     * @param state - the seriese state to set the book to.
     * @param bookTitle - the title of the book to set the series state of
     * @return - return success/fail indication message
     */
    private String setSeriesState(boolean state, String bookTitle) {
        String message = "";
        if (register.isEmpty()) {
            message = "Register is empty, therfore can't complete this action";
        }
        else if(bookTitle.equals("")){
            message = "Please enter the tite of the book in the field";
        }
        else {
            Literature literature = register.getLiteratureByTitle(bookTitle);
            if (literature != null) {
                if (literature instanceof Book) {
                    register.seLiteratureSeriesState(literature, state);
                    message = "State of: " + literature.getTitle() + ", has been set to: " + state;
                } else {
                    message = "The literature you are trying to change series state of is not a book, please search for a book!";
                }
            } else {
                message = "Literature not found in register";
            }
        }
        return message;
    }
    
    /**
     * Represents the start scene in the GUI.
     * 
     * @param primaryStage - primary stage of the scene
     */
    private void startScene(BorderPane root) {
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
    }
    
    /**
     * Displays successful register autto fill message.
     * 
     * @param root - the root of the stage
     */
    private void autoFillScene(BorderPane root) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.CENTER);
        root.setCenter(mainSene);

        Label successLabel = new Label("Register has been filled with literature!");
        successLabel.setTextFill(Color.web("#2da331"));

        mainSene.getChildren().addAll(successLabel);
    }
    
    /**
     * Displays add new literature scene.
     * 
     * @param root - the root of the stage
     */
    private void addNewLiteratureScene(BorderPane root) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.TOP_LEFT);

        root.setCenter(mainSene);

        Label textLb = new Label("Choose a litterature type");

        MenuButton menuButton = menuButton(root);

        mainSene.getChildren().addAll(textLb, menuButton);
    }
    
    /**
     * Creates and returns a dropdown menu with some option.
     * 
     * @param root - the root of the stage
     * @return - returns a menu
     */
    private MenuButton menuButton(BorderPane root) {

        MenuItem menuItem1 = new MenuItem("Book");
        MenuItem menuItem2 = new MenuItem("Newspaper");
        MenuItem menuItem3 = new MenuItem("Magazine");
        MenuItem menuItem4 = new MenuItem("Booklet");

        MenuButton menuButton = new MenuButton("Litterature", null, menuItem1, menuItem2, menuItem3, menuItem4);

        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addBookScene(root);
            }
        });
        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addNewspaperScene(root);
            }
        });
        menuItem3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addMagazineScene(root);
            }
        });
        menuItem4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addBookletScene(root);
            }
        });

        return menuButton;
    }
    
    /**
     * Creates/Displays add newspapers scene.
     * 
     * @param root - the root of the stage
     */
    private void addNewspaperScene(BorderPane root) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.TOP_LEFT);

        root.setCenter(mainSene);

        MenuButton menuButton = menuButton(root);

        Label textLb1 = new Label("Title: ");
        TextField titleField = new TextField();

        Label textLb2 = new Label("Publisher: ");
        TextField pubField = new TextField();

        Label textLb3 = new Label("Category: ");
        TextField catField = new TextField();

        Label textLb4 = new Label("Language: ");
        TextField lanField = new TextField();

        Label textLb5 = new Label("Date of release: ");
        TextField dorField = new TextField();

        Label textLb6 = new Label("Number of pages: ");
        TextField nopField = new TextField();

        Label textLb7 = new Label("Number of realeses: ");
        TextField norField = new TextField();

        Button btn = new Button("Add");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!nopField.getText().trim().equals("") && !norField.getText().trim().equals("") && !titleField.getText().trim().equals("") && !pubField.getText().trim().equals("")){
                    try{
                        addNewspaperToRegister(titleField.getText().trim(), pubField.getText().trim(), catField.getText().trim(), lanField.getText().trim(), dorField.getText().trim(), Integer.parseInt(nopField.getText().trim()), Integer.parseInt(norField.getText().trim()));
                        Label successMessage = new Label("New newspaper is added");
                        successMessage.setTextFill(Color.web("#2da331"));
                        mainSene.getChildren().add(successMessage);
                    }
                    catch(Exception e){
                        Label error = new Label("Number of pages and number of releases must be integers!");
                        error.setTextFill(Color.web("#ff0000"));
                        mainSene.getChildren().add(error);
                    }
                }
                else{
                    Label requiredFileds = new Label("Title, publisher, number of pages and number of releases are required!");
                    requiredFileds.setTextFill(Color.web("#ff0000"));
                    mainSene.getChildren().add(requiredFileds);
                }
            }
        });

        mainSene.getChildren().addAll(menuButton, textLb1, titleField, textLb2, pubField, textLb3, catField, textLb4, lanField, textLb5, dorField, textLb6, nopField, textLb7, norField, btn);
    }

    /**
     * Creates/Displays add new megazine scene.
     * 
     * @param root - the root of the stage
     */
    private void addMagazineScene(BorderPane root) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.TOP_LEFT);

        root.setCenter(mainSene);

        MenuButton menuButton = menuButton(root);

        Label textLb1 = new Label("Title: ");
        TextField titleField = new TextField();

        Label textLb2 = new Label("Publisher: ");
        TextField pubField = new TextField();

        Label textLb3 = new Label("Category: ");
        TextField catField = new TextField();

        Label textLb4 = new Label("Language: ");
        TextField lanField = new TextField();

        Label textLb5 = new Label("Date of release: ");
        TextField dorField = new TextField();

        Label textLb6 = new Label("Number of pages: ");
        TextField nopField = new TextField();

        Label textLb7 = new Label("Number of realeses: ");
        TextField norField = new TextField();

        Button btn = new Button("Add");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!nopField.getText().trim().equals("") && !norField.getText().trim().equals("") && !titleField.getText().trim().equals("") && !pubField.getText().trim().equals("")){
                    try{
                        addMagazineToRegister(titleField.getText().trim(), pubField.getText().trim(), catField.getText().trim(), lanField.getText().trim(), dorField.getText().trim(), Integer.parseInt(nopField.getText().trim()), Integer.parseInt(norField.getText().trim()));
                        Label successMessage = new Label("New magazine is added");
                        successMessage.setTextFill(Color.web("#2da331"));
                        mainSene.getChildren().add(successMessage);
                    }
                    catch(Exception e){
                        Label error = new Label("Number of pages and number of releases must be integers!");
                        error.setTextFill(Color.web("#ff0000"));
                        mainSene.getChildren().add(error);
                    }
                }
                else{
                    Label requiredFileds = new Label("Title, publisher, number of pages and number of releases are required!");
                    requiredFileds.setTextFill(Color.web("#ff0000"));
                    mainSene.getChildren().add(requiredFileds);
                }
            }
        });

        mainSene.getChildren().addAll(menuButton, textLb1, titleField, textLb2, pubField, textLb3, catField, textLb4, lanField, textLb5, dorField, textLb6, nopField, textLb7, norField, btn);
    }

    /**
     * Creates/Displays add new booklet scene.
     * 
     * @param root - the root of the stage
     */
    private void addBookletScene(BorderPane root) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.TOP_LEFT);

        root.setCenter(mainSene);

        MenuButton menuButton = menuButton(root);

        Label textLb1 = new Label("Title: ");
        TextField titleField = new TextField();

        Label textLb2 = new Label("Publisher: ");
        TextField pubField = new TextField();

        Label textLb3 = new Label("Category: ");
        TextField catField = new TextField();

        Label textLb4 = new Label("Language: ");
        TextField lanField = new TextField();

        Label textLb5 = new Label("Date of release: ");
        TextField dorField = new TextField();

        Label textLb6 = new Label("Number of pages: ");
        TextField nopField = new TextField();

        Button btn = new Button("Add");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!nopField.getText().trim().equals("") && !titleField.getText().trim().equals("") && !pubField.getText().trim().equals("")){
                    try{
                        addBookletToRegister(titleField.getText().trim(), pubField.getText().trim(), catField.getText().trim(), lanField.getText().trim(), dorField.getText().trim(), Integer.parseInt(nopField.getText().trim()));
                        Label successMessage = new Label("New booklet is added");
                        successMessage.setTextFill(Color.web("#2da331"));
                        mainSene.getChildren().add(successMessage);
                    }
                    catch(Exception e){
                        Label error = new Label("Number of pages must be an integer!");
                        error.setTextFill(Color.web("#ff0000"));
                        mainSene.getChildren().add(error);
                    }
                }
                else{
                    Label requiredFileds = new Label("Title, publisher and number of pages are required!");
                    requiredFileds.setTextFill(Color.web("#ff0000"));
                    mainSene.getChildren().add(requiredFileds);
                }
            }
        });

        mainSene.getChildren().addAll(menuButton, textLb1, titleField, textLb2, pubField, textLb3, catField, textLb4, lanField, textLb5, dorField, textLb6, nopField, btn);
    }
    
    /**
     * Creates/Displays add new book scene.
     * 
     * @param root - the root of the stage
     */
    private void addBookScene(BorderPane root) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.TOP_LEFT);

        root.setCenter(mainSene);

        MenuButton menuButton = menuButton(root);

        Label textLb1 = new Label("Title: ");
        TextField titleField = new TextField();

        Label textLb2 = new Label("Publisher: ");
        TextField pubField = new TextField();

        Label textLb3 = new Label("Category: ");
        TextField catField = new TextField();

        Label textLb4 = new Label("Language: ");
        TextField lanField = new TextField();

        Label textLb5 = new Label("Date of release: ");
        TextField dorField = new TextField();

        Label textLb6 = new Label("Number of pages: ");
        TextField nopField = new TextField();

        Button btn = new Button("Add");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!nopField.getText().trim().equals("") && !titleField.getText().trim().equals("") && !pubField.getText().trim().equals("")){
                    try{
                        addBookToRegister(titleField.getText().trim(), pubField.getText().trim(), catField.getText().trim(), lanField.getText().trim(), dorField.getText().trim(), Integer.parseInt(nopField.getText().trim()));
                        Label successMessage = new Label("New book is added");
                        successMessage.setTextFill(Color.web("#2da331"));
                        mainSene.getChildren().add(successMessage);
                    }
                    catch(Exception e){
                        Label error = new Label("Number of pages must be an integer!");
                        error.setTextFill(Color.web("#ff0000"));
                        mainSene.getChildren().add(error);
                    }
                }
                else{
                    Label requiredFileds = new Label("Title, publisher and number of pages are required!");
                    requiredFileds.setTextFill(Color.web("#ff0000"));
                    mainSene.getChildren().add(requiredFileds);
                }
            }
        });

        mainSene.getChildren().addAll(menuButton, textLb1, titleField, textLb2, pubField, textLb3, catField, textLb4, lanField, textLb5, dorField, textLb6, nopField, btn);
    }

    /**
     * Creates list literatur scene and lists all literature in that scene.
     * 
     * @param root - the root of the stage
     * @param iterator - the iterator to go through and print literature from
     * @param emptyCollectionMessage - message to print if collection is empty
     */
    private void listLiteratureScene(BorderPane root, Iterator iterator, String emptyCollectionMessage) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.CENTER);
        root.setCenter(mainSene);

        Iterator<Literature> it = iterator;
        if (!it.hasNext()) {
            Label erroMessage = new Label(emptyCollectionMessage);
            erroMessage.setTextFill(Color.web("#ff0000"));
            mainSene.getChildren().add(erroMessage);
        } else {
            TextArea t1 = new TextArea();
            t1.setPrefHeight(1000);
            t1.setPrefWidth(1000);
            t1.setEditable(false);
            String literatureToPrint = "";

            while (it.hasNext()) {
                Literature literature = it.next();
                if (literature instanceof Book) {
                    Book b = (Book) literature;
                    literatureToPrint += "Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n"
                            + "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n"
                            + "Date of release: " + b.getDateOfRelease() + "\n"
                            + "Number of pages: " + b.getNumberOfPages() + "\n\n";
                } else if (literature instanceof Magazine) {
                    Magazine b = (Magazine) literature;
                    literatureToPrint += "Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n"
                            + "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n"
                            + "Date of release: " + b.getDateOfRelease() + "\n"
                            + "Number of pages: " + b.getNumberOfPages() + "\n"
                            + "Number of releases: " + b.getNumberOfRealeases() + "\n\n";
                } else if (literature instanceof Newspaper) {
                    Newspaper b = (Newspaper) literature;
                    literatureToPrint += "Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n"
                            + "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n"
                            + "Date of release: " + b.getDateOfRelease() + "\n"
                            + "Number of pages: " + b.getNumberOfPages() + "\n"
                            + "Number of releases: " + b.getNumberOfRealeases() + "\n\n";
                } else if (literature instanceof Booklet) {
                    Booklet b = (Booklet) literature;
                    literatureToPrint += "Title: " + b.getTitle() + "\n" + "Publisher: " + b.getPublisher() + "\n"
                            + "Category: " + b.getCategory() + "\n" + "Language: " + b.getLanguage() + "\n"
                            + "Date of release: " + b.getDateOfRelease() + "\n"
                            + "Number of pages: " + b.getNumberOfPages() + "\n\n";
                }
            }
            t1.setText(literatureToPrint);
            mainSene.getChildren().add(t1);
        }
    }
    
    /**
     * Removes literature with given tittle from register.
     * 
     * @param literatureTitle - title of literature to remove
     * @param mainScene - Vbox to remove literature from
     */
    private void removeLiteratureByTitle(String literatureTitle, VBox mainScene) {
        Iterator<Literature> it = this.register.getLiteraureIterator();
        String message = "";
        String messageColor = "";
        Label feedBack;
        if (!it.hasNext()) {
            message = "Register is empty! There are no literature to remove.";
            messageColor = "#ff0000";
        }
        else {
            
            Literature literatureToRemove = register.getLiteratureByTitle(literatureTitle);
            if (literatureToRemove != null) {
                message = literatureToRemove.getTitle() + " Has been removed";
                messageColor = "#2da331";
                register.removeByTitleContains(literatureToRemove.getTitle());
            } 
            else {
                message = "No literature with this title found to remove";
                messageColor = "#ff0000";
            }
        }
        feedBack = new Label(message);
        feedBack.setTextFill(Color.web(messageColor));
        mainScene.getChildren().addAll(feedBack);
    }
    
    /**
     * Displays/Creates scene for remove liteerature.
     * 
     * @param root - the root of the stage
     */
    private void removeLiteratureScene(BorderPane root){
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        root.setCenter(mainSene);
        
        Label textLbl2 = new Label("Enter the title of the literature to remove:");
        TextField textField = new TextField();
        
        Button search = new Button("Find and remove");
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String literatureToRemove = textField.getText().trim();
                if(!literatureToRemove.equals("")){
                    removeLiteratureByTitle(literatureToRemove,mainSene);
                }
                else{
                    Label message = new Label("Please enter a literature title in the field");
                    message.setTextFill(Color.web("#ff0000"));
                    mainSene.getChildren().add(message);
                }
            }
        });
        mainSene.getChildren().addAll(textLbl2,textField,search);
    }
    
    /**
     * Searches the register by title and publisher and returns a message 
     * indicating whether or not  lierature was found.
     * 
     * @param searchTitle - title to search
     * @param searchPublisher - publisher to search
     * @return - return found/not-found message
     */
    private String searchRegister(String searchTitle, String searchPublisher){
        Iterator<Literature> it = this.register.getLiteraureIterator();
        String searchMessage = "";
        
        if (!it.hasNext()) {
            searchMessage = "You can't search any literature because register is empty!";
        } 
        else if(searchTitle.trim().equals("") || searchPublisher.trim().equals("")){
            searchMessage = "All field must be filled to preform this search!";
        }
        else {
            Literature literatureTitle = register.getLiteratureByTitle(searchTitle.trim().toLowerCase());
            Literature literaturePublisher = register.getLiteratureByPublisher(searchPublisher.trim().toLowerCase());

            if (literatureTitle != null && literaturePublisher != null) {
                searchMessage = "Found results: \n" + literatureTitle.getTitle() + ", By: "
                                + literaturePublisher.getPublisher();
            }
            else {
                searchMessage = "No literature found!";
            }
        }
        return searchMessage;
    }
    
    /**
     * Creates/Displays search literature scene.
     * 
     * @param root - the root of the stage
     */
    private void searchLiteratureScene(BorderPane root){
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12)); //top, bottom, right, left
        root.setCenter(mainSene);
        
        Label sceneTitle = new Label("Search");
        Label title = new Label("Literature title:");
        TextField titleField = new TextField();
        Label publisher = new Label("Literature putblisher:");
        TextField publisherField = new TextField();
        Button searchButton = new Button("Search");
        
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String searchResults = searchRegister(titleField.getText(), publisherField.getText());
                Label searchResultsMessage = new Label(searchResults);
                mainSene.getChildren().add(searchResultsMessage);
            }
        });
        
        mainSene.getChildren().addAll(sceneTitle,title,titleField,publisher,publisherField,searchButton);
    }

    /**
     * Adds literature with given title to cart, and returns a message indicating
     * whether the adding prosess was successfull or not.
     * 
     * @param literatureTitle - title of literature to add to cart
     * @return - return adding success/fail message.
     */
    private String addLiteratureToCart(String literatureTitle) {
        Iterator<Literature> it = this.register.getLiteraureIterator();
        String message = "";
        
        if (!it.hasNext()) {
            message = "You cant add any literature to cart because register is empty!";
        } 
        else if(literatureTitle.trim().equals("")){
            message = "Please fill the field!";
        }
        else {
            Literature literatureToAdd = register.getLiteratureByTitle(literatureTitle.trim());
            if (literatureToAdd != null) {
                message = literatureToAdd.getTitle() + " Has been added to cart";
                cart.addToCart(literatureToAdd);
            } 
            else {
                message = "No literature with this title found!";
            }
        }
        return message;
    }
    
    /**
     * Creates add to cart secene.
     * 
     * @param root - the root of the stage
     */
    private void addToCartScene(BorderPane root){
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        root.setCenter(mainSene);
        
        Label fieldLabel = new Label("Enter the title of the literature to add to cart:");
        TextField textField = new TextField();
        
        Button search = new Button("Add to cart");
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String literatureToAdd = textField.getText().trim();
                Label message = new Label(addLiteratureToCart(literatureToAdd));
                mainSene.getChildren().add(message);
            }
        });
        mainSene.getChildren().addAll(fieldLabel,textField,search);
    }
    
    /**
     * Removes literature with given tittle from cart.
     * 
     * @param literatureTitle title o literature to remove.
     * @param mainScene the vbox to add label messages to.
     */
    private void removeLiteratureFromCart(String literatureTitle, VBox mainScene) {
        Iterator<Literature> it = this.cart.getCartIterator();
        String message = "";
        String messageColor = "";
        Label feedBack;
        if (!it.hasNext()) {
            message = "cart is empty! There are no literature to remove.";
            messageColor = "#ff0000";
        }
        else {            
            Literature literatureToRemove = cart.getLiteratureByTitle(literatureTitle);
            if (literatureToRemove != null) {
                message = literatureToRemove.getTitle() + " Has been removed";
                messageColor = "#2da331";
                cart.removeFromCart(literatureToRemove);
            } 
            else {
                message = "No literature with this title found to remove";
                messageColor = "#ff0000";
            }
        }
        feedBack = new Label(message);
        feedBack.setTextFill(Color.web(messageColor));
        mainScene.getChildren().addAll(feedBack);
    }
    
    /**
     * Creates remove from cart scene.
     * 
     * @param root - the root of the stage
     */
    private void removeFromCartScene(BorderPane root){
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        root.setCenter(mainSene);
        
        Label textLbl2 = new Label("Enter the title of the literature to remove from cart:");
        TextField textField = new TextField();
        
        Button search = new Button("Remove from cart");
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String literatureToRemove = textField.getText().trim();
                if(!literatureToRemove.equals("")){
                    removeLiteratureFromCart(literatureToRemove,mainSene);
                }
                else{
                    Label message = new Label("Please enter a literature title in the field");
                    message.setTextFill(Color.web("#ff0000"));
                    mainSene.getChildren().add(message);
                }
            }
        });
        mainSene.getChildren().addAll(textLbl2,textField,search);
    }
    
    /**
     * Creates set series state scene.
     * 
     * @param root - the root of the stage
     * @param state - the new series state to set the book to
     */
    private void setSeriesScene(BorderPane root, boolean state){
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        root.setCenter(mainSene);
        String message = "";
        String buttonText = "";
        if(state){
            message = "Enter the title of the book to set it to series:";
            buttonText = "Set series";
        }
        else{
            message = "Enter the title of the book to set it to not series:";
            buttonText = "Unseries";
        }
        
        Label fieldLabel = new Label(message);
        TextField textField = new TextField();
        
        Button search = new Button(buttonText);
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String bookToSeries = textField.getText().trim();
                Label message = new Label(setSeriesState(state, bookToSeries));
                mainSene.getChildren().add(message);
            }
        });
        mainSene.getChildren().addAll(fieldLabel,textField,search);
    }
}