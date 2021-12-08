package com.wetrain.wetrain.Controllers.Nutritionist;

import com.wetrain.wetrain.Controllers.ListPopulate;
import com.wetrain.wetrain.MainPane;
import com.wetrain.wetrain.PageSwitchSimple;
import com.wetrain.wetrain.PageSwitchSizeChange;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NutritionistsHomeController implements Initializable {
    @FXML
    private ImageView logo;
    @FXML
    private Button logoutButton;
    @FXML
    private Button editButton;
    @FXML
    private ListView dietsList;
    @FXML
    private BorderPane mainPane;
    @FXML
    private ListView requestsList;
    @FXML
    private Button createDietButton;
    @FXML
    private Button manageAppointmentsButton;
    @FXML
    private Button manageRequestsButton;
    @FXML
    private Button manageDietsButton;
    @FXML
    void logoutButtonAction() throws IOException {
        PageSwitchSizeChange.pageSwitch(logoutButton, "Launcher/WeTrainGUI", true);}
    @FXML
    void logoAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"NutritionistsHome", "Nutritionists");
    }
    @FXML
    void manageAppointmentsButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"ManageAppointmentsNutritionists", "Nutritionists");
    }
    @FXML
    void manageRequestsButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"ManageRequestsNutritionists", "Nutritionists");
    }
    @FXML
    void manageDietsButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"ManageDietsNutritionists", "Nutritionists");
    }
    @FXML
    void editButtonAction() {
        System.out.println("Edit");
    }
    @FXML
    void createDietButtonAction() throws IOException {
        PageSwitchSimple.switchPage(MainPane.getInstance(),"NewDiet", "Nutritionists");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainPane.setInstance(mainPane);
        ListPopulate.populateList(10,dietsList,true);
        ListPopulate.populateList(10,requestsList,false);
    }
}
