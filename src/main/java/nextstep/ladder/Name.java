package nextstep.ladder;

import java.util.Objects;

public class Name {
    private final String name;

    private  Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 null 또는 빈 문자열일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하이어야 합니다.");
        }
        return new Name(name);
    }

    public String get() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
