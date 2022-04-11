package viewone.graphical_controllers.launcher;


import controller.RegistrationController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import viewone.AlertFactory;
import viewone.MainPane;
import viewone.PageSwitchSimple;
import viewone.PageSwitchSizeChange;
import viewone.bean.UserBean;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;
import java.util.ResourceBundle;

public class MoreInfoGUIController implements Initializable {
    private static final String HOME = "launcher";
    private char gender;

    private static String selectedProfile;
    @FXML private Button registerButton;
    @FXML private RadioButton maleButton;
    @FXML private RadioButton femaleButton;
    @FXML private RadioButton nogenderButton;
    @FXML private DatePicker birthPicker;
    @FXML private TextField fcText;
    @FXML private TextField firstNameText;
    @FXML private TextField lastNameText;
    @FXML private TextField usernameText;


    private int sendUserInfo(){
        if(!Objects.equals(usernameText.getText(), "")
                & !Objects.equals(firstNameText.getText(), "")
                & !Objects.equals(lastNameText.getText(), "")
                & !Objects.equals(fcText.getText(), "")
                & !Objects.equals(birthPicker.getEditor().getText(), "")){

            UserBean user = new UserBean();
            //TODO lancio di eccezioni invece che ritorno di interi?
            if(!user.setUsername(usernameText.getText())
                || !user.setName(firstNameText.getText())
                || !user.setSurname(lastNameText.getText())){
                return 3;
            }
            if(!user.setFc(fcText.getText())){
                return 2;
            }
            if(!user.setBirth(birthPicker.getEditor().getText())){
               return 1;
            }
            user.setType(selectedProfile);
            user.setGender(gender);
            try {
                RegistrationController.processUserInfo(user);
            }  catch (SQLIntegrityConstraintViolationException e) {
                //TODO duplicate primary key
                System.out.println("Duplicate primary key");
                return 4;
            } catch (SQLException e){
                System.out.println("Errore nel salvataggio dell'utente.");
                return 5;
            }
            return 0;
        } else {
            return -1;
        }
    }

    @FXML private void registerButtonAction() throws IOException {
        int res = sendUserInfo();
        if(res == 0) {
            PageSwitchSizeChange.loadHome(registerButton, selectedProfile + "sHome", selectedProfile + "s");
        } else{
            String alertTitle = "OOPS, SOMETHING WENT WRONG!";
            String alertHeaderText = " ";
            String alertContentText = "Be sure to fill all fields correctly, thanks for your collaboration!";
            //TODO sostituire switch case con try-catch(?)
            switch (res) {
                case (-1) -> alertHeaderText = "Empty fields";
                case (1) -> alertHeaderText = "Birth date not valid";
                case (2) -> alertHeaderText = "Fiscal code not valid";
                case (3) -> {
                    alertHeaderText = "Excessive length in name, surname or username";
                    alertContentText = "Be sure that name or surname are under 45 characters and username is under 20 characters, thanks for your collaboration!";
                }
                case (4) -> {
                    alertHeaderText = "Error in user registration";
                    alertContentText = "Fiscal code, username or email already existing in our database. \n" +
                            "If you already have an account, log in.";
                }
                case (5) -> {
                    alertHeaderText = "Error in our database";
                    alertContentText = "Sorry for the inconvenience";
                }
            }
            AlertFactory.newWarningAlert(alertTitle, alertHeaderText, alertContentText);
        }
    }
    @FXML protected void closeAction(){
        ((Stage) registerButton.getScene().getWindow()).close();
    }

    @FXML private void profileButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"ProfileSelection", HOME);
    }

    @FXML private void homeButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"WeTrainGUI", HOME);
    }

    @FXML private void registrationTextAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(), selectedProfile + "Registration", HOME);
    }

    public static void setSelectedProfileString(String selectedProfileString){
        selectedProfile = selectedProfileString;
    }

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();
        nogenderButton.setToggleGroup(group);
        maleButton.setToggleGroup(group);
        femaleButton.setToggleGroup(group);
        group.selectToggle(nogenderButton);
        group.selectedToggleProperty().addListener(
                (observable, oldToggle, newToggle) -> {
                    if(newToggle == maleButton) {
                        gender = 'm';
                    } else if(newToggle == femaleButton) {
                        gender = 'f';
                    } else {
                        gender = 'x';
                    }
                }
        );
    }
}
