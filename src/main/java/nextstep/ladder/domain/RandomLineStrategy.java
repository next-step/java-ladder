package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineStrategy implements LineStrategy {
    @Override
    public Line execute(int countPole) {
        List<Point> points = new ArrayList<>();
        Random random = new Random();

        points.add(getLeftSideRandomPoint(random));

        for (int i = 1; i < countPole - 1; i++) {
            points.add(
                    getNextRandomMiddlePoint(points.get(i - 1).getMoveDirection(),
                    random)
            );
        }

        points.add(getRightSidePoint(points.get(countPole - 2).getMoveDirection()));

        return Line.of(points);
    }

    private Point getLeftSideRandomPoint(Random random) {
        if (random.nextBoolean()) {
            return LeftSidePoint.create(MoveDirection.RIGHT);
        }

        return LeftSidePoint.create(MoveDirection.STAY);
    }

    private Point getNextRandomMiddlePoint(MoveDirection beforeDirection, Random random) {
        if (beforeDirection.equals(MoveDirection.RIGHT)) {
            return MiddlePoint.create(beforeDirection, MoveDirection.LEFT);
        }

        if (random.nextBoolean()) {
            return MiddlePoint.create(beforeDirection, MoveDirection.RIGHT);
        }

        return MiddlePoint.create(beforeDirection, MoveDirection.STAY);
    }

    private Point getRightSidePoint(MoveDirection beforeDirection) {
        if (beforeDirection.equals(MoveDirection.RIGHT)) {
            return RightSidePoint.create(beforeDirection, MoveDirection.LEFT);
        }

        return RightSidePoint.create(beforeDirection, MoveDirection.STAY);
    }
}
