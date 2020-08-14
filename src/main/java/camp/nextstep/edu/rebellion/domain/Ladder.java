package camp.nextstep.edu.rebellion.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Row> rows;

    public Ladder(int sizeOfRows, int sizeOfPoints) {
        this.rows = generateRows(sizeOfRows, sizeOfPoints);
    }

    public void drawLine(int x, int y) {
        // 사다리를 다양하게 그리는 방법
        // 1. 시작점을 다르게 한다
        // 2. 그릴 수 있는 곳이지만 안그린다
    }

    private List<Row> generateRows(int sizeOfRows, int sizeOfPoints) {
        List<Row> rows = new ArrayList<>();
        IntStream.range(0, sizeOfRows)
                .forEach(r -> rows.add(new Row(r, sizeOfPoints)));
        return rows;
    }
}
