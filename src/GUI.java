import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * Represents graphical user interface.
 * 
 * @author Sarmad
 */
public class GUI extends Application {
    UserInterface userInterface = new UserInterface();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        VBox menu = new VBox(8);
        VBox mainSene = new VBox(8);
        HBox hbox = new HBox(8);
        Button btn1 = new Button("Add literature");
        Button btn2 = new Button("List all literature");
        Button btn3 = new Button("Auto Fill register");
        Button btn4 = new Button("Remove literature");
        Button btn5 = new Button("Search register");
        Label textLbl = new Label("Literature Register");
        Scene scene = new Scene(root, 1000, 600);
        Label textLbl2 = new Label("Welcome to the literature register. "
                                   + "\nPlease choose an option from the "
                                   + "\nleft menu to start the application."
                                   + "\n\nApplication created by team 8:\nSarmad Saeed Abbas\nNikita sumahers\nKristin Hagen");
        textLbl.setTextFill(Color.web("#ffffff"));
        textLbl2.setTextFill(Color.web("#0076a3"));

        textLbl.setFont(Font.font("", 18));

        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Adding literature to register..");
                //userInterface.printWelcome();
            }
        });
        
        String cssLayout = "-fx-background-color: #0e6d91;";
        hbox.setStyle(cssLayout);

        //vbox.setPrefWidth(200);
        btn1.setMinWidth(150);
        btn2.setMinWidth(150);
        btn3.setMinWidth(150);
        btn4.setMinWidth(150);
        btn5.setMinWidth(150);
        
        //Page title
        hbox.getChildren().addAll(textLbl);
        hbox.setPadding(new Insets(20, 12, 20, 12)); //top, bottom, right, left
        root.setTop(hbox);
        hbox.setAlignment(Pos.CENTER);
        
        //selection menu
        menu.setStyle("-fx-background-color: #d7dae0;");
        menu.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
        menu.setPadding(new Insets(15, 12, 15, 12)); //top, bottom, right, left
        root.setLeft(menu);
        
        //Main sene
        mainSene.getChildren().addAll(textLbl2);
        mainSene.setPadding(new Insets(15, 12, 15, 12)); //top, bottom, right, left
        mainSene.setAlignment(Pos.CENTER);
        root.setCenter(mainSene);
        //root.getChildren().add(btn);
        
        primaryStage.setTitle("Literatur register");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
