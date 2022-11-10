package nextstep.domain;

import java.util.Objects;

public class Name {

    private static final int MINIMUM_NAME_LENGTH = 5;
    public final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최소 5자 이하로 짧게 쓰여져야 한다.");
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
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
