package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderLine {
    private List<Point> points;

    LadderLine(int countOfPerson) {
        Random random = new Random();
        points = new ArrayList<>();
        points.add(new Point(false));
        points.add(new Point(random.nextBoolean()));

        IntStream.range(2, countOfPerson).forEach(i -> {
            Point pointElement = new Point(random.nextBoolean());
            points.add(points.get(i - 1).checkDuplicate(pointElement)); // 세번째 요소부터 중복체크
        });

    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }
}
