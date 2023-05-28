package nextstep.ladder.domain;

import java.util.Objects;

public class PlayerName {

    private static final String NAME_OVER_LENGTH_ERROR_TEXT = "사람에 이름을 최대5글자까지 가능합니다.";
    private static final int NAME_MAX_LENGTH = 5;

    private final String value;

    public PlayerName(String value) {
        if (value.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_OVER_LENGTH_ERROR_TEXT);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerName that = (PlayerName) o;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

}
