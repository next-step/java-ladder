package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int numberOfPlayer) {
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(numberOfPlayer));
        }
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> lines() {
        return lines;
    }

    public LadderResult result(Players players, Goals goals) {
        List<ResultElement> resultElements = new ArrayList<>();
        for (int position = 0; position < players.count(); position++) {
            int lastPosition = lastPosition(position);
            resultElements.add(new ResultElement(players.name(position), goals.item(lastPosition)));
        }

        return new LadderResult(resultElements);
    }

    private int lastPosition(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }
}
