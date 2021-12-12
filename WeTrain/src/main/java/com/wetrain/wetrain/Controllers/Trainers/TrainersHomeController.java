package com.wetrain.wetrain.Controllers.Trainers;

import com.wetrain.wetrain.Controllers.ListPopulate;
import com.wetrain.wetrain.MainPane;
import com.wetrain.wetrain.PageSwitchSimple;
import com.wetrain.wetrain.PageSwitchSizeChange;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TrainersHomeController implements Initializable {
    @FXML
    private ImageView logo;
    @FXML
    private Button logoutButton;
    @FXML
    private Button manageLessonsButton;
    @FXML
    private Button createCourseButton;
    @FXML
    private Button createWorkoutButton;
    @FXML
    private Button editButton;
    @FXML
    private ListView<?> coursesList;
    @FXML
    private ListView<?> requestsList;
    @FXML
    private Button yourCollaboratorButton;
    @FXML
    private Button mondayButton;
    @FXML
    private Button tuesdayButton;
    @FXML
    private Button wednesdayButton;
    @FXML
    private Button thursdayButton;
    @FXML
    private Button fridayButton;
    @FXML
    private Button saturdayButton;
    @FXML
    private Button sundayButton;
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
        PageSwitchSimple.switchPage(MainPane.getInstance(),"NewWorkoutPlan", "Trainers");
    }
    @FXML
    void editButtonAction() throws IOException {
        PageSwitchSizeChange.pageSwitch(editButton, "YourProfileTrainersNutritionists", "", false);
    }
    @FXML
    void logoAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"TrainersHome", "Trainers");
    }
    @FXML
    protected void yourCollaboratorButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"YourCollaboratorTrainers", "Trainers");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListPopulate.populateList(10,coursesList,true);
        ListPopulate.populateList(10,requestsList,true);
    }

}
