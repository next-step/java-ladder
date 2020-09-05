package nextstep.ladder.domain;

import java.util.List;

public class LadderLine {

    private List<Line> ladders;

    public LadderLine(List<Line> ladders) {
        this.ladders = ladders;
    }

    public Line getLine(int index) {
        return ladders.get(index);
    }

    public int size() {
        return ladders.size();
    }

}
