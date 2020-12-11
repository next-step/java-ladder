package step3.domain;

import step3.exception.EmptyNameException;
import step3.exception.LengthNameException;
import step3.utils.StringUtil;

import java.util.Objects;

public class Participant {

    private static final Integer MAX_LENGTH = 5;

    private final String participantName;

    private final Point position;

    private Participant(String participantName, Point position) {
        this.participantName = participantName;
        this.position = position;
    }

    public static Participant of(String participantName, Point position) {
        validate(participantName);
        return new Participant(participantName, position);
    }

    public String getName() {
        return participantName;
    }

    public Point getPosition() {
        return position;
    }

    private static void validate(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new LengthNameException();
        }

        if (StringUtil.isEmpty(name)) {
            throw new EmptyNameException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(participantName, that.participantName) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantName, position);
    }
}
