package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.draw.DrawRule;

public class NoneDrawRule implements DrawRule {
    @Override
    public boolean drawRule() {
        return false;
    }
}
