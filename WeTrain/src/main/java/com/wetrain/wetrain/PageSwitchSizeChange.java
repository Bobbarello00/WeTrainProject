package com.wetrain.wetrain;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class PageSwitchSizeChange {

    public static void pageSwitch(Button button, String page, String path, boolean closeOldStage) throws IOException {
        Stage newStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(WeTrain.class.getResource("MainPane.fxml")));
        BorderPane pane = (BorderPane) root;

        if(!closeOldStage) {
            //TODO Non posso cliccare bottoni del menù Home alla chiusura di AddExercise
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.initModality(Modality.APPLICATION_MODAL);
            newStage = (Stage) alert.getDialogPane().getScene().getWindow();
        }else {
            MainPane.setInstance((BorderPane) root);
            newStage = new Stage();
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        }
        Scene newScene = new Scene(root);
        newScene.getStylesheets().add(Objects.requireNonNull(WeTrain.class.getResource("WeTrainStyle.css")).toExternalForm());
        pageLauncher(newStage, newScene);
        PageSwitchSimple.switchPage(pane, page, path);

        newStage.show();
    }

    static void pageLauncher(Stage newStage, Scene newScene) {
        newStage.setTitle("WeTrain");
        newStage.getIcons().add(new Image("file:src/main/resources/Images/WeTrainLogo.png"));
        newStage.setScene(newScene);
        newStage.setResizable(false);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newScene.setFill(Color.TRANSPARENT);
    }
}
