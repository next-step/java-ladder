package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.concrete.Ladder;

public interface LadderCreateStrategy {
    Ladder create(Players players, Height height);
}
