package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderInfo {

    private final int height;

    private final int width;

    private final ArrayList<Line> link;

    public LadderInfo(int height, int width) {
        this.height = height;
        this.width = width;
        this.link = new ArrayList<>();
    }
}
