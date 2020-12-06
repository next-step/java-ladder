package ladder.domain;

import ladder.exception.EmptyNameException;
import ladder.exception.LengthNameException;
import ladder.utils.StringUtil;

public class Name {
    private static final Integer MAX_LENGTH = 5;

    private String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        validate(name);
        return new Name(name);
    }

    private static void validate(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new LengthNameException();
        }

        if (StringUtil.isEmpty(name)) {
            throw new EmptyNameException();
        }
    }

    public String getName() {
        return this.name;
    }
}
