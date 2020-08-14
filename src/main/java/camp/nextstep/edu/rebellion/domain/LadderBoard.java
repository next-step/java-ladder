package camp.nextstep.edu.rebellion.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderBoard {
    private final List<Row> rows;

    public LadderBoard(int sizeOfRows, int sizeOfPoints) {
        this.rows = generateRows(sizeOfRows, sizeOfPoints);
    }

    private List<Row> generateRows(int sizeOfRows, int sizeOfPoints) {
        List<Row> rows = new ArrayList<>();
        IntStream.range(0, sizeOfRows)
                .forEach(r -> rows.add(new Row(r, sizeOfPoints)));
        return rows;
    }
}
