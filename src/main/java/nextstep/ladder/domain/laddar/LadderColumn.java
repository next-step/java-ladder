package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.player.Position;
import nextstep.ladder.domain.strategy.DirectionStrategy;

public class LadderColumn {
    private final Direction direction;

    private LadderColumn(final Direction direction) {
        this.direction = direction;
    }

    public static LadderColumn createFirst(final DirectionStrategy generator) {
        return new LadderColumn(Direction.createFirst(generator));
    }

    public LadderColumn createNext(final DirectionStrategy generator) {
        return new LadderColumn(direction.createNext(generator));
    }

    public LadderColumn createLast() {
        return new LadderColumn(direction.createLast());
    }

    public boolean isRight() {
        return direction.isRight();
    }

    public void ride(final Position position) {
        direction.move(position);
    }
}
