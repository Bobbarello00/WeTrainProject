package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkoutDay implements Serializable {
    private Integer id;
    private String day;
    private List<Exercise> exerciseList;

    public WorkoutDay(int id, String day, List<Exercise> exerciseList){
        this(day);
        this.id = id;
        addAllExercise(exerciseList);
    }

    public WorkoutDay(String day) {
        this();
        this.day = day;
    }

    private WorkoutDay() {
        exerciseList = new ArrayList<>();
    }

    public List<Exercise> getExerciseList(){
        return exerciseList;
    }

    public void addExercise(Exercise exercise){
        exerciseList.add(exercise);
    }

    public void addAllExercise(List<Exercise> exerciseList){
        this.exerciseList = new ArrayList<>();
        for(Exercise exercise: exerciseList) {
            this.exerciseList.add(new Exercise(
                    exercise.getId(),
                    exercise.getName(),
                    exercise.getInfo(),
                    exercise.getTrainer()
            ));
        }
    }

    public int getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public void removeExercise(String name, String info) {
        for(Exercise exercise: exerciseList) {
            if(Objects.equals(exercise.getName(), name) && Objects.equals(exercise.getInfo(), info)) {
                exerciseList.remove(exercise);
                return;
            }
        }
    }
}
