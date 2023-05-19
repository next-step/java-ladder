package refactoring.domain;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(final String name) {
        validateLength(name.length());
        this.name = name;
    }

    private void validateLength(final int length) {
        if (length > 5) {
            throw new IllegalArgumentException("이름의 길이는 5자 이하여야 합니다.");
        }
    }

    public String get() {
        return name;
    }
}
