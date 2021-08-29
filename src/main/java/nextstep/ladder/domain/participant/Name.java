package nextstep.ladder.domain.participant;

import java.util.Objects;

public class Name {

    private static final int LENGTH_LIMIT = 5;
    private final String value;

    public Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String value) {
        if (emptyValue(value) || lengthExceed(value))
            throw new IllegalStateException();
    }

    private boolean lengthExceed(String value) {
        return value.length() > LENGTH_LIMIT;
    }

    private boolean emptyValue(String value) {
        return "".equals(value) || Objects.isNull(value);
    }

    public String getValue() {
        return value;
    }
}
