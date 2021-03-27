package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final String MINIMUM_PERSON_ERRRO = "2명 이상 참여해야합니다.";
    private static final int MINIMUM_PERSON = 2;
    private static final int POINT_START_INDEX = 0;

    private final List<Boolean> points;

    public Line (int countOfPerson) {
        isPersonUnderTwo(countOfPerson);
        this.points = createPoints(countOfPerson);
    }

    private void isPersonUnderTwo(int countOfPerson) {
        if (MINIMUM_PERSON > countOfPerson) {
            throw new IllegalArgumentException(MINIMUM_PERSON_ERRRO);
        }
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
