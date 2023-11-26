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
        while (directions.size() < countOfPerson) {
            addDirection(countOfPerson, directions);
        }
        adjustDirections(directions);
        return new Line(directions);
    }

    private static void addDirection(int countOfPerson, List<Direction> directions) {
        Direction direction = of(randomDirection(countOfPerson, directions.size()));

        directions.add(direction);
        boolean continuity = false;
        if (direction == RIGHT && isContainSize(countOfPerson, directions)) {
            directions.add(LEFT);
            continuity = true;
        }

        if (continuity && isContainSize(countOfPerson, directions)) {
            directions.add(STAY);
        }
    }

    private static boolean isContainSize(int countOfPerson, List<Direction> directions) {
        return directions.size() < countOfPerson;
    }

    private static int randomDirection(int countOfPerson, int directionSize) {
        if (directionSize == 0) {
            return random.nextInt(2); // 0,  1
        }

        if (directionSize == countOfPerson - 1) {
            return random.nextInt(2) - 1;// -1, 0
        }

        return random.nextInt(3) - 1; // -1, 0, 1
    }

    private static void adjustDirections(List<Direction> directions) {
        IntStream.range(0, directions.size() - 1)
                .forEach(index -> adjustDirection(directions, index));
    }

    private static void adjustDirection(List<Direction> directions, int index) {
        int prevIndex = index;
        int nextIndex = index + 1;
        if (isLastIndexSetStay(directions, prevIndex, nextIndex)) {
            return;
        }

        Direction prev = directions.get(prevIndex);
        Direction next = directions.get(nextIndex);
        if (LEFT == prev && LEFT == next) {
            directions.set(nextIndex, RIGHT);
        }
    }

    private static boolean isLastIndexSetStay(List<Direction> directions, int prevIndex, int nextIndex) {
        if (directions.get(prevIndex) == LEFT && nextIndex == directions.size() - 1) {
            directions.set(nextIndex, STAY);
            return true;
        }
        return false;
    }

}
