package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Position;

public interface LadderStrategy {
    Position move(Position position);
}
