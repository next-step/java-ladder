package nextstep.ladder.domain;

import nextstep.ladder.exception.LineDuplicateException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Direction.*;

public class Line {
    private static final Random random = new Random();

    private final List<Direction> directions;

    public Line(int[] directions) {
        this(Arrays.stream(directions)
                .mapToObj(Direction::of)
                .collect(Collectors.toList())
        );
    }

    public Line(Direction direction) {
        this(List.of(direction));
    }

    public Line(int countOfPerson) {
        this(createDirections(countOfPerson));
    }

    public Line(List<Direction> directions) {
        validateDirectionsContinuity(directions);
        this.directions = new ArrayList<>(directions);
    }

    private void validateDirectionsContinuity(List<Direction> directions) {
        IntStream.range(0, directions.size() - 1)
                .filter(index -> directions.get(index).isLeft() && directions.get(index + 1).isLeft())
                .findFirst()
                .ifPresent(i -> {
                    throw new LineDuplicateException();
                });
    }

    private static List<Direction> createDirections(int countOfPerson) {
        List<Direction> directions = new ArrayList<>();
        while (directions.size() < countOfPerson - 1) {
            createDirection(countOfPerson, directions);
        }
        return directions;
    }

    private static void createDirection(int countOfPerson, List<Direction> directions) {
        Direction direction = Direction.of(random.nextInt(2));
        directions.add(direction);

        if (direction == RIGHT) {
            directions.add(LEFT);
        }
        if (directions.size() == countOfPerson - 1) {
            directions.add(STAY);
        }
    }

    public Direction move(int position) {
        return directions.get(position);
    }

    public int size() {
        return directions.size();
    }

    public List<Direction> directions() {
        return Collections.unmodifiableList(directions);
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
