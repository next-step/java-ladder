package nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    Lines lines;
    Participants participants;

    public Ladder(String names, Integer ladderHeight) {
        this.participants = Participants.create(names);
        this.lines = Lines.create(participants.countOfPerson(), ladderHeight);
    }

    public List<String> getNames() {
        return this.participants.getNames();
    }

    public List<String> getLines() {
        return lines.getLines();
    }
}
