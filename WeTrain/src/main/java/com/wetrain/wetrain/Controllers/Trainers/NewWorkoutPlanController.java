package com.wetrain.wetrain.Controllers.Trainers;

import com.wetrain.wetrain.Controllers.ListPopulate;
import com.wetrain.wetrain.DaysOfTheWeekController;
import com.wetrain.wetrain.MainPane;
import com.wetrain.wetrain.PageSwitchSimple;
import com.wetrain.wetrain.PageSwitchSizeChange;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewWorkoutPlanController implements Initializable {

    private DaysOfTheWeekController daysController = new DaysOfTheWeekController();
    @FXML
    private ImageView logo;
    @FXML
    private Button logoutButton;
    @FXML
    private ListView exercisesList;
    @FXML
    private ListView exercisesSelectedList;
    @FXML
    private Button manageLessonsButton;
    @FXML
    private Button createButton;
    @FXML
    private Button createCourseButton;
    @FXML
    private Button createWorkoutButton;
    @FXML
    private Button editButton;
    @FXML
    private Button manageRequestsButton;
    @FXML
    void logoutButtonAction() throws IOException {
        PageSwitchSizeChange.pageSwitch(logoutButton, "WeTrainGUI", "Launcher", true);
    }
    @FXML
    protected void closeAction(){
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void manageLessonsButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"ManageLessonsTrainers", "Trainers");
    }
    @FXML
    void createCourseButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"NewCourse", "Trainers");
    }
    @FXML
    void createWorkoutButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"TrainersHome", "Trainers");
    }
    @FXML
    void manageRequestsButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"ManageRequestsTrainers", "Trainers");
    }
    @FXML
    void editButtonAction() {System.out.println("Edit");}
    @FXML
    void logoAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"TrainersHome", "Trainers");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListPopulate.populateList(10,exercisesList,false);
        ListPopulate.populateList(10,exercisesSelectedList,false);
    }
    @FXML
    public void addExerciseTextAction() throws IOException {
        PageSwitchSizeChange.pageSwitch(logoutButton, "AddExercise", "Trainers", false);
    }
    @FXML
    void dayButtonAction(ActionEvent event) {
        daysController.dayButtonAction(event);
    }
    @FXML
    void createButtonAction() {
        System.out.println("Created");
    }
}
