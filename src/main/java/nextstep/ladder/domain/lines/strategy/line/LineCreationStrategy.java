package nextstep.ladder.domain.lines.strategy.line;

import nextstep.ladder.domain.Line;

public interface LineCreationStrategy {

    Line createNextLine(Line beforeLine, int height);
}
