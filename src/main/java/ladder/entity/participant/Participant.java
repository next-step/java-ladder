package ladder.entity.participant;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.Objects;

public class Participant {

    private String name;

    public Participant(String name) {
        this.name = verifiedName(name);
    }

    private String verifiedName(String name) {
        String trimmedName = name.trim();
        if (trimmedName.length() > 5) {
            throw new CustomException(ErrorCode.INVALID_PARTICIPANT_NAME_LENGTH);
        }
        return trimmedName;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
