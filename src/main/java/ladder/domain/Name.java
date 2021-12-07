package ladder.domain;

public class Name {

    private static final String MAX_NAME_MESSAGE = "이름은 1~5자입니다.";
    private static final int MAX_VALUE = 5;
    private static final int MIN_VALUE = 1;

    private final String value;

    public Name(String value) {
        if (value == null
                || value.trim().length() < MIN_VALUE
                || value.trim().length() > MAX_VALUE) {
            throw new IllegalArgumentException(MAX_NAME_MESSAGE);
        }
        this.value = value.trim();
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
