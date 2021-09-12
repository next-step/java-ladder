package nextstep.ladder.domain;

import nextstep.ladder.strategy.DrawLineStrategy;

public class LadderStep {

    private final InterSpaces interSpaces;

    public LadderStep(int playersCount, DrawLineStrategy strategy) {
        this.interSpaces = new InterSpaces(playersCount, strategy);
    }

    public InterSpaces getInterSpaces() {
        return interSpaces;
    }

    public int interSpacesSize() {
        return getInterSpaces().value().size();
    }
}
