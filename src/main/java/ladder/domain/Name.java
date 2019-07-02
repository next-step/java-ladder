package ladder.domain;

import java.util.Objects;

public class Name {
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d 글자 이상이어야 합니다.", MIN_NAME_LENGTH));
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d 글짜를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getViewName() {
        StringBuilder name = new StringBuilder(getName());
        while (name.length() < 6) {
            name.append(" ");
        }
        return name.toString();
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
