package step3_renewal.domain;


import step3_renewal.exception.EmptyNameException;
import step3_renewal.exception.LengthNameException;
import step3_renewal.utils.StringUtil;

import java.util.Objects;

public class Participant {

    private static final Integer MAX_LENGTH = 5;

    private String participantName;

    private final int position;

    private Participant(String participantName, int position) {
        this.position = position;
        this.participantName = participantName;
    }

    public static Participant of(String participantName, int position) {
        validate(participantName);
        return new Participant(participantName, position);
    }

    public String getParticipantName() {
        return participantName;
    }

    public int getPosition() {
        return position;
    }

    private static void validate(String participantName) {
        if (participantName.length() > MAX_LENGTH) {
            throw new LengthNameException(MAX_LENGTH);
        }

        if (StringUtil.isEmpty(participantName)) {
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
