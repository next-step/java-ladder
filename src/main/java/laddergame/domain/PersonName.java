package laddergame.domain;

import java.util.Objects;

public class PersonName {
    String name;

    public PersonName(String name) {
        String temp = name.trim();
        validateName(temp);
        this.name = temp;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 입력될 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 입력할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonName that = (PersonName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
