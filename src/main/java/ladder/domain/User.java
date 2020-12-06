package ladder.domain;


import ladder.ladderexceptions.InvalidUserNameException;

public class User {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String DENIED_NAME = "all";

    private final String name;

    public User(String name) {
        validateName(name);

        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH || name.equals(DENIED_NAME)) {
            throw new InvalidUserNameException();
        }
    }

    public String getName() {
        return this.name;
    }
}
