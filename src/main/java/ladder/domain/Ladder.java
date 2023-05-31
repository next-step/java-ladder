package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> columns;

    public Ladder(int height, int countOfPerson) {
        columns = new ArrayList<>(height);

        for (int i = 0; i < height; i++) {
            columns.add(new Line(countOfPerson));
        }
    }

    public List<Line> getColumns() {
        return columns;
    }
}
