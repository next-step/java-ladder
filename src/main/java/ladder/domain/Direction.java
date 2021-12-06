package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static List<Direction> of(int size) {
        Random random = new Random();

        List<Direction> directions = new ArrayList<>();
        directions.add(new Direction(false, random.nextBoolean()));

        for (int i = 1; i < size; i++) {
            if (directions.get(i-1).isRight() || directions.get(i-1).isLeft()) {
                directions.add(new Direction(false, false));
            } else {
                directions.add(new Direction(random.nextBoolean(), random.nextBoolean()));
            }
        }
        return directions;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
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
