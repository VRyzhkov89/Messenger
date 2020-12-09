package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextArea chatHistory;
    @FXML
    private Button sendButton;
    @FXML
    private TextField textField;

@FXML
    public void onClickAction(ActionEvent actionEvent) {
    chatHistory.appendText(textField.getText());
    chatHistory.appendText(System.lineSeparator());
    textField.clear();
    }
}
