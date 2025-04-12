package nextstep.ladder.module;

import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final Random RANDOM = new Random();
    private final PointList points;

    public Line(PointList pointList) {
        this.points = pointList;
        validate(points);
    }

    public PointList points() {
        return points;
    }

    private void validate(PointList points) {
        if (points.size() < 2) {
            throw new IllegalArgumentException("Line의 크기는 2 이상이어야 합니다.");
        }
        if (points.get(0).leftBridge().isBuilt()) {
            throw new IllegalArgumentException("Line의 시작은 사다리가 없어야 합니다.");
        }
        if (points.get(points.size() - 1).rightBridge().isBuilt()) {
            throw new IllegalArgumentException("Line의 끝은 사다리가 없어야 합니다.");
        }

        IntStream.range(1, points.size())
                .filter(i -> points.get(i).leftBridge().isBuilt() && points.get(i + 1).leftBridge().isBuilt())
                .findAny()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("Line에서 연속된 사다리가 있으면 안됩니다.");
                });

        IntStream.range(0, points.size() - 1)
                .filter(i -> points.get(i).rightBridge().isBuilt() && points.get(i + 1).rightBridge().isBuilt())
                .findAny().ifPresent(i -> {
                    throw new IllegalArgumentException("Line에서 연속된 사다리가 있으면 안됩니다.");
                });
    }

    public void createLadders() {
        IntStream.range(1, points.size()).filter(i -> !points.get(i - 1).leftBridge().isBuilt())
                .filter(i -> RANDOM.nextBoolean()).forEach(i -> {
                    points.get(i).createLeftBridge();
                    points.get(i - 1).createRightBridge();
                });
    }

    public void createLeftBridge(int index) {
        points.get(index).createLeftBridge();
        points.get(index - 1).createRightBridge();
        validate(points);
    }
}
