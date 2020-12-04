package ladder;


import ladder.ladderexceptions.InvalidUserNameException;

public class User {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public User(String name) {
        validateName(name);

        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new InvalidUserNameException();
        }
    }

    public String getName() {
        return this.name;
    }
}
