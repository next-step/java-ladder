package nextstep.ladder.generator;

import nextstep.ladder.wrapper.Line;

@FunctionalInterface
public interface LineGenerator {
    Line createLine(final int countOfPerson);
}
