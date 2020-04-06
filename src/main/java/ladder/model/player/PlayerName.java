package ladder.model.player;

import static ladder.Messages.WARNING_NOT_ALLOWED_NAME_LENGTH;

public class PlayerName {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private String name;

    public PlayerName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public int getNameLength(){
        return name.length();
    }
}
