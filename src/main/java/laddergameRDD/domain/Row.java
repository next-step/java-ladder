package laddergameRDD.domain;

import laddergameRDD.engine.SelectStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Row {
    private List<Point> row = new ArrayList<>();

    public Row(int columnCount, SelectStrategy selectStrategy) {
        Point curPoint = Point.first(selectStrategy.canSelect());
        row.add(curPoint);
        for (int i = 1; i < columnCount - 1; ++i) {
            curPoint = curPoint.next(selectStrategy.canSelect());
            row.add(curPoint);
        }
        row.add(curPoint.end());
    }

    public Row(List<Point> row) {
        this.row = row;
    }

    public int moveDown(int position) {
        return position + row.get(position).move();
    }

    public List<Boolean> getRow() {
        return row.stream()
                .map(Point::getPoint)
                .collect(Collectors.toList());
    }
}
