package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    private Lines(Floor floor, int countPole, LineStrategy strategy) {
        validate(countPole, strategy);

        this.lines = new ArrayList<>();

        for (int i = 0; i < floor.getFloor(); i++) {
            lines.add(strategy.execute(countPole));
        }
    }

    private void validate(int countPole, LineStrategy strategy) {
        if (countPole != strategy.execute(countPole).size()) {
            throw new IllegalArgumentException("사용자 수와 사다리 전략 결과의 검증에 실패했습니다.");
        }
    }

    public static Lines of(Floor floor, int countPole, LineStrategy strategy) {
        return new Lines(floor, countPole, strategy);
    }

    public List<Line> toList() {
        return List.copyOf(this.lines);
    }

    public int getUserWinLocation(int startPosition) {
        int currentPosition = startPosition;
        for (Line line : this.lines) {
            currentPosition = line.getDestinationFrom(currentPosition);
        }
        return currentPosition;
    }
}
