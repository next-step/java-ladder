package nextstep.ladder.domain;

public class Name {
    public static final String INVALID_NAME_LENGTH_ERR_MSG = "이름은 1글자 이상 5글자 이하만 허용합니다.";
    private static final int MIN_AVAILABLE_LENGTH = 1;
    private static final int MAX_AVAILABLE_LENGTH = 5;
    public final String value;

    private Name(String value) {
        validateLength(value.length());
        this.value = value;
    }

    public static Name valueOf(String value) {
        return new Name(value);
    }

    private void validateLength(int length) {
        if (length < MIN_AVAILABLE_LENGTH || length > MAX_AVAILABLE_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_ERR_MSG);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;

        Name name = (Name) o;

        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
