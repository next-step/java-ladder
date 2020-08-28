package nextstep.ladder.biz;

import java.util.Objects;

public class Chessmen {

    private int location;

    public Chessmen(int location) {
        if (isOnLadder(location)) {
            throw new IllegalArgumentException("말의 위치가 잘 못되었습니다. ");
        }

        this.location = location;
    }

    private boolean isOnLadder(int location) {
        return 0 > location;
    }

    public int getLocation() {
        return location;
    }

    public boolean isHere(int position) {
        return location == position;
    }

    public void moveRight() {
        ++location;
    }

    public boolean isLeft(int position) {
        if (isZeroIndex()) {
            return false;
        }
        return location - 1 == position;
    }

    private boolean isZeroIndex() {
        return location == 0;
    }

    public void moveLeft() {
        --location;
    }

    public static Chessmen location(int value) {
        return new Chessmen(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Chessmen chessmen = (Chessmen) o;
        return location == chessmen.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public String toString() {
        return "Chessmen{" +
                "location=" + location +
                '}';
    }
}
