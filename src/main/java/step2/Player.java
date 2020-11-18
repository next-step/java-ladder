package step2;

import step2.exceptions.OutOfRangePlayerNameException;

public class Player {
    private final String name;

    public Player(String name) {
        isNameSizeUnder5(name);
        this.name = name;
    }

    private void isNameSizeUnder5(String name) {
        if (name.length() > 5) {
            throw new OutOfRangePlayerNameException();
        }
    }
}
