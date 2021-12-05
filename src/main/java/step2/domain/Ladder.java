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
        Level level = Level.init();
        while (proceed(level)) {
            move(level, position);
            level.next();
        }
        return position;
    }

    private void move(Level level, Position position) {
        Line line = lines.get(level.level());
        line.move(position);
    }

    private boolean proceed(Level level) {
        return !Level.of(lines.size()).matched(level);
    }
}
