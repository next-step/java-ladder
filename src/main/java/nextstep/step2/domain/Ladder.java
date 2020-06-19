package nextstep.step2.domain;

public class Ladder {
    private Names names;
    private Lines ladderLines;

    public Ladder(String nameString, int inputLadderHeight) {
        names = new Names(nameString);
        ladderLines = new Lines(inputLadderHeight, names.getParticipantsCount());
    }

    public Names getNames() {
        return names;
    }

    public Lines getLadderLines() {
        return ladderLines;
    }
}
