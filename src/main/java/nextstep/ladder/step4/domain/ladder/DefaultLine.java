package nextstep.ladder.step4.domain.ladder;

import static nextstep.ladder.step4.exception.LineMinimumLengthException.MINIMUM_LENGTH;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.step4.domain.ladder.engine.Line;
import nextstep.ladder.step4.exception.LineMinimumLengthException;

public class DefaultLine implements Line {

    private final List<Point> points;

    public DefaultLine(List<Point> points) {
        valid(points);
        this.points = points;
    }

    @Override
    public int move(int index) {
        if (index < 0 || index >= points.size()) {
            throw new ArrayIndexOutOfBoundsException("존재하지 않는 라인 번호 입니다.");
        }
        return points.get(index).move();
    }

    public List<Boolean> points() {
        return points.stream()
            .map(point -> point.right())
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private void valid(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("사다리가 존재하지 않습니다.");
        }

        if (points.size() < MINIMUM_LENGTH) {
            throw new LineMinimumLengthException();
        }
    }

}
