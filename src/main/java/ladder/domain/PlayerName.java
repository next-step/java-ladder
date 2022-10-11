package ladder.domain;

import java.util.Objects;

public class PlayerName {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public PlayerName(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자이하 이어야 합니다");
        }

        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerName)) return false;

        PlayerName that = (PlayerName) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PlayerName{" +
                "name='" + name + '\'' +
                '}';
    }
}
