package com.jaeyeonling.ladder;

import java.util.ArrayList;
import java.util.List;

public abstract class RoleBaseLineGenerator implements LineGenerator {

    abstract Boolean generate(final Boolean before);

    @Override
    public Line generate(final CountOfUsers countOfUsers) {
        final List<Boolean> points = generatePoints(countOfUsers);

        return Line.of(points);
    }

    private List<Boolean> generatePoints(final CountOfUsers countOfUsers) {
        final List<Boolean> points = initializePoints();
        for (int i = points.size(); i < countOfUsers.getValue(); i++) {
            final Boolean before =points.get(points.size() - 1);

            final Boolean point = generate(before);

            points.add(point);
        }

        return points;
    }

    private List<Boolean> initializePoints() {
        final List<Boolean> points = new ArrayList<>();

        points.add(false);

        return points;
    }
}
