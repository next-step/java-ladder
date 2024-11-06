package nextstep.ladder.strategy;

import nextstep.ladder.engine.Line;

@FunctionalInterface
public interface LineCreatableStrategy {
    Line create(final int countOfPerson);
}
