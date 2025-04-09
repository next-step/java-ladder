package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int userCount, LineCreateStrategy lineCreateStrategy) {
        if (userCount <= 1) {
            throw new IllegalArgumentException("유저는 2명 이상이여야 합니다.");
        }

        points.add(lineCreateStrategy.createFirstPoint());
        for (int i = 1; i < userCount; i++) {
            boolean nextPoint = lineCreateStrategy.createNextPoint(points.get(i - 1));
            points.add(nextPoint);
        }
    }
}
