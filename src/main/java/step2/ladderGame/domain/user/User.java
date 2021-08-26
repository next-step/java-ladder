package step2.ladderGame.domain.user;

import step2.ladderGame.domain.exception.NameLengthException;
import step2.ladderGame.domain.exception.NameNullOrEmptyException;

public class User {

    private static final int MIN_LENGTH_BY_NAME = 1;
    private static final int MAX_VALUE_BY_NAME = 5;

    private final String name;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NameNullOrEmptyException();
        }
        if (name.length() < MIN_LENGTH_BY_NAME || name.length() > MAX_VALUE_BY_NAME) {
            throw new NameLengthException();
        }
    }

    public String getName() {
        return name;
    }

}
