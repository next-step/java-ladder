package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private final List<Ladder> ladders;

    public Ladders(Participants participants, LadderHeight ladderHeight) {
        List<Ladder> result = new ArrayList<>();
        for (int i = 0; i < ladderHeight.getValue(); i++) {
            result.add(new Ladder(participants.size()));
        }
        this.ladders = result;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}
