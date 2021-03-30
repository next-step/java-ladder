package ladder.entity;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

public class Participant {

    private String name;

    public Participant(String name){
        this.name = verifiedName(name);
    }

    private String verifiedName(String name){
        String trimmedName = name.trim();
        if(trimmedName.length()>5){
            throw new CustomException(ErrorCode.INVALID_PARTICIPANT_NAME_LENGTH);
        }
        return trimmedName;
    }

    public String name() {
        return name;
    }
}
