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
        return List.copyOf(lineList);
    }

    public void add(Line line) {
        lineList.add(line);
    }

    public Index resultOf(int position) {
        Index index = new Index(position, countOfPeople);
        for(Line line: values()) {
            index = line.movePerson(index);
        }
        return index;
    }

    public List<Index> all() {
        List<Index> results = new ArrayList<>();
        for(int i = 0; i < countOfPeople; i++) {
            results.add(resultOf(i));
        }
        return results;
    }
}
