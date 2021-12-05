package step2.domain;

import step2.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    private Ladder(LadderInfo ladderInfo, LineCreateStrategy createStrategy) {
        int width = ladderInfo.getWidth();
        int height = ladderInfo.getHeight();
        for (int count = 0; count < height; count++) {
            lines.add(Line.create(width, createStrategy));
        }
    }

    public static Ladder create(LadderInfo ladderInfo, LineCreateStrategy createStrategy) {
        return new Ladder(ladderInfo, createStrategy);
    }

    public List<Line> getLines() {
        return lines;
    }

    public Position run(Position position) {
        int depth = 0;
        while (!isEnd(depth)) {
            Line line = lines.get(depth);
            line.move(position);
            depth++;
        }
        return position;
    }

    private boolean isEnd(int depth) {
        return lines.size() == depth;
    }
}
