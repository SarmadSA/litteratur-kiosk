import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author E-Dev
 */
public class GUI extends Application {
    UserInterface userInterface = new UserInterface();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        HBox hbox = new HBox(8);
        VBox vbox = new VBox(8);
        Button btn = new Button();
        Button btn2 = new Button();
        Label textLbl = new Label("Text:");
        
        btn.setText("Print welcome message");
        btn2.setText("test button");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.print("Button clicked!");
                userInterface.printWelcome();
            }
        });
        
        hbox.getChildren().addAll(btn,btn2,textLbl);
        root.setTop(hbox);
        root.setAlignment(hbox, Pos.CENTER);
        //root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 1000, 600);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
