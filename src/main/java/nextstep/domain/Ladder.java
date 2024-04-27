package nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Lines lines;
    private final Participants participants;

    public Ladder(String names, Integer ladderHeight) {
        this(Participants.create(names),Lines.create(participants.countOfPerson(), ladderHeight);
    }


    public Ladder(Lines lines, Participants participants) {
        this.lines = lines;
        this.participants = participants;
    }

    public List<String> getNames() {
        return this.participants.getNames();
    }

    public List<String> getLines() {
        return lines.getLines();
    }
}
