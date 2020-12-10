package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private final List<Ladder> ladders;

    public Ladders(int personCount, LadderHeight ladderHeight) {
        List<Ladder> result = new ArrayList<>();
        for (int i = 0; i < ladderHeight.getValue(); i++) {
            result.add(new Ladder(personCount));
        }
        this.ladders = result;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}
