package nextstep.ladder.domain;

public class LadderStep {

    private final InterSpaces interSpaces;

    public LadderStep(LadderDrawingSettings settings) {
        this.interSpaces = new InterSpaces(settings);
    }

    public InterSpaces getInterSpaces() {
        return interSpaces;
    }

    public int interSpacesSize() {
        return getInterSpaces().value().size();
    }
}
