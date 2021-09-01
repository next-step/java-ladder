package nextstep.ladder;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.Person;

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

    public static List<Line> makeLines(int numberOfPeople, int height) {
        if (numberOfPeople <= 0 || height <= 0) {
            throw new IllegalArgumentException("참가자가 없거나, 사다리의 길이거 존재하지 않습니다.");
        }

        List<Line> lines = makeDefaultLines(numberOfPeople, height);

        for (int i = 0; i < height; i++) {
            makeStairs(lines, i);
        }

        return lines;
    }

    private static void makeStairs(List<Line> lines, int height) {
        for (int index = 0; index < lines.size() - 1; index++) {
            int origin = index;
            int destination = index + 1;

            makeStair(lines.get(origin), destination, height);
            makeStair(lines.get(destination), destination, height);
        }
    }

    private static void makeStair(Line line, int destination, int height) {
        if (!RANDOM.nextBoolean()) {
            return;
        }

        if (line.isUsedPoint(height)) {
            return;
        }

        line.usePointDestination(destination, height);
    }

    private static List<Line> makeDefaultLines(int numberOfPeople, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            lines.add(new Line(height));
        }

        return lines;
    }
}
