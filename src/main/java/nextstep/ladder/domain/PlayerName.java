package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNameEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNameLengthException;

public class PlayerName {
    private static final int MAX_NAME_VALUE_LENGTH = 5;
    private String nameValue;

    public PlayerName(String nameValue) {
        validation(nameValue);
        this.nameValue = nameValue;
    }

    private void validation(String nameValue) {
        nullValidation(nameValue);
        nameLengthValidation(nameValue);
        emptyNameValidation(nameValue);
    }

    private void nullValidation(String nameValue) {
        if (nameValue == null) {
            throw new PlayerNameEmptyException("Player's name must not be null");
        }
    }

    private void nameLengthValidation(String nameValue) {
        if (nameValue.length() > MAX_NAME_VALUE_LENGTH) {
            throw new PlayerNameLengthException("Player's name length muse be smaller than 5");
        }
    }

    private void emptyNameValidation(String nameValue) {
        if (nameValue.trim().isEmpty()) {
            throw new PlayerNameEmptyException("Player's name must not be empty");
        }
    }
}
