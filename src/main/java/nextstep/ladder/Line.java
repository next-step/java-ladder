package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    public Line(Participant participant, LineStrategy lineStrategy) {
        this.points = lineStrategy.generate(participant.getParticipantSize());
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int getPointSize() {
        return points.size();
    }

}
