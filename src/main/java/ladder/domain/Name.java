package ladder.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;

    private final String name;

    private Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("참여자 이름은 최대 " + MAX_LENGTH + "글자까지만 입력가능합니다.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("참여자 이름이 존재하지 않습니다.");
        }
    }

    public static Name from(String name) {
        return new Name(name);
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
}
