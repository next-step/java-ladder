package ladder.domain;

import java.util.InputMismatchException;
import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new InputMismatchException("이름의 길이는 1-5사이로 입력해주세요.");
        }
        return name;
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
