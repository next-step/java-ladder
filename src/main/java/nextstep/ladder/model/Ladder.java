package nextstep.ladder.model;

import nextstep.ladder.model.value.Line;
import nextstep.ladder.model.value.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_NUMBER = 0;

    private static List<Line> lines = new ArrayList<>();

    private Ladder(int height, int countOfPerson, Random random) {

        IntStream.range(START_NUMBER, height)
                .forEach(i -> lines.add(new Line(countOfPerson - 1 , random)));

    }

    public static Ladder of(int height, int countOfPerson) {
        return new Ladder(height, countOfPerson, new Random());
    }

    public static Ladder of(int height, int countOfPerson, Random random) {
        return new Ladder(height, countOfPerson, random);
    }

    public Position execute(Position position) {
        Position tempPosition = position;

        for (Line line : lines) {
            tempPosition = tempPosition.move(line);
        }

        return tempPosition;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }


}
