package ladder.domain;

import java.util.Objects;

public final class PersonName {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String MAX_NAME_LENGTH_ERROR_MESSAGE =
            String.format("사람 이름은 %d글자까지 입력 가능합니다.", MAX_NAME_LENGTH);

    private final String name;

    public PersonName(final String name) {
        validateNameLength(name);

        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonName that = (PersonName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}