package nextstep.domain;

import java.util.List;

public class Ladder {
    private final Participants participants;
    private final Lines lines;


    public Ladder(String names, Integer ladderHeight) {
        this(new Participants(names), ladderHeight);
    }

    public Ladder(Participants participants, Integer ladderHeight) {
        this(participants, new Lines(participants.countOfPerson(), ladderHeight));
    }


    public Ladder(Participants participants, Lines lines) {
        this.participants = participants;
        this.lines = lines;
    }

    public List<String> getNames() {
        return this.participants.getNames();
    }

    public List<String> getLines() {
        return lines.getLines();
    }

    public LadderResult createLadderResult(List<String> prize) {
        participants.move(lines);
        return new LadderResult(participants.getList(), prize);
    }
}
