package ladder.domain.participant;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.regex.Pattern;

public class Participant {

    public static final int MAX_LENGTH = 5;

    private String name;

    public Participant(String name) {
        if (!validCharacters(name)) {
            throw new CustomException(ErrorCode.INVALID_PARTICIPANTS_INPUT);
        }
        if (!validNameLength(name)) {
            throw new CustomException(ErrorCode.INVALID_PARTICIPANTS_NAME);
        }
        this.name = name;
    }

    private boolean validNameLength(String name) {
        return name.length() <= MAX_LENGTH;
    }

    private boolean validCharacters(String participantString) {
        return Pattern.matches("[A-Za-z, ]+", participantString);
    }

    public String name() {
        return this.name;
    }
}
