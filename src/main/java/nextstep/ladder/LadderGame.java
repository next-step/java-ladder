package nextstep.ladder;

import nextstep.ladder.model.Ladder;
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

    public static Ladder makeLadder(int numberOfPeople, int height) {
        if (numberOfPeople <= 0 || height <= 0) {
            throw new IllegalArgumentException("참가자가 없거나, 사다리의 길이거 존재하지 않습니다.");
        }

        List<Line> lines = makeLines(numberOfPeople, height);

        for (int i = 0; i < height; i++) {
            makeStairs(lines, i);
        }

        return new Ladder(lines);
    }

    private static void makeStairs(List<Line> lines, int height) {
        for (int index = 0; index < lines.size() - 1; index++) {
            int origin = index;
            int destination = index + 1;

            makeStair(lines, origin, destination, height);
        }
    }

    private static void makeStair(List<Line> lines, int origin, int destination, int height) {
        if (!RANDOM.nextBoolean()) {
            return;
        }

        Line lineOrigin = lines.get(origin);
        Line lineDestination = lines.get(destination);

        if (lineOrigin.isUsedPoint(height) || lineDestination.isUsedPoint(height)) {
            return;
        }

        lineOrigin.usePointDestination(destination, height);
        lineDestination.usePointDestination(origin, height);
    }

    private static List<Line> makeLines(int numberOfPeople, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            lines.add(new Line(height));
        }

        return lines;
    }
}
