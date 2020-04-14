package ladder.ladder.infrastructure;

import ladder.ladder.domain.LinkStrategy;
import ladder.ladder.util.RandomUtils;
import org.graalvm.compiler.hotspot.nodes.profiling.RandomSeedNode;

import java.util.Random;

public class RandomLinkStrategy implements LinkStrategy {

    @Override
    public boolean get() {
        return new Random().nextBoolean();
    }
}
