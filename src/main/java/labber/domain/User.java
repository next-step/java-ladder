package labber.domain;

import labber.exception.UserNameLengthException;

public class User {
    private final String name;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new UserNameLengthException();
        }
    }

    public String getName() {
        return name;
    }
}
