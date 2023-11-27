package nextstep.ladder.domain.lines.strategy;

import nextstep.ladder.domain.Line;

public interface LeftLineCreationStrategy {

    Line createLeftLine(Line beforLine, int height);
}
