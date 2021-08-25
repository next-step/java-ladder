package ladder.domain.ladder;

import ladder.utils.StringUtil;

import java.util.Objects;

public class Name {

    private static final int LIMIT_LENGTH = 5;
    private static final int ZERO = 0;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateBlank(value);
        validateLength(value);
    }

    private void validateLength(String value) {
        if (value.trim().length() > LIMIT_LENGTH) {
            throw new AwardNameException(value.trim().length());
        }
    }

    private void validateBlank(String value) {
        if (StringUtil.isBlank(value)) {
            throw new AwardNameException(ZERO);
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
