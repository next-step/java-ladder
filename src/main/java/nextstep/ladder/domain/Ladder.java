package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    private final Lines lines;

    public static Ladder of(int floor, int countOfUsers, LineStrategy strategy) {
        return new Ladder(
                Floor.from(floor),
                countOfUsers,
                strategy
        );
    }

    private Ladder(Floor floor, int countOfUsers, LineStrategy strategy) {
        this.lines = Lines.of(floor, countOfUsers, strategy);
    }


    public List<Line> getLadderInfo() {
        return this.lines.toList();
    }

    public int destinationPosition(int departPosition) {
        return this.lines.getUserWinLocation(departPosition);
    }
}
