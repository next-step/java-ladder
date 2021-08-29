package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Players players, LadderHeight heightOfLadder) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < heightOfLadder.height(); i++) {
            List<Boolean> points = new RandomPointStrategy().point(players.size() - 1);
            lines.add(Line.from(points));
        }

        return new Ladder(lines);
    }

    public static Ladder of(Line lines) {
        return new Ladder(Collections.singletonList(lines));
    }

    public List<Line> lines() {
        return lines;
    }

    public Position move(Position position) {
        for (Line line : lines()) {
            position = line.move(position);
        }

        return position;
    }
}
