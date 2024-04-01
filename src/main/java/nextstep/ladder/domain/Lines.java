package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    public static final int MINIMUM_PARTICIPANTS_COUNT = 2;
    private final List<Line> lines;

    private Lines(Floor floor, int countOfUsers, LineStrategy strategy) {
        validate(countOfUsers, strategy);

        this.lines = new ArrayList<>();

        for (int i = 0; i < floor.getFloor(); i++) {
            lines.add(strategy.execute(countOfUsers));
        }
    }

    private void validate(int countOfUsers, LineStrategy strategy) {
        if (countOfUsers < MINIMUM_PARTICIPANTS_COUNT) {
            throw new IllegalArgumentException(String.format("사용자 수는 %d명 이상이여야 합니다.", Lines.MINIMUM_PARTICIPANTS_COUNT));
        }

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

    public List<Integer> gameResult(int countOfUsers) {
        List<Integer> userWinLocations = new ArrayList<>();

        for (int i = 0; i < countOfUsers; i++) {
            userWinLocations.add(getUserWinLocation(i));
        }

        return userWinLocations;
    }

    private int getUserWinLocation(int startPosition) {
        int currentPosition = startPosition;
        for (Line line : this.lines) {
            currentPosition = line.getDestinationFrom(currentPosition);
        }
        return currentPosition;
    }
}
