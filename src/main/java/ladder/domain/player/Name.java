package ladder.domain.player;

import ladder.utils.StringUtil;

import java.util.Objects;

public class Name {

    public static final int LIMIT_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validateName(value);
        this.value = value.trim();
    }

    private void validateName(String name) {
        isBlank(name);
        exceedLength(name);
    }

    private void exceedLength(String name) {
        if (name.trim().length() > LIMIT_LENGTH) {
            throw new PlayerNameException();
        }
    }

    private void isBlank(String name) {
        if (StringUtil.isBlank(name)) {
            throw new PlayerNameException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }

}
