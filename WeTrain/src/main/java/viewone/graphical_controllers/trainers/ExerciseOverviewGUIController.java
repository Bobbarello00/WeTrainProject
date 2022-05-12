package viewone.graphical_controllers.trainers;

import controller.SatisfyWorkoutRequestsController;
import controller.TrainerExercisesManagementController;
import exception.DBUnreachableException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import viewone.MainPane;
import viewone.bean.ExerciseForWorkoutPlanBean;

import java.sql.SQLException;

public class ExerciseOverviewGUIController{

    @FXML private TextArea infoTextArea;
    @FXML private TextField nameText;
    @FXML private Button addButton;
    @FXML private Button deleteButton;

    private ExerciseForWorkoutPlanBean exerciseForWorkoutPlanBean;
    private boolean alreadyAdded = false;

    private NewWorkoutPlanGUIController newWorkoutPlanGUIController;
    private SatisfyWorkoutRequestsController satisfyWorkoutRequestsController;
    private final TrainerExercisesManagementController trainerExercisesManagementController = new TrainerExercisesManagementController();

    @FXML void addOrRemoveAction(ActionEvent event) {
        try{
            if (!alreadyAdded) {
                    satisfyWorkoutRequestsController.addExerciseToPlan(exerciseForWorkoutPlanBean);
            } else {
                    satisfyWorkoutRequestsController.removeExerciseFromDay(exerciseForWorkoutPlanBean);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DBUnreachableException e) {
            e.alertAndLogOff();
            return;
        }
        newWorkoutPlanGUIController.updateSelectedExerciseList();
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
        MainPane.getInstance().setDisable(false);
    }

    @FXML void deleteAction(ActionEvent event) {
        try {
            satisfyWorkoutRequestsController.removeExerciseFromPlan(exerciseForWorkoutPlanBean);
            trainerExercisesManagementController.removeExerciseFromTrainer(exerciseForWorkoutPlanBean);
            newWorkoutPlanGUIController.updateExerciseList();
        } catch (DBUnreachableException e) {
            e.alertAndLogOff();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
        MainPane.getInstance().setDisable(false);
    }

    @FXML protected void closeAction(MouseEvent event){
        ((Stage) ((ImageView)event.getSource()).getScene().getWindow()).close();
        MainPane.getInstance().setDisable(false);
    }

    public void setValues(ExerciseForWorkoutPlanBean exerciseBean, SatisfyWorkoutRequestsController satisfyWorkoutRequestsController, NewWorkoutPlanGUIController newWorkoutPlanGUIController){
        this.exerciseForWorkoutPlanBean = exerciseBean;
        this.newWorkoutPlanGUIController = newWorkoutPlanGUIController;
        this.satisfyWorkoutRequestsController = satisfyWorkoutRequestsController;
        if(satisfyWorkoutRequestsController.checkAlreadyAdded(exerciseForWorkoutPlanBean)){
            addButton.setStyle("-fx-background-color:  rgb(225, 100, 0)");
            addButton.setText("Remove from Selected Day");
            alreadyAdded = true;
            deleteButton.setDisable(true);
            deleteButton.setVisible(false);
        }
        nameText.setText(exerciseBean.getName());
        infoTextArea.setText(exerciseBean.getInfo());
    }

}