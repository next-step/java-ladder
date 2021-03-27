package ladder.domain;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.regex.Pattern;

public class Participant {
    private String name;

    public Participant(String name) {
        String trimmedName = name.trim();
        if (!validCharacters(trimmedName)) {
            throw new CustomException(ErrorCode.INVALID_PARTICIPANTS_INPUT);
        }
        if (!validNameLength(trimmedName)) {
            throw new CustomException(ErrorCode.INVALID_PARTICIPANTS_NAME);
        }
        this.name = trimmedName;
    }


    private boolean validNameLength(String name) {
        return name.length() <= 5;
    }

    private boolean validCharacters(String participantString) {
        return Pattern.matches("[A-Za-z, ]+", participantString);
    }

    public String name(){
        return this.name;
    }
}
