package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    public Line(Participant participant, LineStrategy lineStrategy) {
        List<Boolean> points = new ArrayList<>();
        points.add(lineStrategy.drawLine(false));

        IntStream.range(1, participant.getParticipantSize() - 1)
                .forEach(index ->
                        points.add(lineStrategy.drawLine(points.get(index - 1)))
                );

        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int getPointSize() {
        return points.size();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
