package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.concrete.Line;

public interface LineCreateStrategy {
    Line createLine(int personCount);
}
