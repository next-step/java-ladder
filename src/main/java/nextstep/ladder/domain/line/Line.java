package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.Users;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(Users users, LineCreateStrategy lineCreateStrategy) {
        points.add(lineCreateStrategy.createFirstPoint());

        for (int i = 1; i < users.getSize(); i++) {
            boolean nextPoint = lineCreateStrategy.createNextPoint(points.get(i - 1));
            points.add(nextPoint);
        }
    }
}
