package labber.domain;

import labber.exception.UserNameLengthException;

public class User {
    private final String name;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new UserNameLengthException();
        }
    }

    public String getName() {
        return name;
    }
}
