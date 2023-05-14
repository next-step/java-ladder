package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfParticipant, GenerateLadderPointStrategy generateLadderPointStrategy) {
        this.points = generateLadderPointStrategy.generate(countOfParticipant);

        validateOverlap();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void validateOverlap() {
        IntStream.range(0, points.size() - 1)
                .filter(i -> points.get(i) && points.get(i + 1))
                .findAny()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("겹치게 생성된 라인이 존재합니다.");
                });
    }

}
