package ladder.domain.name;

import ladder.exception.ErrorMessage;
import ladder.exception.NameLengthOutOfRangeException;
import ladder.util.StringUtil;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;

    private Name(final String name) {
        verifyName(name);
        this.name = name;
    }

    public static Name of(final String name) {
        return new Name(name);
    }

    private void verifyName(final String name) {
        if (StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new NameLengthOutOfRangeException(name);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
