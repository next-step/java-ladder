package ladder.entity;

public class Participant {

    private String name;

    public Participant(String name){
        this.name = name.trim();
    }

    public String name() {
        return name;
    }
}
