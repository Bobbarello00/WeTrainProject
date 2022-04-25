package viewone.bean;

public class ExerciseBean {
    private int id;
    private String name;
    private String info;

    public ExerciseBean(int id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
