package ladder;


import ladder.ladderexceptions.InvalidUserNameException;

public class User {
    private final String name;

    public User(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new InvalidUserNameException();
        }

        this.name = name;
    }
}
