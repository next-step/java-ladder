package ladder.domain.core.rule;

@FunctionalInterface
public interface PointLinkingRule {
    boolean shouldLinking();

    static PointLinkingRule defaultRule(){
        return new PointRandomLinkingRule();
    }
}
