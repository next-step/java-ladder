package nextstep.domain;

public class Participant {

    private final String name;

    public Participant(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
