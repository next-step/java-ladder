package nextstep.ladder.model;

import java.util.Objects;

public final class Participant {

    private static final String EXCEPTION_MESSAGE = "참가자의 이름은 null이거나 공백일 수 없습니다.";

    private final ParticipantName name;

    public Participant(String name) {
        validate(name);
        this.name = new ParticipantName(name);
    }

    public String getName() {
        return name.toString();
    }

    public void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
