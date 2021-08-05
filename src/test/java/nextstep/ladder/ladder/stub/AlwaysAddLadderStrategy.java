package nextstep.ladder.ladder.stub;

import nextstep.ladder.strategy.LadderStrategy;

public class AlwaysAddLadderStrategy implements LadderStrategy {
    @Override
    public boolean creatable() {
        return true;
    }
}
