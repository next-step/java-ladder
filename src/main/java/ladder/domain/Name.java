package ladder.domain;

import ladder.util.Assert;

public class Name {

    private static final String MAX_NAME_MESSAGE = "이름은 1~5자입니다.";
    private static final int MAX_VALUE = 5;
    private static final int MIN_VALUE = 1;

    private final String value;

    public Name(String value) {
        Assert.notNull(value, MAX_NAME_MESSAGE);
        String trimmedString = value.trim();

        if (trimmedString.length() < MIN_VALUE || trimmedString.length() > MAX_VALUE) {
            throw new IllegalArgumentException(MAX_NAME_MESSAGE);
        }
        this.value = trimmedString;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        return value != null ? value.equals(name.value) : name.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

}
