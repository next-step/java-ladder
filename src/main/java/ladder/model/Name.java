package ladder.model;

import ladder.common.CommonValue;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        checkValidation(name);
        this.name = name;
    }

    public String get() {
        return this.name;
    }

    private void checkValidation(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 null 이거나 비어있습니다.");
        }
        if(name.length() > CommonValue.NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 " + CommonValue.NAME_MAX_LENGTH + "를 넘으면 안됩니다.");
        }
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