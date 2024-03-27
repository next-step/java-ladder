package nextstep.ladder;

import nextstep.ladder.exception.ExceedUserNameLengthException;

public class User {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public User(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (exceedNameLength(name)) {
            throw new ExceedUserNameLengthException(name);
        }
    }

    private boolean exceedNameLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return this.name;
    }
}
