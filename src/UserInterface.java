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
 * Represents user graphical interface that is responsible for
 * communication with the user.
 *
 * @author Sarmad, Nikita and Kristin
 * @version 2018.04.14
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
     * Fills the register with predefined literature.
     */
    private void fillLiteratureList() {
        this.register.fillLiteratureRegister();
        System.out.println("Literature register i filled with Literature");
    }
    
    /**
     * Adds new book to register.
     */
    private void addBookToRegister(String title, String publisher, String category, String language, String dateOfRelese, int numberOfPages){
        this.register.addLiterature(new Book(title, publisher, category, language, dateOfRelese, numberOfPages));
    }

    /**
     * Add new newspaper to the register.
     */
    private void addNewspaperToRegister(String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages, int numberOfReleases) {
        this.register.addLiterature(new Newspaper(numberOfReleases, title, publisher, category, language, dateOfRelease, numberOfPages));
    }

    /**
     * Adds new magazine to register.
     */
    private void addMagazineToRegister(String title, String publisher, String category, String language, String dateOfRelease, int numberOfPages, int numberOfReleases) {
        this.register.addLiterature(new Magazine(numberOfReleases, title, publisher, category, language, dateOfRelease, numberOfPages));
    }

    /**
     * Adds new booklet to register.
     */
    private void addBookletToRegister(String title, String publisher, String category, String language, String dateOfRelese, int numberOfPages) {
        this.register.addLiterature(new Booklet(title, publisher, category, language, dateOfRelese, numberOfPages));
    }

    /**
     * Adds literature with given title to cart, and returns a message indicating
     * wether the adding prosess was successfull or not.
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
     * changes a books series state.
     */
    private void setSeriesState(boolean state) {
        Scanner reader = new Scanner(System.in);
        if (register.isEmpty()) {
            System.out.println("Register is empty, therfore can't complete this action");
        } else {
            System.out.println("Enter the name of the book you want to change the series state of:");
            String bookTitle = reader.nextLine();
            Literature literature = register.getLiteratureByTitle(bookTitle);
            if (literature != null) {
                if (literature instanceof Book) {
                    register.seLiteratureSeriesState(literature, state);
                    System.out.println("State of: " + literature.getTitle() + ", has been set to: " + state);
                } else {
                    System.out.println("The literature you are trying to change series state of is not a book, please search for a book!");
                }
            } else {
                System.out.println("Literature not found in register");
            }
        }
    }

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
        menu.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10);
        menu.setPadding(new Insets(15, 12, 15, 12));

        root.setTop(header);
        root.setLeft(menu);

        startScene(primaryStage, root, scene);
        primaryStage.setTitle("Literatur register");
        primaryStage.show();

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                autoFillScene(primaryStage, root, scene);
                fillLiteratureList();
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listLiteratureScene(primaryStage, root, scene, register.getLiteraureIterator(), "Register is empty");
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addNewLiteratureScene(primaryStage, root, scene, menu, header);
            }
        });
        
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
           public void handle(ActionEvent event) {
                removeLiteratureScene(primaryStage,root,scene);
           }
        });
          
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            searchLiteratureScene(primaryStage,root,scene);
            }
        });
        
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addToCartScene(primaryStage,root, scene);
            }
        });
        
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                removeFromCartScene(primaryStage, root, scene);
            }
        });

        btn10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listLiteratureScene(primaryStage, root, scene, cart.getCartIterator(), "Cart is empty");
            }
        });

    }

    private void startScene(Stage primaryStage, BorderPane root, Scene scene) {
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
    
    private void autoFillScene(Stage primaryStage, BorderPane root, Scene scene) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.CENTER);

        root.setCenter(mainSene);

        Label textLbl2 = new Label("Register has been filled with literature!");
        textLbl2.setTextFill(Color.web("#2da331"));

        mainSene.getChildren().addAll(textLbl2);
        primaryStage.setScene(scene);
    }

    private void addNewLiteratureScene(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.TOP_LEFT);

        root.setCenter(mainSene);

        Label textLb = new Label("Choose a litterature type");

        MenuButton menuButton = menuButton(primaryStage, root, scene, menu, header);

        mainSene.getChildren().addAll(textLb, menuButton);
        primaryStage.setScene(scene);

    }

    private MenuButton menuButton(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header) {

        MenuItem menuItem1 = new MenuItem("Book");
        MenuItem menuItem2 = new MenuItem("Newspaper");
        MenuItem menuItem3 = new MenuItem("Magazine");
        MenuItem menuItem4 = new MenuItem("Booklet");

        MenuButton menuButton = new MenuButton("Litterature", null, menuItem1, menuItem2, menuItem3, menuItem4);

        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addBookScene(primaryStage, root, scene, menu, header);
            }
        });
        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addNewspaperScene(primaryStage, root, scene, menu, header);
            }
        });
        menuItem3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addMagazineScene(primaryStage, root, scene, menu, header);
            }
        });
        menuItem4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addBookletScene(primaryStage, root, scene, menu, header);
            }
        });

        return menuButton;
    }

    private void addNewspaperScene(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.TOP_LEFT);

        root.setCenter(mainSene);

        MenuButton menuButton = menuButton(primaryStage, root, scene, menu, header);

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

        Label textLb8 = new Label("New newspaper is added");
        textLb8.setTextFill(Color.web("#2da331"));

        Button btn = new Button("Add");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addNewspaperToRegister(titleField.getText().trim(), pubField.getText().trim(), catField.getText().trim(), lanField.getText().trim(), dorField.getText().trim(), Integer.parseInt(nopField.getText().trim()), Integer.parseInt(norField.getText().trim()));
                mainSene.getChildren().add(textLb8);
            }
        });

        mainSene.getChildren().addAll(menuButton, textLb1, titleField, textLb2, pubField, textLb3, catField, textLb4, lanField, textLb5, dorField, textLb6, nopField, textLb7, norField, btn);
        primaryStage.setScene(scene);
    }

    private void addMagazineScene(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.TOP_LEFT);

        root.setCenter(mainSene);

        MenuButton menuButton = menuButton(primaryStage, root, scene, menu, header);

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

        Label textLb8 = new Label("New magazine is added");
        textLb8.setTextFill(Color.web("#2da331"));

        Button btn = new Button("Add");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addMagazineToRegister(titleField.getText().trim(), pubField.getText().trim(), catField.getText().trim(), lanField.getText().trim(), dorField.getText().trim(), Integer.parseInt(nopField.getText().trim()), Integer.parseInt(norField.getText().trim()));
                mainSene.getChildren().add(textLb8);
            }
        });

        mainSene.getChildren().addAll(menuButton, textLb1, titleField, textLb2, pubField, textLb3, catField, textLb4, lanField, textLb5, dorField, textLb6, nopField, textLb7, norField, btn);
        primaryStage.setScene(scene);
    }

    private void addBookletScene(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.TOP_LEFT);

        root.setCenter(mainSene);

        MenuButton menuButton = menuButton(primaryStage, root, scene, menu, header);

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

        Label textLb8 = new Label("New booklet is added");
        textLb8.setTextFill(Color.web("#2da331"));

        Button btn = new Button("Add");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addBookletToRegister(titleField.getText().trim(), pubField.getText().trim(), catField.getText().trim(), lanField.getText().trim(), dorField.getText().trim(), Integer.parseInt(nopField.getText().trim()));
                mainSene.getChildren().add(textLb8);
            }
        });

        mainSene.getChildren().addAll(menuButton, textLb1, titleField, textLb2, pubField, textLb3, catField, textLb4, lanField, textLb5, dorField, textLb6, nopField, btn);
        primaryStage.setScene(scene);
    }

    private void addBookScene(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.TOP_LEFT);

        root.setCenter(mainSene);

        MenuButton menuButton = menuButton(primaryStage, root, scene, menu, header);

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
        primaryStage.setScene(scene);
    }

    /**
     * Prints all avalible literature in the given iterator.
     *
     * @param iterator the iterator (that returns/holds a collection) to go
     * through and print.
     * @param emptyCollectionMessage the message to print when there is nothing
     * to print
     */
    private void listLiteratureScene(Stage primaryStage, BorderPane root, Scene scene, Iterator iterator, String emptyCollectionMessage) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12));
        mainSene.setAlignment(Pos.CENTER);
        root.setCenter(mainSene);

        Iterator<Literature> it = iterator;
        if (!it.hasNext()) {
            System.out.println(emptyCollectionMessage);
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
        primaryStage.setScene(scene);
    }
    
    private void removeLiteratureScene(Stage primaryStage, BorderPane root, Scene scene){
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
                    System.out.println("Please enter a literature title in the field");
                    Label message = new Label("Please enter a literature title in the field");
                    message.setTextFill(Color.web("#ff0000"));
                    mainSene.getChildren().add(message);
                }
            }
        });
        mainSene.getChildren().addAll(textLbl2,textField,search);
        primaryStage.setScene(scene);
    }

    /**
     * Removes literature with given tittle from register.
     */
    private void removeLiteratureByTitle(String literatureTitle, VBox mainScene) {
        Iterator<Literature> it = this.register.getLiteraureIterator();
        String message = "";
        String messageColor = "";
        Label feedBack;
        if (!it.hasNext()) {
            System.out.println("Register is empty! There are no literature to remove.");
            message = "Register is empty! There are no literature to remove.";
            messageColor = "#ff0000";
        }
        else {
            System.out.println("Insert the title of the literature to remove:");
            
            Literature literatureToRemove = register.getLiteratureByTitle(literatureTitle);
            if (literatureToRemove != null) {
                System.out.println(literatureToRemove.getTitle() + " Has been removed");
                message = literatureToRemove.getTitle() + " Has been removed";
                messageColor = "#2da331";
                register.removeByTitleContains(literatureToRemove.getTitle());
            } 
            else {
                System.out.println("No literature with this title found to remove");
                message = "No literature with this title found to remove";
                messageColor = "#ff0000";
            }
        }
        feedBack = new Label(message);
        feedBack.setTextFill(Color.web(messageColor));
        mainScene.getChildren().addAll(feedBack);
    }
    
    
    private void searchLiteratureScene(Stage primaryStage, BorderPane root, Scene scene){
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
        primaryStage.setScene(scene);
    }
    
    /**
     * Searches the register by title and publisher and prints found literature.
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
    
    private void addToCartScene(Stage primaryStage, BorderPane root, Scene scene){
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
        primaryStage.setScene(scene);
    }
    
    
    private void removeFromCartScene(Stage primaryStage, BorderPane root, Scene scene){
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
                    System.out.println("Please enter a literature title in the field");
                    Label message = new Label("Please enter a literature title in the field");
                    message.setTextFill(Color.web("#ff0000"));
                    mainSene.getChildren().add(message);
                }
            }
        });
        mainSene.getChildren().addAll(textLbl2,textField,search);
        primaryStage.setScene(scene);
    }
    
    /**
     * Removes literature with given tittle from register.
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
                System.out.println(literatureToRemove.getTitle() + " Has been removed");
                message = literatureToRemove.getTitle() + " Has been removed";
                messageColor = "#2da331";
                cart.removeFromCart(literatureToRemove.getTitle());
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
}