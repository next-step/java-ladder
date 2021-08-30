package ladder.domain;

import java.util.Objects;

public class Location {

    private static final int MIN_POSITION = 0;

    private int position;

    private Location(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("위치는 " + MIN_POSITION + "보다 작을 수 없습니다.");
        }
    }

    public static Location at(int position) {
        return new Location(position);
    }

    public int atLeft() {
        return position - 1;
    }

    public int now() {
        return position;
    }

    public Location toLeft() {
        if (position == MIN_POSITION) {
            throw new IllegalStateException("왼쪽으로 이동할 수 없습니다.");
        }
        position--;
        return this;
    }

    public Location toRight() {
        position++;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return position == location.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
