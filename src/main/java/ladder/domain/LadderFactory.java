package ladder.domain;

import java.util.*;

public class LadderFactory {
    private List<LadderLine> ladder;

    public LadderFactory(int maxHeight, int sizeofusergroup) {

        ladder = new ArrayList<>();
        LadderLine ladderLine;

        for (int i = 0; i < maxHeight; ++i) {
            ladderLine = new LadderLine(sizeofusergroup);
            ladder.add(ladderLine);
        }
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }
}
