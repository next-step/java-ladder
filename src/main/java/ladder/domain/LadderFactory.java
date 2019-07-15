package ladder.domain;

import java.util.*;

public class LadderFactory {
    private List<Line> ladder;

    public LadderFactory(int maxHeight, int sizeofusergroup) {

        ladder = new ArrayList<>();
        Line line;

        for (int i = 0; i < maxHeight; ++i) {
            line = new Line(sizeofusergroup);
            ladder.add(line);
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

}
