package ladder.domain;

import ladder.strategy.GeneratorStrategy;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(final Builder directionBuilder) {
        checkValidation(directionBuilder.left, directionBuilder.right);
        this.left = directionBuilder.left;
        this.right = directionBuilder.right;
    }

    private void checkValidation(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("왼쪽과 오른쪽, 둘 다는 없다.");
        }
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(final GeneratorStrategy movingStrategy) {
        return next(movingStrategy.generatePoint(this.right));
    }

    public Direction next(final boolean nextRight) {
        return new Builder()
                .left(this.right)
                .right(nextRight)
                .build();
    }

    public static Direction first(GeneratorStrategy generatorStrategy) {
        return new Builder()
                .left(FALSE)
                .right(generatorStrategy.generatePoint(false))
                .build();
    }

    public Direction last() {
        return new Builder()
                .left(this.right)
                .right(FALSE)
                .build();
    }

    public int nextPoint(int position) {
        if (this.left) {
            position -= 1;
        }
        if (this.right) {
            position += 1;
        }
        return position;
    }

    public static class Builder {
        private boolean left = false;
        private boolean right = false;

        public Builder left(boolean first) {
            this.left = first;
            return this;
        }

        public Builder right(boolean second) {
            this.right = second;
            return this;
        }

        public Direction build() {
            return new Direction(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                right == pair.right;
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
