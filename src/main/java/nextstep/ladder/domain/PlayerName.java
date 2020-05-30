package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNameEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNameLengthException;

import java.util.Objects;

public class PlayerName {
    private static final int MAX_NAME_VALUE_LENGTH = 5;
    private String nameValue;

    public PlayerName(String nameValue) {
        validation(nameValue);
        this.nameValue = nameValue;
    }

    public int length() {
        return this.nameValue.length();
    }

    public String getNameValue() {
        return this.nameValue;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(nameValue, that.nameValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameValue);
    }

    @Override
    public String toString() {
        return "PlayerName{" +
                "nameValue='" + nameValue + '\'' +
                '}';
    }
}
