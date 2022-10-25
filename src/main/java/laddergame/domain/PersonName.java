package laddergame.domain;

import java.util.Objects;

public class PersonName {

    private static final String ALL = "all";

    private final String name;

    public PersonName(String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 입력될 수 없습니다.");
        }
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 입력할 수 있습니다.");
        }
    }

    public boolean isAll(){
        return ALL.equals(this.name);
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
