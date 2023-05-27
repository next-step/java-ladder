package step3.domain;

import step3.view.ResultView;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateInput(name);
        this.name = name;
    }

    public static void validateInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값은 빈값일 수 없습니다.");
        }

        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("입력값은 %d자를 넘길 수 없습니다.", MAX_LENGTH));
        }

        if (input.equals(ResultView.ALL)) {
            throw new IllegalArgumentException(String.format("입력값은 %s일 수 없습니다.", ResultView.ALL));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
