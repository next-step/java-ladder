package ladder.domain.data;

import java.util.Objects;

import ladder.domain.exception.LadderException;

import static ladder.domain.data.Ladder.INDENT;

public class Name {

    public static final int NAME_SIZE = 5;
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value.trim();
    }

    private void validate(String value) {
        if (!isValid(value)) {
            throw new LadderException("사람 이름은 1자 이상 5자 이하 입니다.");
        }
    }

    private static boolean isValid(String value) {
        return !value.isEmpty() && value.length() <= NAME_SIZE;
    }

    public String formatted() {
        return INDENT.repeat(NAME_SIZE + 1 - value.length()) + value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Name name = (Name) object;

        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
