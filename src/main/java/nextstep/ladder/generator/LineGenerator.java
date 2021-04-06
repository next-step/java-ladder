package nextstep.ladder.generator;

import nextstep.ladder.domain.Bar;

import java.util.List;

@FunctionalInterface
public interface LineGenerator {
    List<Bar> createLine(final int countOfPerson);
}
