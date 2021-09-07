package nextstep.ladder.domain;

public class LadderStep {

    private final InterSpaces interSpaces;

    public LadderStep(LadderGameSettings settings) {
        this.interSpaces = new InterSpaces(settings);
    }

    public InterSpaces getInterSpaces() {
        return interSpaces;
    }
}
