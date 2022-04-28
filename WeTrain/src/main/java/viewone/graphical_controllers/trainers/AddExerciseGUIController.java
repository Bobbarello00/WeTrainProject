package viewone.graphical_controllers.trainers;

import controller.TrainerExercisesManagementController;
import exception.DBConnectionFailedException;
import viewone.MainPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import viewone.bean.ExerciseBean;

import java.sql.SQLException;

public class AddExerciseGUIController {
    @FXML private Button addButton;
    @FXML private TextArea descriptionTextArea;
    @FXML private TextField nameText;

    private final TrainerExercisesManagementController trainerExercisesManagementController = new TrainerExercisesManagementController();

    @FXML void addButtonAction(ActionEvent event) {
        ExerciseBean exerciseBean = new ExerciseBean(
                nameText.getText(),
                descriptionTextArea.getText());
        try {
            trainerExercisesManagementController.addExerciseToTrainer(exerciseBean);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DBConnectionFailedException e) {
            e.alertAndLogOff();
        }

        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
        MainPane.getInstance().setDisable(false);
    }

    @FXML void cancelButtonAction(ActionEvent event) {
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
        MainPane.getInstance().setDisable(false);
    }
}