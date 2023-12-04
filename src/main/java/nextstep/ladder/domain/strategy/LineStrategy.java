package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Line;

public interface LineStrategy {
    Line createLine(int personCount);
}
