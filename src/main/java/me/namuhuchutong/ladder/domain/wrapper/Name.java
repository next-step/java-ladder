package me.namuhuchutong.ladder.domain.wrapper;

import java.util.Objects;

public class Name {

    private static final int MAXIMUM_SIZE = 5;
    private static final String ALL = "all";

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isOutOfNameLength(name)) {
            throw new IllegalArgumentException("이름 크기 범위를 벗어났습니다. - " + name);
        }
    }

    private static boolean isOutOfNameLength(String name) {
        return name.length() > MAXIMUM_SIZE || name.isBlank();
    }

    public String getName() {
        return name;
    }

    public boolean isNotAll() {
        return !ALL.equals(this.name);
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
        return this.name;
    }
}
