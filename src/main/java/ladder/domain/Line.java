package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private List<Point> pointList;

    Line(int countOfPerson) {
        Random random = new Random();
        pointList = new ArrayList<>();
        pointList.add(new Point(false));
        pointList.add(new Point(random.nextBoolean()));

        IntStream.range(2, countOfPerson).forEach(i -> {
            Point pointElement = new Point(random.nextBoolean());
            pointList.add(pointList.get(i - 1).checkDuplicate(pointElement)); // 세번째 요소부터 중복체크
        });

    }

    public List<Point> getPointList() {
        return pointList;
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
