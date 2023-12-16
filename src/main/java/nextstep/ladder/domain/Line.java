package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final ArrayList<LineState> points;

    public Line(int countOfParticipant) {
        this(generateRandomLine(countOfParticipant));
    }

    private static ArrayList<LineState> generateRandomLine(int countOfParticipant) {
        ArrayList<LineState> line = new ArrayList<>();
        LineState firstPoint = new LineState(false, false); // 사다리 라인의 맨 왼쪽은 생성될 수 없다.
        line.add(firstPoint);
        for (int i = 1; i < countOfParticipant; i++) {
            LineState point = LineState.previousOf(line.get(i-1).getCurrent());
            line.add(point);
        }
        return line;
    }

    public Line(ArrayList<LineState> points) {
        this.points = points;
    }

    public List<LineState> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
