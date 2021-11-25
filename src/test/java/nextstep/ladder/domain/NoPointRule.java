package nextstep.ladder.domain;

public class NoPointRule implements PointRule {

    private static final NoPointRule noPointRule = new NoPointRule();
    private static final boolean DEFAULT_RULE = false;

    public static NoPointRule noPointRule() {
        return noPointRule;
    }

    @Override
    public boolean canCreate() {
        return DEFAULT_RULE;
    }
}
