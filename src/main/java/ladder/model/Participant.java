package ladder.model;

import ladder.exception.InvalidUsernameException;

public class Participant {

    private static final int MAX_USERNAME_LENGTH = 5;
    private final String username;

    public Participant(String username) {
        validate(username);
        this.username = username;
    }

    private void validate(String username) {
        if (username.length() > MAX_USERNAME_LENGTH) {
            throw new InvalidUsernameException(username);
        }
    }

    public static Participant create(String username) {
        return new Participant(username);
    }

    @Override
    public String toString() {
        return username;
    }
}
