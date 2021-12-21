package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;

/**
 * LadderLine의 두 점과 현재 위치를 Point로 추상화
 *  - LadderLine에서 위치와 각 점의 방향을 관리
 */
public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        System.out.println("is left? " + direction.isLeft());
        System.out.println("is right? " + direction.isRight());

        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

//    public Point next() {
//        return new Point(index + 1, direction.next());
//    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point next(PointStrategy pointStrategy) {
        return new Point(index + 1, direction.next(pointStrategy));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}