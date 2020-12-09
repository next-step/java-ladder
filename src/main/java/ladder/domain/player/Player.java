package ladder.domain.player;

import ladder.context.ErrorMessage;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validName(name);
        this.name = name;
    }

    private void validName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_SIZE.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
