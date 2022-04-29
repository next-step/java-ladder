package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.Objects;

public final class Name {

    private static final int MAXIMUM_SIZE = 5;

    private final String value;

    private Name(String value) {
        Assert.hasText(value, "name must not be blank");
        validateSize(value);
        this.value = value;
    }

    public static Name from(String value) {
        return new Name(value);
    }

    public String value() {
        return value;
    }

    private void validateSize(String value) {
        if (value.length() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(String.format("name(%s) length must be equal or less than %d", value, MAXIMUM_SIZE));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
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
}
