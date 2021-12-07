package nextstep.ladder.domain.gift;

import nextstep.ladder.domain.exception.InvalidNameLengthException;

import java.util.Objects;

public class Gift {

    private static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public Gift(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH) {
            throw new InvalidNameLengthException(MIN_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift1 = (Gift) o;
        return Objects.equals(name, gift1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
