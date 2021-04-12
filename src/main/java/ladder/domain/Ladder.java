package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int numberOfPlayer, LinkSelector linkSelector) {
        lines = new ArrayList<>();
        Linker linker = new Linker(linkSelector);

        for (int i = 0; i < height; i++) {
            lines.add(new Line(numberOfPlayer, linker));
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
        for (int topPoint = 0; topPoint < players.count(); topPoint++) {
            int bottomPoint = bottomPoint(topPoint);
            resultElements.add(new ResultElement(players.name(topPoint), goals.item(bottomPoint)));
        }

        return new LadderResult(resultElements);
    }

    private int bottomPoint(int point) {
        for (Line line : lines) {
            point = line.endPoint(point);
        }
        return point;
    }
}
