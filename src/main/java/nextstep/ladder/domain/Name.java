package nextstep.ladder.domain;

import nextstep.ladder.util.Validation;

import java.util.Objects;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String UNUSABLE_NAME = "all";
    private String name;

    public Name(String name) {
        this.name = name.trim();
        Validation.isEmptyAndNull(this.name);
        if (UNUSABLE_NAME.equals(this.name)) {
            throw new IllegalArgumentException("all은 사용 할 수 없는 이름입니다.");
        }

        if (this.name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자만 허용 합니다.");
        }

    }

    public String name() {
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

    @Override
    public String toString() {
        return name;
    }
}
