package com.wetrain.wetrain.Controllers.Nutritionist;

import com.wetrain.wetrain.Controllers.ListPopulate;
import com.wetrain.wetrain.PageSwitchSimple;
import com.wetrain.wetrain.PageSwitchSizeChange;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NutritionistsHomeController implements Initializable {
    @FXML
    private ImageView logo;
    @FXML
    private Button logoutButt;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button editButt;
    @FXML
    private ListView dietsList;
    @FXML
    private ListView requestsList;
    @FXML
    private Button createDietButt;
    @FXML
    private Button manageAppointmentsButt;
    @FXML
    private Button manageRequestsButt;
    @FXML
    private Button manageDietsButt;
    @FXML
    void logoutButtonAction() throws IOException {
        PageSwitchSizeChange.pageSwitch(logoutButt, "Launcher/WeTrainGUI");}
    @FXML
    void logoAction() throws IOException {
        PageSwitchSimple loader = new PageSwitchSimple();
        Pane view = loader.getPage("NutritionistsHome", "Nutritionists");
        mainPane.setCenter(view);
    }
    @FXML
    void manageAppointmentsButtonAction() throws IOException {
        PageSwitchSimple loader = new PageSwitchSimple();
        Pane view = loader.getPage("ManageAppointmentsNutritionists", "Nutritionists");
        mainPane.setCenter(view);
    }
    @FXML
    void manageRequestsButtonAction() throws IOException {
        PageSwitchSimple loader = new PageSwitchSimple();
        Pane view = loader.getPage("ManageRequestsNutritionists", "Nutritionists");
        mainPane.setCenter(view);
    }
    @FXML
    void manageDietsButtonAction() throws IOException {
        PageSwitchSimple loader = new PageSwitchSimple();
        Pane view = loader.getPage("ManageDietsNutritionists", "Nutritionists");
        mainPane.setCenter(view);
    }
    @FXML
    void editButtonAction() {
        System.out.println("Edit");
    }
    @FXML
    void createDietButtonAction() {
        System.out.println("Create New Diet");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListPopulate.populateList(10,dietsList,true);
        ListPopulate.populateList(10,requestsList,true);
    }
}
