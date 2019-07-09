package com.jaeyeonling.ladder2.domain.line;

import com.jaeyeonling.ladder2.domain.Index;
import com.jaeyeonling.ladder2.domain.user.Users;
import com.jaeyeonling.ladder2.view.StringVisualizable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Line implements StringVisualizable {

    private static final int SIZE_TERM = 1;

    private final List<Direction> directions;

    private Line(final DirectionGenerateStrategy directionGenerateStrategy,
                 final int countOfUsers) {
        directions = new ArrayList<>();
        init(directionGenerateStrategy, countOfUsers);
    }

    public static Line generate(final DirectionGenerateStrategy strategy,
                                final Users users) {
        return new Line(strategy, users.size());
    }

    public Index move(final Index index) {
        return directions.get(index.getIndex())
                .move(index);
    }

    @Override
    public String visualize() {
        return directions.stream()
                .map(Direction::visualize)
                .collect(joining());
    }

    private void init(final DirectionGenerateStrategy strategy,
                      final int countOfUsers) {
        initFirst(strategy);
        initMiddle(strategy, countOfUsers);
        initLast();
    }

    private void initFirst(final DirectionGenerateStrategy strategy) {
        directions.add(Direction.first(strategy));
    }

    private void initMiddle(final DirectionGenerateStrategy strategy,
                            final int initSize) {
        IntStream.range(directions.size(), initSize - SIZE_TERM)
                .mapToObj(ignore -> getLastDirection().next(strategy))
                .forEach(directions::add);
    }

    private void initLast() {
        directions.add(getLastDirection().last());
    }

    private Direction getLastDirection() {
        return directions.get(directions.size() - SIZE_TERM);
    }
}