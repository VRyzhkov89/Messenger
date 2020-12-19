package client.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.List;

public class EchoClient extends Application {

    public static final List<String> USERS_TEST_DATA = List.of("Vova","Olga","Max");


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Чатик");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        Network network = new Network();
        if (!network.connect()) {
            showNetworkError("");
        }
    }




    public static void main(String[] args) {
        launch(args);
    }
}
