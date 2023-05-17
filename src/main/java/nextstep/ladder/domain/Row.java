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
        for (int x = 0; x < usersCount; x++) {
            row.add(generator.generate(existLeft(row, x), x));
        }
        return new Row(row);
    }

    public static boolean existLeft(List<Point> row, int x) {
        boolean movableLeft = false;
        if (x != 0) {
            movableLeft = row.get(x - 1).movableRight();
        }
        return movableLeft;
    }

    public int getNextX(int x) {
        return row.get(x).nextX(x);
    }

    public List<PointDto> toPointDtos() {
        return row.stream().map(Point::toDto).collect(Collectors.toList());
    }
}
