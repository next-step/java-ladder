package ladder.domain;

import java.util.Objects;

public class Location {

    private static final int MIN_POS = 0;

    private int pos;

    private Location(int pos) {
        validate(pos);
        this.pos = pos;
    }

    private void validate(int pos) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException("위치는 " + MIN_POS + "보다 작을 수 없습니다.");
        }
    }

    public static Location at(int pos) {
        return new Location(pos);
    }

    public int atLeft() {
        return pos - 1;
    }

    public int now() {
        return pos;
    }

    public Location toLeft() {
        if (pos == MIN_POS) {
            throw new IllegalStateException("왼쪽으로 이동할 수 없습니다.");
        }
        pos--;
        return this;
    }

    public Location toRight() {
        pos++;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return pos == location.pos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos);
    }
}
