package nextstep.ladder.domain;

import java.util.Objects;

public final class PlayerName {

    public static final int MAX_NAME_LENGTH = 5;

    private final String value;

    private PlayerName(final String value) {
        validateValue(value);
        this.value = value.trim();
    }

    public static PlayerName valueOf(final String value) {
        return new PlayerName(value);
    }

    private static void validateValue(final String value) {
        if (value == null) {
            throw new IllegalArgumentException("Player name cannot be null");
        }
        final String trimmedValue = value.trim();
        if (trimmedValue.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be blank");
        }
        if (trimmedValue.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Player name too long");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PlayerName that = (PlayerName) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String getValue() {
        return value;
    }
}
