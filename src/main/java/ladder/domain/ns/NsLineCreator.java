package ladder.domain.ns;

import ladder.domain.engine.Line;
import ladder.domain.engine.LineCreator;
import ladder.domain.ns.generator.RandomCrossGenerator;

public class NsLineCreator implements LineCreator {
    @Override
    public Line create(int playersCount) {
        return new NsLine(playersCount, new RandomCrossGenerator());
    }
}