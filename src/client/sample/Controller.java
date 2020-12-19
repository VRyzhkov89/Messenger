package client.sample;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {
    @FXML
    public ListView<String> usersList;
    @FXML
    private TextArea chatHistory;
    @FXML
    private Button sendButton;
    @FXML
    private TextField textField;
    private Network network;


    @FXML
    public void initialize() {
        usersList.setItems(FXCollections.observableArrayList(EchoClient.USERS_TEST_DATA));
    }

    @FXML
    public void onClickAction(ActionEvent actionEvent) {
        String message = textField.getText();
        appendMessage("Я " + message);
        textField.clear();

        try {
            network.getOutputStream().writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
            String errorMessage = "Failed to send message";
            EchoClient.showNetworkError(e.getMessage(), errorMessage);
        }
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void appendMessage(String message) {
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
    }
}

