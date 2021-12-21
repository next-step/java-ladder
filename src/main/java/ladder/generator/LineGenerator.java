package ladder.generator;

import ladder.domain.ladder.Line;

@FunctionalInterface
public interface LineGenerator {

    Line generate(int countOfPlayer);

}
