package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    private Lines(Floor floor, int countOfUsers, LineStrategy strategy) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < floor.getFloor(); i++) {
            lines.add(strategy.execute(countOfUsers));
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
