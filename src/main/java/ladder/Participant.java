package ladder;

public class Participant {
    private Name name;

    public Participant(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }
}
