package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfParticipant, GenerateLadderPointStrategy generateLadderPointStrategy) {
        this.points = generateLadderPointStrategy.generate(countOfParticipant);

        validateOverlap();
    }

    public int move(int position) {
        if (isMoveRight(position)) {
            return position + 1;
        }
        if (isMoveLeft(position)) {
            return position - 1;
        }
        return position;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void validateOverlap() {
        IntStream.range(0, points.size() - 1)
                .filter(this::isOverlap)
                .findAny()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("겹치게 생성된 라인이 존재합니다.");
                });
    }

    private boolean isOverlap(int index) {
        return points.get(index) && points.get(index + 1);
    }

    private boolean isMoveRight(int position) {
        return position < points.size() && points.get(position);
    }

    private boolean isMoveLeft(int position) {
        return position > 0 && points.get(position - 1);
    }

}
