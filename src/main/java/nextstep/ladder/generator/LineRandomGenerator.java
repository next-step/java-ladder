package nextstep.ladder.generator;

import nextstep.ladder.utils.RandomUtils;

import java.util.Optional;

public class LineRandomGenerator implements LineGenerator {
    @Override
    public boolean generate(boolean prevBoolean) {
        return Optional.of(prevBoolean)
                .map(prev -> !prev && RandomUtils.nextBoolean())
                .orElse(RandomUtils.nextBoolean());
    }
}
