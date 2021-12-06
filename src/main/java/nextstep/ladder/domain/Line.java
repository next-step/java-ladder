package nextstep.ladder.domain;

import nextstep.ladder.strategy.LadderStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int countOfParticipants, LadderStrategy ladderStrategy) {
        return new Line(ladderStrategy.makeLadder(countOfParticipants));
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
