package ladder.domain;

import java.util.*;

public class LadderFactory {
    private List<Line> ladderList;

    public LadderFactory(int maxHeight, int sizeofusergroup) {

        ladderList = new ArrayList<>();
        Line line;

        for (int i = 0; i < maxHeight; ++i) {
            line = new Line(sizeofusergroup);
            ladderList.add(line);
        }
    }

    public List<Line> getLadder() {
        return ladderList;
    }

}
