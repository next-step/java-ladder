package ladder.domain;

public class PlayerCount {
    public static final String INVALID_VALUE_MESSAGE = "플레이어는 2명 이상입니다.";

    private static final int MIN_VALUE = 2;

    private final int value;

    public PlayerCount(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayerCount position = (PlayerCount) o;

        return value == position.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
