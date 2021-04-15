package step3.domain;

import java.util.Objects;
import java.util.Random;

public class Location {
    private final boolean left;
    private final boolean right;

    public Location(boolean left, boolean right) {
        validation(left, right);
        this.left = left;
        this.right = right;
    }

    private void validation(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("같은 라인이 생성될 수 없습니다.");
        }
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public static Location first(boolean right) {
        return new Location(false, right);
    }

    public Location next() {
        if (right) {
            return next(false);
        }

        return next(generatePoint());
    }

    public Location next(boolean nextRight) {
        return new Location(this.right, nextRight);
    }

    public Location last() {
        return new Location(this.right, false);
    }
    private boolean generatePoint() {
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return left == location.left && right == location.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "[" + left + ", " + right + "]";
    }

}
