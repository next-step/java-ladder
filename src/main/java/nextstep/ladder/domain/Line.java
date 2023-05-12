package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfParticipant, GenerateLadderPointStrategy generateLadderPointStrategy) {
        this.points = generateLadderPointStrategy.generate(countOfParticipant);
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
