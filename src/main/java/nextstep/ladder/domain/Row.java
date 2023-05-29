package nextstep.ladder.domain;

import nextstep.ladder.dto.PointDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Row {
    List<Point> row;

    public Row(List<Point> row) {
        this.row = row;
    }

    public static Row of(PointGenerator generator, int usersCount) {
        List<Point> row = new ArrayList<>();
        Point point = Point.first(generator.generate());
        row.add(point);
        for (int i = 1; i < usersCount - 1; i++) {
            point = point.next(generator.generate());
            row.add(point);
        }
        row.add(point.last());
        return new Row(row);
    }

    public Position move(Position position) {
        return position.move(row);
    }

    public List<PointDto> toPointDtos() {
        return row.stream().map(Point::toDto).collect(Collectors.toList());
    }
}
