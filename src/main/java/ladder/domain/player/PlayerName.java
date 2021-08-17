package ladder.domain.player;

import ladder.exception.InvalidNameLengthException;
import ladder.utils.StringUtils;

public class PlayerName {

    public static final int MAX_LENGTH = 5;

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

    public String value() {
        return name;
    }

    private void validate(String name) {
        if (StringUtils.isNullOrBlank(name)) {
            throw new InvalidNameLengthException();
        }
        if (name.length() > MAX_LENGTH) {
            throw new InvalidNameLengthException();
        }
    }
}
