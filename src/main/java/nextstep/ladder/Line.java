package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(Participant participant, LineStrategy lineStrategy) {
        List<Boolean> points = new ArrayList<>();
        points.add(lineStrategy.drawLine(false));
        for (int i = 1; i < participant.getParticipants().size() - 1; i++) {
            points.add(lineStrategy.drawLine(points.get(i - 1)));
        }
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int getPointSize(){
        return points.size();
    }
}
