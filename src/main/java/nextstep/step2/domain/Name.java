package nextstep.step2.domain;

import java.util.Objects;

public class Name {

    private static final int MAXIMUM_NAME_SIZE = 5;

    private final String name;

    public Name(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;

        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
