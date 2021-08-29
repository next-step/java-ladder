package nextstep.ladder.domain;

import nextstep.ladder.util.Validation;

import java.util.Objects;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private String name;

    public Name(String name) {
        Validation.isEmptyAndNull(name);
        if (name.equals("all")) {
            throw new IllegalArgumentException("all은 사용 할 수 없는 이름입니다.");
        }

        if (name.trim().length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자만 허용 합니다.");
        }
        this.name = name.trim();
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
        return name;
    }
}
