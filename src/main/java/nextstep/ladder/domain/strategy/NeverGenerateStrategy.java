package nextstep.ladder.domain.strategy;

public class NeverGenerateStrategy implements StepGenerateStrategy {
    public static StepGenerateStrategy NEVER_GENERATE_STRATEGY = new NeverGenerateStrategy();

    private NeverGenerateStrategy() {}

    @Override
    public boolean isGenerable() {
        return false;
    }
}
