package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    private Lines(Floor floor, int countOfUsers, LineStrategy strategy) {
        validate(countOfUsers, strategy);

        this.lines = new ArrayList<>();

        for (int i = 0; i < floor.getFloor(); i++) {
            lines.add(strategy.execute(countOfUsers));
        }
    }

    private void validate(int countOfUsers, LineStrategy strategy) {
        if (countOfUsers != (strategy.execute(countOfUsers).size() + 1)) {
            throw new IllegalArgumentException("사용자 수와 사다리 전략 결과의 검증에 실패했습니다.");
        }
    }

    public static Lines of(Floor floor, int countOfUsers, LineStrategy strategy) {
        return new Lines(floor, countOfUsers, strategy);
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
