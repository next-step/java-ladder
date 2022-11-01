package laddergame.dto;

import laddergame.domain.Line;
import laddergame.domain.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRecord {
    private final List<Boolean> record;

    public LineRecord(List<Boolean> record) {
        this.record = record;
    }

    public static LineRecord of(Line line){
        List<Point> points = line.getPoints();

        List<Boolean> record = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            record.add(points.get(i).isRight());
        }

        return new LineRecord(record);
    }

    public List<Boolean> getRecord() {
        return Collections.unmodifiableList(record);
    }
}
