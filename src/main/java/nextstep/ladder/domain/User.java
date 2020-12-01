package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

public class User {

    private final String name;

    public User(String name) {
        throwIfInvalidName(name);
        this.name = name;
    }

    private void throwIfInvalidName(String name) {
        if (name == null || name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_USER_NAME);
        }
    }

}
