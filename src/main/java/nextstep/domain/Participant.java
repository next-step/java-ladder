package nextstep.domain;

import java.util.Objects;

public class Participant {
    private String name;

    public Participant(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 다섯글자를 초과할 수 없습니다.");
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

    public String getName() {
        if (this.name.length() != 5) {
            return String.format("%5s", this.name);
        }
        return name;
    }
}
