package ladder.domain.core.rule;

import java.util.Random;

class PointRandomLinkingRule implements PointLinkingRule {
    private final Random random;
    public PointRandomLinkingRule() {
        random = new Random();
    }

    @Override
    public boolean shouldLinking() {
        return random.nextBoolean();
    }
}
