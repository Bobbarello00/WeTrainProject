package viewtwo.graphical_controllers.athletes;

import javafx.fxml.FXML;
import viewtwo.PageSwitchSimple;

import java.io.IOException;

public class AthletesHomeGUIController {

    @FXML void coursesButtonAction() throws IOException {
        PageSwitchSimple.switchPage("CoursesPage", "athletes");
    }

    @FXML void trainerButtonAction() throws IOException {
        PageSwitchSimple.switchPage("TrainerPage", "athletes");
    }

    @FXML void workoutPlanButtonAction() throws IOException {
        PageSwitchSimple.switchPage("TrainingPage", "athletes");
    }

}

