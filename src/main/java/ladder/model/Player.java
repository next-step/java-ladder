package ladder.model;

import static ladder.Messages.WARNING_NOT_ALLOWED_NAME_LENGTH;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;

    private String name;
    private int location;

    public Player(String name, int location) {
        validateNameLength(name);
        this.name = name;
        this.location = location;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public int findNextLocation(Row nextRow) {
        return 0;
    }
}
