package nextstep.domain;

import java.util.Objects;

public class Participant {
    private String name;
    private Integer position;

    public Participant(String name) {
        this(name, 0);
    }

    public Participant(String name, Integer position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 다섯글자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public String getName(int length) {
        if (length == 0) {
            return name;
        }

        if (this.name.length() != length) {
            String format = "%" + length + "s";
            return String.format(format, this.name);
        }
        return name;
    }

    public String getName() {
        if (this.name.length() != 5) {
            return String.format("%5s", this.name);
        }
        return name;
    }
}
