package nextstep.ladder.generator;

import nextstep.ladder.service.Line;

@FunctionalInterface
public interface LineGenerator {
    Line createLine(final int countOfPerson);
}
