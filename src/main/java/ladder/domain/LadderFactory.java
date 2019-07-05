package ladder.domain;

import java.util.*;

public class LadderFactory {
    private List<Line> ladderMap;

    public LadderFactory(int maxHeight, int sizeofusergroup) {

        ladderMap = new ArrayList<>();
        Line line;

        for (int i = 0; i < maxHeight; ++i) {
            line = new Line(sizeofusergroup);
            ladderMap.add(line);
        }
    }

    public List<Line> getLadder() {
        return ladderMap;
    }

}
