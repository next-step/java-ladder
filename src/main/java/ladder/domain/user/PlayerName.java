package ladder.domain.user;

import java.util.Objects;

public class PlayerName {

    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final int MINIMUM_NAME_LENGTH = 1;
    public static final String ERROR_NAME_LENGTH_MSG = "이름은 5글자를 초과하면 안됩니다.";
    public static final String ERROR_NULL_MSG = "1명 이상 입력해주세요";

    private final String name;

    public PlayerName(String name) {
        if (!(MINIMUM_NAME_LENGTH <= name.length() && name.length() <= MAXIMUM_NAME_LENGTH)) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH_MSG);
        }
        if (name.isEmpty()) {
            throw new NullPointerException(ERROR_NULL_MSG);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isSameName(String player) {
        return this.name.equals(player);
    }
}
