package nextstep.ladder.model;

import java.util.Objects;

public final class Participant {

    private static final String EXCEPTION_MESSAGE = "참가자의 이름은 null일 수 없습니다.";

    private final ParticipantName name;

    public Participant(String name) {
        validate(name);
        this.name = new ParticipantName(name);
    }

    public long length() {
        return name.length();
    }

    public void validate(String name) {
        if (name == null) {
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
