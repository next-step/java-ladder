package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final String POINT_CONDITION_EXCEPTION_MESSAGE = "최소 2명이 존재해야 사다리에서 이동이 가능합니다.";

    // points.get(N): N번째 세로줄과 N+1번째 세로줄 사이에 가로선이 존재하는가? (0번부터 시작)
    private final List<Boolean> movingPoints;

    public Line(int countOfPerson) {
        validate(countOfPerson);
        movingPoints = createMovingPoints(countOfPerson - 1);
    }

    public List<Boolean> getMovingPoints() {
        return movingPoints;
    }

    private void validate(int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException(POINT_CONDITION_EXCEPTION_MESSAGE);
        }
    }

    private List<Boolean> createMovingPoints(int numberOfMovingPoints) {
        List<Boolean> points = new ArrayList<>(numberOfMovingPoints);
        Random random = new Random();

        for (int i = 0; i < numberOfMovingPoints; ++i) {
            if (isAdjacentPointExist(points)) {
                points.add(random.nextBoolean());
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
}
