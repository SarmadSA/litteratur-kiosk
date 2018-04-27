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
 * Represents user interface that is responsible for communication with the
 * user.
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
     * Adds new literature of chosen type to register.
     *
     * private void addToRegister() { printAddOptionsMenu(); Scanner reader =
     * new Scanner(System.in); int option = reader.nextInt(); switch (option) {
     * case 1: addBookToRegister(); break; case 2: addNewspaperToRegister();
     * break; case 3: addMagazineToRegister(); break; case 4:
     * addBookletToRegister(); break; default: System.out.println("Unknown
     * commend"); break; } }
     */
    /**
     * Adds new book to register.
     */
    private void addBookToRegister(String title, String publisher, String category, String language, String dateOfRelese, int numberOfPages) {
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
        } else {
            System.out.println("1.Enter the title of the literature to search:");
            String searchTitle = reader.nextLine();

            System.out.println("2.Enter the publisher of the literature to search:");
            String searchPublisher = reader.nextLine();

            Literature literatureTitle = register.getLiteratureByTitle(searchTitle);
            Literature literaturePublisher = register.getLiteratureByPublisher(searchPublisher);

            if (literatureTitle != null && literaturePublisher != null) {
                System.out.println("Found results: \n" + literatureTitle.getTitle() + ", By: "
                        + literaturePublisher.getPublisher());
            } else {
                System.out.println("No literature found!");
            }
        }
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

    private void AddLiteratureScene(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header) {
        VBox mainSene = new VBox(8);
        mainSene.setPadding(new Insets(15, 12, 15, 12)); //top, bottom, right, left
        mainSene.setAlignment(Pos.CENTER);

        root.setCenter(mainSene);

        Label textLbl2 = new Label("Scene 2");
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

        //MenuButton menuButton = menuButton(primaryStage, root, scene, menu, header);

        //mainSene.getChildren().addAll(textLb, menuButton);
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
                            + "Number of pages: " + b.getNumberOfPages() + "\n" + "\n\n";
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
        String submittionMessage = "";
        
        Label feedBack;
        
        Button search = new Button("Find and remove");
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String literatureToRemove = textField.getText().trim();
                if(!literatureToRemove.equals("")){
                    removeLiteratureByTitle(literatureToRemove);
                    //submittionMessage = " been removed";
                }
                else{
                    System.out.println("Please enter a literature title in the field");
                }
            }
        });
        feedBack = new Label(submittionMessage);
        mainSene.getChildren().addAll(textLbl2,textField,search,feedBack);
        primaryStage.setScene(scene);
    }

    /**
     * Removes literature with given tittle from register.
     */
    private void removeLiteratureByTitle(String literatureTitle) {
        Iterator<Literature> it = this.register.getLiteraureIterator();
        if (!it.hasNext()) {
            System.out.println("Register is empty! There are no literature to remove.");
        }
        else {
            System.out.println("Insert the title of the literature to remove:");
            
            Literature literatureToRemove = register.getLiteratureByTitle(literatureTitle);
            if (literatureToRemove != null) {
                System.out.println(literatureToRemove.getTitle() + " Has been removed");
                register.removeByTitleContains(literatureToRemove.getTitle());
            } 
            else {
                System.out.println("Invalid Literature title..");
            }
        }
    }
}