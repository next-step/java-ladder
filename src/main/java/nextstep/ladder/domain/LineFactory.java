package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

    public static List<Boolean> createLine(int countOfPerson, LineStrategy lineStrategy) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;
        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean isLine = !previous && lineStrategy.isLine();
            points.add(isLine);
            previous = isLine;
        }
        return points;
    }

}
