package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.strategy.DirectionStrategy;

public class LadderCell {
    private final Direction direction;

    private LadderCell(final Direction direction) {
        this.direction = direction;
    }

    public static LadderCell createFirst(final DirectionStrategy generator) {
        return new LadderCell(Direction.createFirst(generator));
    }

    public LadderCell createNext(final DirectionStrategy generator) {
        return new LadderCell(direction.createNext(generator));
    }

    public LadderCell createLast() {
        return new LadderCell(direction.createLast());
    }

    public boolean isRight() {
        return direction.isRight();
    }
}
