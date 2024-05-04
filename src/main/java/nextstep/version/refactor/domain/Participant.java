package nextstep.version.refactor.domain;

import java.util.Objects;

public class Participant {
    private final String name;

    public Participant(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 5글자를 초과하면 안됩니다.");
        }
        this.name = name;
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
        return Objects.hashCode(name);
    }
}
