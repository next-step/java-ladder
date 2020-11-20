package step3.ladder;

import step3.exceptions.OutOfRangePlayerNameException;

public class Player {
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String ERROR_INVALID_NAME_LENGTH = "이름은 5자 이내여야 합니다.";

    private final String name;

    public Player(String name) {
        isNameSizeUnder5(name);
        this.name = name;
    }

    public static void isNameSizeUnder5(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new OutOfRangePlayerNameException(ERROR_INVALID_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
