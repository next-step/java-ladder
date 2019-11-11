package ladder.game;

public class Participant {
    String name;

    public Participant(String participant) {
        this.name = participant;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
