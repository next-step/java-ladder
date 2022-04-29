package nextstep.ladder.domain;

public class Participant {

    static final int MIN_LENGTH = 1;
    static final int MAX_LENGTH = 5;

    private final String name;

    Participant(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new ParticipantNameException();
        }
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new ParticipantNameException(name);
        }
    }

    public String getName() {
        return name;
    }
}
