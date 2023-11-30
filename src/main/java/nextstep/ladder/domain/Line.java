package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;
import java.util.*;
import java.util.stream.Collectors;

import static nextstep.ladder.domain.Direction.*;

public class Line {
    private static final Random random = new Random();

    private final Directions directions;

    public Line(int[] directions) {
        this(Arrays.stream(directions)
                .mapToObj(Direction::of)
                .collect(Collectors.toList())
        );
    }

    public Line(Direction direction) {
        this(List.of(direction));
    }

    public Line(DirectionStrategy directionStrategy, int countOfPerson) {
        this(createDirections(directionStrategy, countOfPerson));
    }

    public Line(List<Direction> directions) {
        this.directions = new Directions(directions);
    }

    private static List<Direction> createDirections(DirectionStrategy directionStrategy, int countOfPerson) {
        List<Direction> directions = new ArrayList<>();
        while (directions.size() < countOfPerson - 1) {
            createDirection(directionStrategy, countOfPerson, directions);
        }
        return directions;
    }

    private static void createDirection(DirectionStrategy directionStrategy, int countOfPerson, List<Direction> directions) {
        Direction direction = directionStrategy.direction();
        directions.add(direction);

        if (direction == RIGHT) {
            directions.add(LEFT);
        }
        if (directions.size() == countOfPerson - 1) {
            directions.add(STAY);
        }
    }

    public int move(int position) {
        return directions.move(position);
    }

    public int size() {
        return directions.size();
    }

    public Directions directions() {
        return directions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(directions, line.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directions);
    }
}
