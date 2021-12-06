package ladder.domain;

import java.util.Objects;

public class PlayerName {

    private final String name;

    public PlayerName(String name) {
        if (!(0 < name.length() && name.length() <= 5)) {
            throw new IllegalArgumentException("이름은 5글자를 초과하면 안됩니다.");
        }
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }
}
