package ladder.game;

import java.util.Objects;

public class Participant {
    private static final int PARTICIPANT_NAME_MAX_LENGTH = 5;
    private static final String PARTICIPANT_NAME_MAX_LENGTH_EXCEPTION_FORMAT = "참여자의 이름은 %d글자를 넘을 수 없습니다";
    private final String name;

    public Participant(String participant) {
        if (participant.length() > PARTICIPANT_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(PARTICIPANT_NAME_MAX_LENGTH_EXCEPTION_FORMAT, PARTICIPANT_NAME_MAX_LENGTH));
        }
        this.name = participant;
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

    @Override
    public String toString() {
        return this.name;
    }
}
