package nextstep.ladder.domain;

import java.util.Objects;

public class Status {

    private boolean left;
    private boolean right;

    private Status(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Status ofFisrt(boolean start) {
        return new Status(false, start);
    }

    public Status createNext(boolean next) {
        return right ? new Status(right, false) : new Status(right, next);
    }

    public Status createLast() {
        return new Status(right, false);
    }

    public int move() {
        return left ? -1 : right ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return left == status.left &&
                right == status.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    public boolean getLeft() {
        return this.left;
    }

    public boolean getRight() {
        return this.right;
    }
}
