package ladder.domain.prize;

import ladder.exception.ErrorMessage;
import ladder.exception.NameLengthOutOfRangeException;
import ladder.util.StringUtil;

import java.util.Objects;

public class Prize {

    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;

    private Prize(final String name) {
        verifyName(name);
        this.name = name;
    }

    public static Prize of(final String name) {
        return new Prize(name);
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
        if (!(o instanceof Prize)) return false;
        Prize prize = (Prize) o;
        return Objects.equals(name, prize.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
