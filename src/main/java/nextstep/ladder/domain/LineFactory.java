package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Direction.*;

public class LineFactory {

    private LineFactory() {
    }

    private static Random random = new Random();

    public static Line createLine(int countOfPerson) {
        if (countOfPerson == 1) {
            return new Line(List.of(STAY));
        }
        List<Direction> directions = new ArrayList<>();
        for (int index = 0; directions.size() < countOfPerson; index++) {
            addDirection(countOfPerson, index, directions);
        }
        adjustDirections(directions);
        return new Line(directions);
    }

    private static void addDirection(int countOfPerson, int index, List<Direction> directions) {
        int numberOfDirection = directionByIndex(countOfPerson, index);
        Direction direction = of(numberOfDirection);

        directions.add(direction);
        if (direction == RIGHT) {
            directions.add(LEFT);
        }
    }

    private static int directionByIndex(int countOfPerson, int index) {
        if (index == 0) {
            return random.nextInt(2); // 0,  1
        }

        if (index == countOfPerson - 1) {
            return random.nextInt(2) - 1; // -1, 0
        }

        return random.nextInt(3) - 1; // -1, 0, 1
    }

    private static void adjustDirections(List<Direction> directions) {
        IntStream.range(0, directions.size() - 1)
                .forEach(index -> adjustDirection(directions, index));
    }

    private static void adjustDirection(List<Direction> directions, int index) {
        Direction prev = directions.get(index);
        Direction next = directions.get(index + 1);
        if (LEFT == prev && LEFT == next) {
            directions.set(index + 1, RIGHT);
        }
    }

}
