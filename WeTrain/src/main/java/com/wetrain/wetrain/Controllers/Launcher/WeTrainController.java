package com.wetrain.wetrain.Controllers.Launcher;

import com.wetrain.wetrain.MainPane;
import com.wetrain.wetrain.PageSwitchSimple;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WeTrainController implements Initializable {
    @FXML
    public BorderPane mainPane;
    @FXML
    private Button regButton;
    @FXML
    private Text logInText;
    @FXML
    protected void registerButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"ProfileSelection", "Launcher");
    }
    @FXML
    protected void logInTextAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"Login", "Launcher");
    }
    @FXML
    protected void logInButtonEntered(){
        logInText.setStyle("-fx-fill: rgb(20, 130, 17)");
    }
    @FXML
    protected void logInButtonExited(){
        logInText.setStyle("-fx-fill: rgba(24, 147, 21, 1);");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainPane.setInstance(mainPane);
    }
}
