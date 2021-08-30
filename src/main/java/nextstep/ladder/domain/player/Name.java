package nextstep.ladder.domain.player;

import java.util.Objects;

public class Name {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자리이 이하로 입력해주세요");
        }

        return new Name(name);
    }

    public String name() {
        return name;
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
}
