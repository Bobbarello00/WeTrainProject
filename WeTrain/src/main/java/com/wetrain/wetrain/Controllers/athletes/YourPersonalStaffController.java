package com.wetrain.wetrain.controllers.athletes;

import com.wetrain.wetrain.PageSwitchSizeChange;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class YourPersonalStaffController {
    private static final String HOME = "athletes";
    @FXML
    private Button appointmentRequestButton;
    @FXML
    private Button consultationRequestButton;
    @FXML
    private Button dietRequestButton;
    @FXML
    private Button editButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button nutritionistCertificationsButton;
    @FXML
    private Label nutritionistName;
    @FXML
    private Button staffButton;
    @FXML
    private Button trainerCertificationsButton;
    @FXML
    private Label trainerName;
    @FXML
    private Button workoutRequestButton;
    //TODO Implementare metodi
    @FXML
    void trainerCertificationsButtonAction() {

    }
    @FXML
    void workoutRequestButtonAction() {

    }
    @FXML
    void nutritionistCertificationsButtonAction() {

    }
    @FXML
    void dietRequestButtonAction() {

    }
    @FXML
    void appointmentRequestButtonAction() throws IOException {
        PageSwitchSizeChange.pageSwitch(appointmentRequestButton, "RequestForm", HOME, false);
    }
    @FXML
    void consultationRequestButtonAction() throws IOException {
        PageSwitchSizeChange.pageSwitch(consultationRequestButton, "RequestForm", HOME, false);
    }
    @FXML
    void editButtonAction() throws IOException {
        PageSwitchSizeChange.pageSwitch(editButton, "YourProfileAthletes", HOME, false);
    }
    @FXML
    void logoutButtonAction() throws IOException {
        PageSwitchSizeChange.pageSwitch(logoutButton, "WeTrainGUI", "launcher",true);
    }
    @FXML
    protected void closeAction(){
        ((Stage) logoutButton.getScene().getWindow()).close();
    }
}
