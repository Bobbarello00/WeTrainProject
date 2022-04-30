package viewone.engeneering;

import controller.SatisfyWorkoutRequestsController;
import controller.TrainerExercisesManagementController;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import viewone.DaysOfTheWeekButtonController;
import viewone.PageSwitchSizeChange;
import viewone.bean.ExerciseBean;
import viewone.bean.ExerciseForWorkoutPlanBean;
import viewone.graphical_controllers.trainers.ExerciseOverviewGUIController;

import java.io.IOException;
import java.util.List;

public class ManageExerciseList {

    public static void setListener(ListView<ExerciseBean> exerciseList, DaysOfTheWeekButtonController daysController, SatisfyWorkoutRequestsController satisfyWorkoutRequestsController) {
        exerciseList.getSelectionModel().selectedItemProperty().
                addListener(new ChangeListener<>() {
                    @Override
                    public void changed(ObservableValue<? extends ExerciseBean> observableValue, ExerciseBean oldItem, ExerciseBean newItem) {
                        listEvent(newItem, daysController, exerciseList, satisfyWorkoutRequestsController);
                    }
                });
    }

    private static void listEvent(ExerciseBean newItem, DaysOfTheWeekButtonController daysController, ListView<ExerciseBean> exerciseList, SatisfyWorkoutRequestsController satisfyWorkoutRequestsController) {
        try {
            if(newItem != null){
                ExerciseOverviewGUIController exerciseOverviewGUIController =
                        (ExerciseOverviewGUIController) PageSwitchSizeChange.pageSwitch((Stage) null,
                                "ExerciseOverview",
                                "trainers",
                                false);
                exerciseOverviewGUIController.setValues(new ExerciseForWorkoutPlanBean(
                        newItem,
                        daysController.getDay()),
                        satisfyWorkoutRequestsController);
                Platform.runLater(() -> exerciseList.getSelectionModel().clearSelection());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateList(ListView<ExerciseBean> exerciseBeanListView, List<ExerciseBean> exerciseBeanList) {
        ObservableList<ExerciseBean> exerciseBeanObservableList = FXCollections.observableList(exerciseBeanList);
        exerciseBeanListView.setItems(exerciseBeanObservableList);
    }
}
