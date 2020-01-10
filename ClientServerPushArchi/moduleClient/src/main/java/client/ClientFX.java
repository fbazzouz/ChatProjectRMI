package client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class ClientFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url = new File("src/main/java/client/Views/chat.fxml").toURI().toURL();
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/client/Views/chat.fxml"));
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("EmaChat");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);


    }
}
