package ladder.domain.name;

import ladder.exception.InvalidNameException;
import ladder.utils.StringUtils;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throw new InvalidNameException();
        }

        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new InvalidNameException(name.trim().length(), MAX_NAME_LENGTH);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
