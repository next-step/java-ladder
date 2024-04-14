package nextstep.ladder.domain.player;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        assertNameNotBlankAndLengthUnderFive(value);

        this.value = value;
    }

    private void assertNameNotBlankAndLengthUnderFive(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1글자에서 5글자까지 입력 가능합니다.");
        }
    }

    public String value() {
        return value;
    }

    public int length() {
        return this.value.length();
    }

    public boolean equals(String name) {
        return this.value.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
