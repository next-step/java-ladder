package nextstep.ladder.domain;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    private void validate(boolean left, boolean right) {
        if(left && right){
            throw new IllegalArgumentException("왼쪽과 오른쪽 둘다 true일 수 없습니다.");
        }
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean right) {
        if(this.right){
            return Direction.of(true, false);
        }
        return Direction.of(false, right);
    }

    public Direction next() {
        if(this.right){
            return Direction.of(true, false);
        }
        return Direction.of(false, RandomGenerator.generateRandomBoolean());
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public Direction last() {
        return of(this.right, false);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Direction pair = (Direction) obj;
        return left == pair.left && right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
