package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(int countOfPerson) {
        if (countOfPerson < 1) {
            throw new IllegalArgumentException("인원은 적어도 1명 이상이어야 합니다: " + countOfPerson);
        }
        points = new ArrayList<>(4);
        for (int i = 0; i < countOfPerson; i++) {
            points.add(new Point(i));
        }
    }

    public int getPointsSize() {
        return points.size();
    }

    public void createBridge(int createAt) {
        if (createAt >= points.size() - 1 || createAt < 0) {
            throw new IllegalStateException("해당 지점에 사다리를 지을 수 없습니다: " + createAt);
        }
        if (!points.get(createAt).equals(new Point(createAt))) {
            throw new IllegalStateException("해당 지점에 사다리가 존재합니다: " + createAt);
        }
        points.set(createAt, new Point(createAt + 1));
        points.set(createAt + 1, new Point(createAt));
    }

    public Point move(int from) {
        return points.get(from);
    }
}
