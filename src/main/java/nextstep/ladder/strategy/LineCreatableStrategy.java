package nextstep.ladder.strategy;

import nextstep.ladder.domain.Line;

@FunctionalInterface
public interface LineCreatableStrategy {
    Line create(final int countOfPerson);
}
