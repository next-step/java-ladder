package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private Names names;
    private List<Line> ladders;

    public Ladder(String names, int inputLadderHeight) {
        setNames(names);
        setLadders(inputLadderHeight);
    }

    public Names getNames() {
        return this.names;
    }

    public List<Line> getLadders() {
        return ladders;
    }

    private void setNames(String names) {
        this.names = new Names(names);
    }

    private void setLadders(int inputLadderHeight) {
        ladders = new ArrayList<>();
        for (int i = 0; i < inputLadderHeight; i++) {
            ladders.add(new Line(names.getParticipantsCount()));
        }
    }
}
