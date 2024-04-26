package laddergame.domain;

import java.util.List;
import java.util.stream.IntStream;
import laddergame.RandomGenerator;

public class Line {

    private final List<Boolean> points;
    private final RandomGenerator randomGenerator = new RandomGenerator();

    public Line(List<Boolean> points) {
        validateLine(points);
        this.points = points;
    }

    public Line(int count) {
        List<Boolean> randomPoints = randomGenerator.generator(count);
        validateLine(randomPoints);
        this.points = randomPoints;
    }

    private void validateLine(List<Boolean> line) {
        if (IntStream.range(0, line.size() - 1).anyMatch(i -> line.get(i) && line.get(i + 1))) {
            throw new IllegalArgumentException("가로 라인이 겹칠 수 없습니다.");
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
