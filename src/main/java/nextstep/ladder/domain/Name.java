package nextstep.ladder.domain;

import nextstep.ladder.dto.NameDto;

import java.util.Objects;

public class Name {

    public static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format("이름은 5자를 초과할 수 없습니다. value=%s", name));
        }
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public NameDto toDto() {
        return new NameDto(name);
    }

    @Override
    public String toString() {
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
