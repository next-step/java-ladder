package ladder.domain;

import java.util.Objects;

public class Name {

    private static final int DEFAULT_NAME_SIZE = 5;

    private final String name;

    public Name(String name) {
        validate(name);

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validate(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("비어있거나 공란의 이름은 입력할 수 없습니다.");
        }

        if (name.length() > DEFAULT_NAME_SIZE) {
            throw new IllegalArgumentException("이름은 5글자를 초과하여 입력할 수 없습니다.");
        }
    }

    private boolean isEmpty(String name) {
        return name == null || name.isBlank();
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
        return this.name;
    }
}
