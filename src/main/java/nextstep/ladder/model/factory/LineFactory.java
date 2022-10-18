package nextstep.ladder.model.factory;

import java.util.ArrayList;
import java.util.List;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.strategy.PointPickerStrategy;

public class LineFactory {
    private static final String POINT_CONDITION_EXCEPTION_MESSAGE = "최소 2명이 존재해야 사다리에서 이동이 가능합니다.";

    public static Line create(int countOfPerson, PointPickerStrategy strategy) {
        validate(countOfPerson);
        List<Boolean> movingPoints = createMovingPoints(countOfPerson - 1, strategy);
        return new Line(movingPoints);
    }

    private static void validate(int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException(POINT_CONDITION_EXCEPTION_MESSAGE);
        }
    }

    private static List<Boolean> createMovingPoints(int numberOfMovingPoints, PointPickerStrategy strategy) {
        List<Boolean> points = new ArrayList<>(numberOfMovingPoints);

        for (int i = 0; i < numberOfMovingPoints; ++i) {
            if (isAdjacentPointExist(points)) {
                points.add(strategy.makePoint());
                continue;
            }
            points.add(false);
        }

        return points;
    }

    private static boolean isAdjacentPointExist(List<Boolean> points) {
        if (points.isEmpty()) {
            return true;
        }

        return !points.get(points.size() - 1);
    }
}
