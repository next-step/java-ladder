package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nextstep.ladder.model.strategy.PointPickerStrategy;

public class Line {
    private static final String POINT_CONDITION_EXCEPTION_MESSAGE = "최소 2명이 존재해야 사다리에서 이동이 가능합니다.";

    // points.get(N): N번째 세로줄과 N+1번째 세로줄 사이에 가로선이 존재하는가? (0번부터 시작)
    private final List<Boolean> movingPoints;

    public Line(int countOfPerson, PointPickerStrategy strategy) {
        validate(countOfPerson);
        movingPoints = createMovingPoints(countOfPerson - 1, strategy);
    }

    public int move(int position) {
        if (canMoveLeft(position)) {
            return position - 1;
        }
        if (canMoveRight(position)) {
            return position + 1;
        }
        return position;
    }

    public List<Boolean> getMovingPoints() {
        return Collections.unmodifiableList(movingPoints);
    }

    private void validate(int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException(POINT_CONDITION_EXCEPTION_MESSAGE);
        }
    }

    private List<Boolean> createMovingPoints(int numberOfMovingPoints, PointPickerStrategy strategy) {
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

    private boolean isAdjacentPointExist(List<Boolean> points) {
        if (points.isEmpty()) {
            return true;
        }

        return !points.get(points.size() - 1);
    }

    private boolean canMoveLeft(int position) {
        return position > 0 && movingPoints.get(position - 1);
    }

    private boolean canMoveRight(int position) {
        return position < movingPoints.size() && movingPoints.get(position);
    }
}
