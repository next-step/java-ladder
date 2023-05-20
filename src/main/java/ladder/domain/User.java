package ladder.domain;

import ladder.exception.OutOfUserNameLengthException;

public class User {
    private final String name;

    public User(String name) {
        validateUsernameLength(name);
        this.name = name;
    }

    private void validateUsernameLength(String name) {
        if(name.length() > 5) {
            throw new OutOfUserNameLengthException();
        }
    }

    public String getName() {
        return this.name;
    }
}
