package nextstep.ladder.model;

import nextstep.common.Assert;

final class Name {

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

    private void validateSize(String value) {
        if (value.length() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(String.format("name(%s) length must be equal or less than %d", value, MAXIMUM_SIZE));
        }
    }
}
