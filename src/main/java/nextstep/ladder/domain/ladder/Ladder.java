package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lineList;
    private final int countOfPeople;

    public Ladder(int countOfPeople) {
        this.countOfPeople = countOfPeople;
        this.lineList = new ArrayList<>();
    }

    public List<Line> values() {
        return lineList;
    }

    public void add(Line line) {
        lineList.add(line);
    }

    public int countOfPeople() {
        return countOfPeople;
    }
}
