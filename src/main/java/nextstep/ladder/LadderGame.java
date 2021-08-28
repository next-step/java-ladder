package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Person;
import nextstep.ladder.model.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderGame {
    public static List<Person> makePeople(String input) {
        if ("".equals(input.trim())) {
            throw new IllegalArgumentException("참가자가 없습니다.");
        }

        return Arrays.stream(input.split(","))
                .map((name) -> new Person(name))
                .collect(Collectors.toList());
    }

    private static final Random RANDOM = new Random();

    public static Ladder makeLadder(int numberOfPeople, int height) {
        if (numberOfPeople <= 0 || height <= 0) {
            throw new IllegalArgumentException("참가자가 없거나, 사다리의 길이거 존재하지 않습니다.");
        }

        List<Line> lines = makeLines(numberOfPeople, height);

        for (int i = 0; i < height; i++) {
            makeStairs(lines, i);
        }

        return new Ladder(lines, height);
    }

    private static void makeStairs(List<Line> lines, int index) {
        for (int i = 0; i < lines.size() - 1; i++) {
            if (RANDOM.nextBoolean()) {
                Line line01 = lines.get(i);
                Line line02 = lines.get(i + 1);

                makeStair(line01, line02, index);
            }
        }
    }

    private static void makeStair(Line line01, Line line02, int index) {
        Point point01 = line01.getPoint(index);
        Point point02 = line02.getPoint(index);

        if (point01.isUsed() || point02.isUsed()) {
            return;
        }

        point01.use(line02.getIndex());
        point02.use(line01.getIndex());
    }

    private static List<Line> makeLines(int numberOfPeople, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            lines.add(new Line(height, i));
        }

        return lines;
    }
}
