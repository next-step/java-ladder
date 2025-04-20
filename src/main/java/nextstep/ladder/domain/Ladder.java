package nextstep.ladder.domain;

public class Ladder {
    private final PersonNames personNames;
    private final LadderLines ladderLines;

    public Ladder(PersonNames personNames, int height) {
        this.personNames = personNames;
        this.ladderLines = LadderLineGenerator.generateLadderLines(height, personNames.size() - 1);
    }

    public PersonNames getPersonNames() {
        return personNames;
    }

    public LadderLines getLadderLines() {
        return ladderLines;
    }
}
