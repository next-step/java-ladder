package nextstep.domain;

import nextstep.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private LineStrategy lineStrategy;

    public Line(int countPerson, LineStrategy lineStrategy) {
        if (countPerson < 2) {
            throw new IllegalArgumentException("2명 이상 필요하다.");
        }
        this.lineStrategy = lineStrategy;

        points = of(countPerson, lineStrategy);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public List<Boolean> of(int count, LineStrategy lineStrategy) {
        for (int i = 0; i < count - 1; i++) {
            points.add(false);
        }

        for (int point = 0; point < points.size(); point++) {
            points.set(point, setStrategy(point, lineStrategy));
        }

        return points;
    }

    private Boolean setStrategy(int point, LineStrategy lineStrategy) {
        if (hasNotStrategy(point) == false) {
            return lineStrategy.generate();
        }
        return false;
    }

    private boolean hasNotStrategy(int point) {
        if (point < 0 || point > points.size() + 1) {
            throw new IllegalArgumentException("해당 point 에 line 을 놓을 수 없다.");
        }

        // 양사이드 true 체크
        return point > 0 && points.get(point - 1).equals(true)
                || point < points.size() - 1&& points.get(point + 1).equals(true);
    }
}
