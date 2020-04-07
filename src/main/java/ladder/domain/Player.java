package ladder.domain;

import ladder.exception.PlayerException;

public class Player {

    private static final String NAME_LENGTH_ERR_MSG = "참가자의 이름은 5글자 이하여야 합니다.";

    private final String name;

    public Player(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.length() > 5) {
            throw new PlayerException(NAME_LENGTH_ERR_MSG);
        }
    }

    public String getName() {
        return name;
    }
}
