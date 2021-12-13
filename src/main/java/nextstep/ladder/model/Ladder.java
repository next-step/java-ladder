package nextstep.ladder.model;

import nextstep.ladder.model.value.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_NUMBER = 0;

    private static List<Line> lines = new ArrayList<>();

    private Ladder(List<Line> ladder) {
        lines = ladder;
    }

    public static Ladder of(int height, int countOfPerson) {

        IntStream.range(START_NUMBER, height)
                .forEach(i -> lines.add(new Line(countOfPerson - 1 , new Random())));

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }


}
