package nextstep.step4.impl;

import java.util.Objects;

public class Participant {
    public static final String NAME_EMPTY_MSG = "참가자의 이름은 비어 있을 수 없습니다.";
    public static final String NAME_OVER_LENGTH_MSG = "참가자의 이름은 5글자를 초과 할 수 없습니다.";
    private final String name;

    public Participant(String name) {
        if (isNullOrEmpty(name)) {
            throw new IllegalArgumentException(NAME_EMPTY_MSG);
        }

        if (isOverFive(name)) {
            throw new IllegalArgumentException(NAME_OVER_LENGTH_MSG);
        }

        this.name = name;
    }

    private boolean isOverFive(String name) {
        return name.length() > 5;
    }

    private boolean isNullOrEmpty(String name) {
        return name == null || name.isEmpty();
    }

    public boolean isSame(String name) {
        return this.name == name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%-6s", this.name);
    }
}
