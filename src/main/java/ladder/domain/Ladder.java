package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.strategy.EvenNumberBuildLadder;
import ladder.domain.strategy.OddNumberBuildLadder;
import ladder.domain.strategy.RandomBuildLadder;

public class Ladder {

    private final List<Line> columns;

    public Ladder(int height, int countOfPerson) {
        columns = new ArrayList<>(height);
        columns.add(new Line(countOfPerson, new EvenNumberBuildLadder()));
        columns.add(new Line(countOfPerson, new OddNumberBuildLadder()));

        for (int i = 0; i < height - 2; i++) {
            columns.add(new Line(countOfPerson, new RandomBuildLadder()));
        }
    }

    public List<Line> getColumns() {
        return columns;
    }
}
