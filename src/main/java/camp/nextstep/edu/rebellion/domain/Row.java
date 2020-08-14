package camp.nextstep.edu.rebellion.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Row {
    private final int INIT_INDEX = 0;
    private final List<Point> points;

    public Row (int row, int cols) {
        points = generateCols(row, cols);
    }

    private List<Point> generateCols(int row, int cols) {
        List<Point> points = new ArrayList<>();
        IntStream.range(INIT_INDEX, cols)
                .forEach(i -> points.add(new Point(row, i)));
        return points;
    }
}
