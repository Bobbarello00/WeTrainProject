package viewone.engeneering;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertFactory {

    private AlertFactory() {
    }

    public static boolean newConfirmationAlert(String alertTitle, String alertHeaderText, String alertContentText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(alertTitle);
        alert.setHeaderText(alertHeaderText);
        alert.setContentText(alertContentText);
        alert.setResizable(true);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    public static void newWarningAlert(String alertTitle, String alertHeaderText, String alertContentText){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        newAlert(alert, alertTitle, alertHeaderText, alertContentText);
    }

    private static void newAlert(Alert alert, String alertTitle, String alertHeaderText, String alertContentText) {
        alert.setTitle(alertTitle);
        alert.setHeaderText(alertHeaderText);
        alert.setContentText(alertContentText);
        alert.setResizable(true);
        alert.showAndWait();
    }

    public static void newInformationAlert(String alertTitle, String alertContentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeight(500);
        alert.setWidth(1000);
        newAlert(alert, alertTitle, null, alertContentText);
    }
}
