package step4.domain;

import step4.strategy.PointCreateStrategy;

import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> ladderLines;

    private LadderLine(List<Point> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static LadderLine of(Width width, PointCreateStrategy createStrategy) {
        return new LadderLine(createStrategy.create(width.width()));
    }

    public Position move(int position) {
        return pointBy(position).move();
    }

    public List<Point> lines() {
        return ladderLines;
    }

    public int size() {
        return ladderLines.size();
    }

    private Point pointBy(int position) {
        return ladderLines.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(ladderLines, that.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
