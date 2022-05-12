package viewone.graphical_controllers.trainers;

import controller.StartLessonController;
import exception.DBUnreachableException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import viewone.bean.CourseBean;
import viewone.bean.StartLessonBean;
import viewone.engeneering.AlertFactory;
import viewone.graphical_controllers.AbstractFormGUIController;

import java.sql.SQLException;

public class StartLessonGUIController extends AbstractFormGUIController {
    @FXML private TextField urlTextField;

    private final StartLessonController startLessonController = new StartLessonController();
    private CourseBean courseBean;

    @Override protected void sendAction() {
        if(!(urlTextField.getText().startsWith("https://meet.google.com/"))){
            AlertFactory.newWarningAlert("URL NOT FROM GOOGLE MEET!",
                    "Invalid Url",
                    "The inserted url seems not to be from google meet, try again.");
        }else {
            try {
                startLessonController.startLesson(new StartLessonBean(
                        courseBean,
                        urlTextField.getText()));
            } catch (DBUnreachableException e) {
                e.alert();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close();
    }

    public void setCourse(CourseBean courseBean) {
        this.courseBean = courseBean;
    }
}