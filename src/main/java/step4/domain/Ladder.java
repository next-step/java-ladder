package step4.domain;

import step4.strategy.RandomPointCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder implements Cloneable {
    private final List<LadderLine> lines = new ArrayList<>();
    private final LadderInfo ladderInfo;

    private Ladder(LadderInfo ladderInfo, RandomPointCreateStrategy createStrategy) {
        this.ladderInfo = ladderInfo;
        for (int depth = 0; depth < ladderInfo.height(); depth++) {
            lines.add(LadderLine.of(ladderInfo.width(), createStrategy));
        }
    }

    public static Ladder of(LadderInfo ladderInfo, RandomPointCreateStrategy createStrategy) {
        return new Ladder(ladderInfo, createStrategy);
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

    @Override
    protected Ladder clone() throws CloneNotSupportedException {
        return (Ladder) super.clone();
    }
}
