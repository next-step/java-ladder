package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, LineStrategy lineStrategy) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        boolean previous = false;
        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean isLine = !previous && lineStrategy.isLine();
            points.add(isLine);
            previous = isLine;
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }


    public boolean getLine(int idx) {
        return points.get(idx);
    }

    public int size() {
        return points.size();
    }

    public Line getLine() {
        return this;
    }
}
