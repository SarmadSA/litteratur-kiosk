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
        Scene scene = new Scene(root, 1000, 600);
        VBox menu = new VBox(8);
        HBox header = new HBox(8);
        
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
        Button btn8 = new Button("Add to card");
        Button btn9 = new Button("Remove from card");
        Button btn10 = new Button("View card");
        
        //vbox.setPrefWidth(200);
        btn1.setMinWidth(150);
        btn2.setMinWidth(150);
        btn3.setMinWidth(150);
        btn4.setMinWidth(150);
        btn5.setMinWidth(150);
        btn6.setMinWidth(150);
        btn7.setMinWidth(150);
        btn8.setMinWidth(150);
        btn9.setMinWidth(150);
        btn10.setMinWidth(150);
        
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
                
        scene1(primaryStage,root,scene,menu,header);
        primaryStage.setTitle("Literatur register");
        primaryStage.show();

        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                autoFillScene(primaryStage,root,scene,menu,header);
                userInterface.fillLiteratureList();
            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                AddLiteratureScene(primaryStage,root,scene,menu,header);
            }
        });
        
    }
    
    private void scene1(Stage primaryStage, BorderPane root, Scene scene, VBox menu, HBox header){
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
}