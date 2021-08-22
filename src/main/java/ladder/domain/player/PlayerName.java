package ladder.domain.player;

import java.util.Objects;
import ladder.exception.InvalidPlayerNameException;
import ladder.utils.StringUtils;

public class PlayerName {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private PlayerName(String name) {
        validate(name);
        this.name = name;
    }

    public static PlayerName of(String name) {
        return new PlayerName(name);
    }

    public int length() {
        return name.length();
    }

    private void validate(String name) {
        if (StringUtils.isNullOrBlank(name) || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidPlayerNameException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlayerName)) {
            return false;
        }
        PlayerName that = (PlayerName) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "PlayerName{" +
                "name='" + name + '\'' +
                '}';
    }
}
