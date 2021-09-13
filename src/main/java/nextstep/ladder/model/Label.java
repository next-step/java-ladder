package nextstep.ladder.model;

import java.util.Objects;

public class Label {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Label(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 5자를 넘을 수 없습니다!");
        }

        this.name = name;
    }

    public int length() {
        return name.length();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label1 = (Label) o;
        return name.equals(label1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
