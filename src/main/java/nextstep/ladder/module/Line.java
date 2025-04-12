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
        if (points.get(0).bridge().isBuilt()) {
            throw new IllegalArgumentException("Line의 시작은 사다리가 없어야 합니다.");
        }
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).bridge().isBuilt() && points.get(i + 1).bridge().isBuilt()) {
                throw new IllegalArgumentException("Line에서 연속된 사다리가 있으면 안됩니다.");
            }
        }
    }

    public void createLadders() {
        IntStream.range(1, points.size()).filter(i -> !points.get(i - 1).bridge().isBuilt())
                .filter(i -> RANDOM.nextBoolean()).forEach(i -> points.get(i).createBridge());
    }

    public void createBridge(int i) {
        points.get(i).createBridge();
        validate(points);
    }
}
