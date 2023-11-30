package nextstep.ladder.domain.lines.strategy;

import nextstep.ladder.domain.Line;

public interface NextLineCreationStrategy {

    Line createNextLine(Line beforLine, int height);
}
