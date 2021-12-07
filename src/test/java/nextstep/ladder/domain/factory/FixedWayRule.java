package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.rule.WayRule;

import java.util.List;

public class FixedWayRule implements WayRule {

    private final List<Boolean> creations;
    private int index;

    public FixedWayRule(List<Boolean> creations) {
        this.creations = creations;
    }

    @Override
    public boolean canCreate() {
        return creations.get(index++);
    }
}
