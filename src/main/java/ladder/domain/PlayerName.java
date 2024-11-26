package ladder.domain;

import ladder.exception.InvalidNameException;

import java.util.Objects;

public class PlayerName {
    public static final String NOT_ALLOW_EMPTY_NAME_MESSAGE = "이름에 공백이 들어갈 수 없습니다.";
    public static final String NOT_ALLOW_EXCEED_MAX_NAME_LENGTH_MESSAGE = "이름을 5글자를 초과할수 없습니다.";
    public static final String NOT_ALLOWED_ALL_KEYWORD_MESSAGE = "이름은 all 이 될 수 없습니다. (all; 예약어)";
    public static final int DEFAULT_MAX_NAME_LENGTH = 5;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String NAME_EMPTY_STRING = "";
    public static final String PLAYER_NAME_ALL = "all";

    private final String name;

    public PlayerName(String name) {
        if (name == null || name.equals(NAME_EMPTY_STRING)) {
            throw new InvalidNameException(NOT_ALLOW_EMPTY_NAME_MESSAGE);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameException(NOT_ALLOW_EXCEED_MAX_NAME_LENGTH_MESSAGE);
        }
        if (name.trim().equalsIgnoreCase(PLAYER_NAME_ALL)) {
            throw new InvalidNameException(NOT_ALLOWED_ALL_KEYWORD_MESSAGE);
        }
        this.name = name;
    }

    public int length() {
        return name.length();
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName playerName1 = (PlayerName) o;
        return Objects.equals(name, playerName1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
