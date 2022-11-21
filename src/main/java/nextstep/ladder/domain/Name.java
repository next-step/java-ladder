package nextstep.ladder.domain;

import nextstep.ladder.exception.IllegalNameLengthException;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH_NAME = 5;

    private String name;

    public Name(String name) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new IllegalNameLengthException("이름은 5자를 초과할 수 없습니다");
        }
        this.name = name;
    }

    public String name() {
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
}
