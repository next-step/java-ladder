package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

public class RandomLineStrategy implements LineStrategy {
    @Override
    public boolean isLinkable() {
        return RandomUtil.nextBoolean();
    }
}
