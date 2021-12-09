package step4.domain;

import step4.strategy.RandomPointCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> lines;
    private final LadderInfo ladderInfo;

    private Ladder(LadderInfo ladderInfo, RandomPointCreateStrategy createStrategy) {
        this.ladderInfo = ladderInfo;
        this.lines = new ArrayList<>();
        for (int depth = 0; depth < ladderInfo.height(); depth++) {
            lines.add(LadderLine.of(ladderInfo.width(), createStrategy));
        }
    }

    private Ladder(List<LadderLine> lines, LadderInfo ladderInfo) {
        this.lines = lines;
        this.ladderInfo = ladderInfo;
    }

    public static Ladder of(LadderInfo ladderInfo, RandomPointCreateStrategy createStrategy) {
        return new Ladder(ladderInfo, createStrategy);
    }

    public Ladder copy() {
        List<LadderLine> lines = new ArrayList<>();
        for (LadderLine line : this.lines) {
            lines.add(line.copy());
        }
        return new Ladder(lines, this.ladderInfo);
    }

    public int size() {
        return lines.size();
    }

    public List<LadderLine> lines() {
        return lines;
    }

    public List<Position> startAll() {
        List<Position> result = new ArrayList<>();
        for (int position = 0; position < ladderInfo.width(); position++) {
            result.add(start(position));
        }
        return result;
    }

    public Position startBy(int position) {
        return start(position);
    }

    private Position start(int position) {
        Position currentPosition = Position.of(position);
        for (LadderLine line : lines) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }
}
