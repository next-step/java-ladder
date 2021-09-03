package step4.ladderGame.domain.ladder;

import step4.ladderGame.domain.ladder.GenerateDirectionStrategy.GenerateDirectionStrategy;

public final class Point {

    private final int index;
    private final Direction direction;

    private Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }
        if (direction.isLeft()) {
            return index - 1;
        }

        return index;
    }

    public Point next(final GenerateDirectionStrategy generateDirectionStrategy) {
        return new Point(index + 1, direction.next(generateDirectionStrategy));
    }

    public Point next(final Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(final GenerateDirectionStrategy generateDirectionStrategy) {
        return new Point(0, Direction.first(generateDirectionStrategy));
    }

    public boolean hasLeftDirectionLine() {
        return direction.isLeft();
    }

}
