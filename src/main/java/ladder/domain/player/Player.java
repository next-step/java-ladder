package ladder.domain.player;

import ladder.exception.IllegalPlayerNameException;

public class Player {
    private static final int MAX_PLAYER_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        if (name.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalPlayerNameException(String.format("입력한 이름 : %s", name));
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
