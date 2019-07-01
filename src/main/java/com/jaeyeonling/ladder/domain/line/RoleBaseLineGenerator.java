package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.point.Direction;
import com.jaeyeonling.ladder.domain.user.CountOfUsers;

import java.util.ArrayList;
import java.util.List;

public abstract class RoleBaseLineGenerator implements LineGenerator {

    abstract Direction generateFirst();
    abstract Direction generateMiddle(final Direction before);
    abstract Direction generateEnd(final Direction before);

    @Override
    public Line generate(final CountOfUsers countOfUsers) {
        final List<Direction> directions = new ArrayList<>();

        initializeFirst(directions);
        initializeMiddle(directions, countOfUsers.getValue() - Direction.DEFAULT_MOVING_DISTANCE_VALUE);
        initializeEnd(directions);

        return Line.ofDirections(directions);
    }

    private void initializeFirst(final List<Direction> directions) {
        directions.add(generateFirst());
    }

    private void initializeMiddle(final List<Direction> directions,
                                  final int end) {
        for (int i = directions.size(); i < end; i++) {
            final Direction before = extractBefore(directions);

            directions.add(generateMiddle(before));
        }
    }

    private void initializeEnd(List<Direction> directions) {
        final Direction before = extractBefore(directions);

        directions.add(generateEnd(before));
    }

    private Direction extractBefore(final List<Direction> directions) {
        return directions.get(directions.size() - Direction.DEFAULT_MOVING_DISTANCE_VALUE);
    }
}
