package ladder.domain;

import java.util.Objects;

public class Name {
    private final static int MAX_NAME_LENGTH = 5;
    private final static int MIN_NAME_LENGTH = 1;
    private final static String BLANK = " ";

    private final String value;

    public Name(String input) {
        checkValidName(input);
        this.value = input;
    }

    private void checkValidName(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException("참가자의 이름은 공백을 포함할 수 없습니다.");
        }

        if (!isValidLength(input)) {
            throw new IllegalArgumentException("참가자의 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    private boolean isValidLength(String input) {
        return input.length() >= MIN_NAME_LENGTH && input.length() <= MAX_NAME_LENGTH;
    }

    @Override
    public String toString() {
        return this.value;
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
