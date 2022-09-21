package Graphics;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainScene extends Application {
    
    
    public static void main(String[] args) {
        launch(args);
    }

   @Override
   public void start(Stage primaryStage) throws Exception {

       Button btn = new Button();
       btn.setText("Test");
       btn.setOnAction(new EventHandler<ActionEvent>() {
           
           public void handle(ActionEvent event)
           {
               System.out.println("Hello World");
           }
       });

       StackPane root = new StackPane();
       root.getChildren().add(btn);

       Scene scene = new Scene(root);

       primaryStage.setTitle("Hello World!");
       primaryStage.setScene(scene);
       primaryStage.show();
       primaryStage.setHeight(500);
       primaryStage.setWidth(500);
   }
}
