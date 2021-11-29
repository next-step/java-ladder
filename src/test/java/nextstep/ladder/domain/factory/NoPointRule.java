package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.rule.PointRule;

public class NoPointRule implements PointRule {

    private static final NoPointRule NO_POINT_RULE = new NoPointRule();
    private static final boolean DEFAULT_RULE = false;

    public static NoPointRule noPointRule() {
        return NO_POINT_RULE;
    }

    @Override
    public boolean canCreate() {
        return DEFAULT_RULE;
    }
}
