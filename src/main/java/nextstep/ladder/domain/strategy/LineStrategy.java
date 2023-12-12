package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Position;

public interface LineStrategy {
    Position move(Position position);
}
