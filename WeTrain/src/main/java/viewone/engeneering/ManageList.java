package viewone.engeneering;

import controller.CourseManagementAthleteController;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import viewone.PageSwitchSizeChange;
import viewone.bean.CourseBean;
import viewone.bean.IdBean;
import viewone.graphical_controllers.athletes.CourseOverviewGUIController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ManageList {

    private ManageList() {}

    public static void updateList(ListView<CourseBean> courseList, List<CourseBean> courseBeanList) {
        ObservableList<CourseBean> courseObservableList = FXCollections.observableList(courseBeanList);
        courseList.setItems(FXCollections.observableList(courseObservableList));
    }

    public static void setCourseListener(ListView<CourseBean> list, CourseManagementAthleteController courseManagementAthleteController, Button button){
        list.getSelectionModel().selectedItemProperty().
                addListener(new ChangeListener<>() {
                    @Override
                    public void changed(ObservableValue<? extends CourseBean> observableValue, CourseBean oldItem, CourseBean newItem) {
                        eventList(list, newItem, courseManagementAthleteController, button);
                    }
                });
    }

    private static void eventList(ListView<CourseBean> listView, CourseBean newItem, CourseManagementAthleteController courseManagementAthleteController, Button button) {
        try {
            if(newItem != null) {
                CourseOverviewGUIController courseOverviewGUIController = (CourseOverviewGUIController) PageSwitchSizeChange.pageSwitch(button, "CourseOverview", "athletes", false);
                courseOverviewGUIController.setValue(newItem);
                Platform.runLater(() -> listView.getSelectionModel().clearSelection());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
