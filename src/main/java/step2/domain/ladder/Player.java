package step2.domain.ladder;

import step2.exceptions.OutOfRangePlayerNameException;

public class Player {
    public static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;

    public Player(String name) {
        isNameSizeUnder5(name);
        this.name = name;
    }

    private void isNameSizeUnder5(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new OutOfRangePlayerNameException();
        }
    }

    public String getName() {
        return name;
    }
}
