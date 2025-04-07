package nextstep.ladder.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final Random RANDOM = new Random();
    private final List<PointX> points;

    public Line(int size) {
        points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            points.add(new PointX(i));
        }
    }

    public Line(List<PointX> points) {
        Collections.sort(points);
        validate(points);
        this.points = points;
    }

    public List<PointX> value() {
        return points;
    }

    private void validate(List<PointX> points) {
        int start = points.get(0).value();
        int end = points.get(points.size() - 1).value();
        if (start != 0 || end != points.size() - 1) {
            throw new IllegalArgumentException("Line의 시작과 끝은 0과 (n-1)이어야 합니다.");
        }
        if (points.size() < 2) {
            throw new IllegalArgumentException("Line의 크기는 2 이상이어야 합니다.");
        }
        if (points.get(0).ladder() != null) {
            throw new IllegalArgumentException("Line의 시작은 사다리가 없어야 합니다.");
        }
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).ladder() != null && points.get(i + 1).ladder() != null) {
                throw new IllegalArgumentException("Line에서 연속된 사다리가 있으면 안됩니다.");
            }
        }
    }

    public void createLadders() {
        IntStream.range(1, points.size()).forEach(i -> {
            if (RANDOM.nextBoolean()) {
                points.get(i).createLadder();
            }
        });
        for (int i = 1; i < points.size() - 1; i++) {
            if (points.get(i).ladder() != null && points.get(i + 1).ladder() != null) {
                if (RANDOM.nextBoolean()) {
                    points.get(i).destroyLadder();
                } else {
                    points.get(i + 1).destroyLadder();
                }
            }
        }
    }

    @Override
    public String toString() {
        return points.stream().map(PointX::toString).collect(Collectors.joining(""));
    }
}
