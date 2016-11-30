package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menuUtama.fxml"));
        primaryStage.setTitle("Rajawali Airlines");
        primaryStage.setScene(new Scene(root, 800, 600));
        //primaryStage.getIcons().add(new Image(this.getClass().getResource("airplane.png").toString()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
