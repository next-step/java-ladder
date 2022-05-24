package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ladder.util.Const.RANDOM;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        this.points = inspect(Stream.iterate(RANDOM.nextBoolean(), b -> next(b))
                .limit(countOfPerson - 1)
                .collect(Collectors.toList()));
    }

    static boolean next(Boolean b) {
        return b ? false : RANDOM.nextBoolean();
    }

    public Line(List<Boolean> points) {
        this.points = inspect(points);
    }

    public List<Boolean> points() {
        return inspect(this.points);
    }

    public static List<Boolean> inspect(List<Boolean> points) {
        if (Stream.iterate(1, i -> i < points.size(), i -> i + i)
                .anyMatch(i -> points.get(i - 1) &&  points.get(i))) {
            throw new RuntimeException("Consecutive line cannot exist.");
        }
        return points;
    }
}
