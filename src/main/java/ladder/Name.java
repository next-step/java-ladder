package ladder;

import java.util.Objects;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name == null) {
            throw new NullPointerException("이름을 적어주세요.");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("이름을 빈값이나 공백을 허용하지 않습니다..");
        }

        if (MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름은 5자 이하로 적어주세요.");
        }

        this.name = name;
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
