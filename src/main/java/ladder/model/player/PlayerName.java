package ladder.model.player;

import java.util.Objects;

import static ladder.Messages.WARNING_NOT_ALLOWED_NAME_LENGTH;

public class PlayerName {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private String name;

    public PlayerName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static PlayerName of(String name) {
        return new PlayerName(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
