package ladder.domain;

import java.util.Objects;

public class Name {

    private final String name;

    private Name(String name) {
        this.name = valid(name);
    }

    public static Name of(String name) {
        return new Name(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int length() {
        return name.length();
    }

    public String name() {
        return name;
    }

    private String valid(String name) {
        if (isNotValid(name)) {
            throw new IllegalArgumentException("이름은 빈값일 수 없습니다.");
        }
        return name;
    }

    private boolean isNotValid(String name) {
        return name == null || name.isBlank();
    }

}
