package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.RealLine;

public interface LineStrategy {
    Line createLine(int personCount);

    RealLine createRealLine(int personCount);
}
