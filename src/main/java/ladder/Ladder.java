package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladder = new ArrayList<>();

    public Ladder(int ladderHeight, int sizeOfPerson, PointConnectStrategy pointConnectStrategy) {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(LadderLine.of(sizeOfPerson, pointConnectStrategy));
        }
    }

    public List<LadderLine> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public int findFinalIndexOf(int startIndex) {
        int currentIndex = startIndex;
        for (LadderLine line : ladder) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }
}
