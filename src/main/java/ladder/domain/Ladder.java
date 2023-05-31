package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.strategy.EvenNumberBuildLadder;
import ladder.domain.strategy.OddNumberBuildLadder;
import ladder.domain.strategy.RandomBuildLadder;

public class Ladder {

    private final List<Line> columns;

    public Ladder(int height, int countOfPerson) {
        validHeight(height);
        columns = new ArrayList<>(height);
        columns.add(new Line(countOfPerson, new EvenNumberBuildLadder()));
        columns.add(new Line(countOfPerson, new OddNumberBuildLadder()));

        for (int i = 0; i < height - 2; i++) {
            columns.add(new Line(countOfPerson, new RandomBuildLadder()));
        }
    }

    private void validHeight(int height) {
        if (height < 2) {
            throw new IllegalArgumentException("사다리 높이는 2보다 작을 수 없습니다.");
        }
    }

    public List<Line> getColumns() {
        return columns;
    }
}
