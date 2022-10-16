package nextstep.ladder.Model;

import java.util.List;

public class Ladder {
    private List<Line> ladder;

    public Ladder(List<Line> ladder){
        this.ladder = ladder;
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
