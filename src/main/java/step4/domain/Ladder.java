package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
    }

    public int ladderHeight() {
        return this.lines.size();
    }
}
