package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final int POINT_START_INDEX = 0;
    private final List<Boolean> points;

    public Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        this.points = createPoints(countOfPerson);
    }

    private List<Boolean> createPoints(int countOfPerson) {
        return IntStream.range(POINT_START_INDEX, countOfPerson)
                .mapToObj(this::createPoint)
                .collect(Collectors.toList());
    }

    public boolean createPoint(int pointIndex) {
        return false;
    }

    public List<Boolean> readOnlyPoints() {
        return Collections.unmodifiableList(points);
    }
}
