package model;

public class Participant {
    private static final int LIMIT = 5;
    private String name;

    public Participant(String name) {
        if (name.length() > LIMIT) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
