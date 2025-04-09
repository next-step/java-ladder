package laddergameRDD;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private final List<Point> row = new ArrayList<>();

    public Row(int columnCount, SelectStrategy selectStrategy) {
        Point curPoint = Point.first(selectStrategy.canSelect());
        row.add(curPoint);
        for (int i = 1; i < columnCount - 1; ++i) {
            curPoint = curPoint.next(selectStrategy.canSelect());
            row.add(curPoint);
        }
        row.add(curPoint.end());
    }

    public int moveDown(int position) {
        return position + row.get(position).move();
    }
}
