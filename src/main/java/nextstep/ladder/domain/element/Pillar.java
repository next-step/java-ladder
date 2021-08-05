package nextstep.ladder.domain.element;

import nextstep.ladder.domain.play.PlayerPosition;
import nextstep.ladder.domain.strategy.LineCreateStrategy;

public class Pillar {

    private final Line line;

    private Pillar(Line line) {
        this.line = line;
    }

    public static Pillar makeStart(LineCreateStrategy randomLineCreateStrategy) {
        return new Pillar(Line.make(randomLineCreateStrategy));
    }

    public Pillar makeMiddle(LineCreateStrategy randomLineCreateStrategy) {
        return new Pillar(line.makeNext(randomLineCreateStrategy));
    }

    public Pillar makeEnd() {
        return new Pillar(line.makeEnd());
    }

    public boolean hasRightLine() {
        return line.isRight();
    }

    public PlayerPosition move(PlayerPosition position) {
        return line.move(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pillar pillar = (Pillar) o;

        return line == pillar.line;
    }

    @Override
    public int hashCode() {
        return line != null ? line.hashCode() : 0;
    }
}
