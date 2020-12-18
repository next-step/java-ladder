package nextstep.laddergame.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name create(String name){
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름은 null 또는 공백을 입력할 수 없습니다.");
        }
        if (isOverLengthName(name)) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 입력이 가능합니다.");
        }


        return new Name(name);
    }

    private static boolean isOverLengthName(String name) {
        return name.length() > MAX_LENGTH;
    }

    private static boolean isBlank(String name) {
        return Objects.isNull(name) || name.trim().isEmpty();
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

    public String getName() {
        return this.name;
    }
}
