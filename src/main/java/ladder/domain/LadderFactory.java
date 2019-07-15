package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    private List<LadderLine> ladder;

    public LadderFactory(int maxHeight, int sizeOfUserGroup) {
        ladder = new ArrayList<>();

        for (int i = 0; i < maxHeight; ++i) {
            ladder.add(LadderLine.init(sizeOfUserGroup));
        }
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }
}
